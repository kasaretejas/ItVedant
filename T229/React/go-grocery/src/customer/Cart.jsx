import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'

export default function Cart() 
{
  let loggedInUser=JSON.parse(localStorage.getItem("user"))
  let [cartItems, setCartItems]=useState(null)
  let [totalCartItems, setTotalCartItems]=useState(0)
  let [isCartUpdated, setIsCartUpdated] = useState(false)
  let [finalPrice , setFinalPrice] = useState(0)
  async function getCartItemsByCustomerId()
  {
    setIsCartUpdated(false)
    let response=await fetch(`http://localhost:8080/api/v1/customer/carts/${loggedInUser.id}`,
      {
        headers:{Authorization:`Bearer ${loggedInUser.jwtToken}`},
      })
    let responseObject=await response.json()
    console.log(responseObject);
    if(response.ok) 
      {
        setCartItems(responseObject.data)
        setTotalCartItems(responseObject.data.length)
        
      } 
  }
  useEffect(()=>{ getCartItemsByCustomerId() }, [isCartUpdated])

  //delete cart item
  async function deleteCartItem(cartId)
  {
    let response=await fetch(`http://localhost:8080/api/v1/customer/carts/${cartId}`,
      {
        method:"delete",
        headers:{Authorization:`Bearer ${loggedInUser.jwtToken}`},
      })
    let responseObject=await response.json()

    if(response.ok) 
    {
      toast.success(responseObject.message)
      let cartItemsAfterDelete = cartItems.filter(cartItem => cartItem.id!=cartId)
      setCartItems(cartItemsAfterDelete)
      setTotalCartItems(totalCartItems-1)
    } 
    else
    {
      toast.error(responseObject.message)
    }
  }

  //change Quantity 
  async function changeQuantity(cartId, quantity)
  {
   if(quantity<1) return
    let response=await fetch(`http://localhost:8080/api/v1/customer/carts/${cartId}/${quantity}`,
      {
        method:"put",
        headers:{Authorization:`Bearer ${loggedInUser.jwtToken}`},
      })
    let responseObject=await response.json()

    if(response.ok) 
    {
      toast.success(responseObject.message)
      setIsCartUpdated(true)
    } 
    else
    {
      toast.error(responseObject.message)
    }
  }

  //total sum of products in the cart
  let totalSum = cartItems?cartItems.reduce((sum, cartItem) => {return sum + (cartItem.product.price*cartItem.quantity)}, 0) :0
  
  //razzorpay code
  function loadRazorpayScript() 
  {
  return new Promise((resolve) => {
    const script = document.createElement("script");
    script.src = "https://checkout.razorpay.com/v1/checkout.js";


    script.onload = () => {
      resolve(true);
    };


    script.onerror = () => {
      resolve(false);
    };


    document.body.appendChild(script);
  });
}

//handle payment
const navigate=useNavigate()
async function handlePayment() {
  // Load Razorpay SDK
  const isLoaded = await loadRazorpayScript();


  if (!isLoaded) {
    toast.error("Razorpay SDK failed to load");
    return;
  }


  // Create order from Spring Boot
  console.log(`http://localhost:8080/api/v1/customer/create-order?amount=${totalSum}&currency=INR&customerId=${loggedInUser.id}`);
 
  const createOrderResponse = await fetch(
    `http://localhost:8080/api/v1/customer/create-order?amount=${totalSum}&currency=INR&customerId=${loggedInUser.id}`,
    {
      method: "POST",
     headers:{Authorization:`Bearer ${loggedInUser.jwtToken}`}
    }
  );


  const order = await createOrderResponse.json();
console.log("order");
console.log(order);




 


  if (!createOrderResponse.ok) {
    toast.error("Unable to create order");
    return;
  }


  const options = {
    key: "rzp_test_TiD1BAW7x4d2v2", // Your Key ID


    amount: totalSum*100,
    currency: order.currency,
    order_id: order.id,


    name: "Go-Grocery",


    description: "Order Payment",


    handler: async function (paymentResponse) {


      console.log("paymentResponse");
      console.log(paymentResponse);


      //toast.success("Payment Successful");
      


      console.log("Payment Id :", paymentResponse.razorpay_payment_id);
      console.log("Order Id :", paymentResponse.razorpay_order_id);
      console.log("Signature :", paymentResponse.razorpay_signature);


      // Optional:
      // Send payment details to Spring Boot for signature verification
      const verifyResponse = await fetch(
        "http://localhost:8080/api/v1/customer/verify-payment",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                Authorization:`Bearer ${loggedInUser.jwtToken}`},
            
            body: JSON.stringify({
                razorpayOrderId: paymentResponse.razorpay_order_id,
                razorpayPaymentId: paymentResponse.razorpay_payment_id,
                razorpaySignature: paymentResponse.razorpay_signature,
                customerId: loggedInUser.id
            })
        });


    if(verifyResponse.ok){
        toast.success("Payment Successful");
        navigate("/my-orders"); //const navigate=useNavigate() import above


    }
    else{
        toast.error("Payment Verification Failed");
    }
    },


    prefill: {
      name: loggedInUser.name,
      email: loggedInUser.email,
      contact: loggedInUser.mobile
    },


    theme: {
      color: "#F37254"
    }
  };


  const razorpay = new window.Razorpay(options);


  razorpay.on("payment.failed", function (response) {


    toast.error("Payment Failed");


    console.log(response.error);
  });


  razorpay.open();
}

  return (
    <div className='container'>
      <h1>In Your Cart</h1> <span>{totalCartItems} Items</span>
      <div className='row '>
        {/* to show cart items  */}
        <div className='col-7'>
          {
            cartItems?cartItems.map(cart=>{
              return (
                <div className='row mb-1 p-1 border border-2 border-secondary  rounded-5'>
                  <div className='col-2 d-flex justify-content-center align-items-center '>
                    <img  src={`http://localhost:8080/api/v1/images/${cart.product.imageName}`} style={{height:"80px",width:"80px"}} />
                  </div>
                  <div className='col-7'>
                    <h4 className='text-capitalize'>{cart.product.name}</h4>
                    <p className='text-success'><i class="bi bi-check-lg me-1"></i> In Stock</p>
                    <div className='d-inline-flex border rounded-pill mb-2'>
                      <button class="btn border-0 shadow-none" onClick={()=>{changeQuantity(cart.id, cart.quantity-1)}}>-</button>
                      <button className='btn ps-3 pe-3' style={{cursor:"default"}}>{cart.quantity}</button>
                      <button className='btn  border-0 shadow-none' onClick={()=>{changeQuantity(cart.id, cart.quantity+1)}}>+</button>
                    </div>
                    <Link className='pe-auto ms-4 text-danger text-decoration-none' onClick={()=>{ deleteCartItem(cart.id)}}>Remove</Link>
                    
                  </div>
                  <div className='col-3 '>
                    <h4>₹ {cart.product.price}</h4>
                    <p className='text-decoration-line-through'>₹ {(cart.product.price)+50}</p>
                    {/* <span className='bg-warning rounded-pill px-2'>You Save ₹50</span> */}
                    <p className='bg-warning rounded-pill px-2'>{cart.product.price} x {cart.quantity} = {(cart.product.price) * (cart.quantity)}</p>
                  </div>
                </div>
              )
            }):"Loading"
          }
          
        </div>

        {/* to show final price */}
        <div className='col-5  text-center mt-auto mb-auto'>
          
              <h3>Total = ₹ {totalSum}</h3>
              <button className='btn btn-warning w-75' onClick={handlePayment}>Pay Now</button>
         
            
        </div>
      </div>
    </div>
  )
}
