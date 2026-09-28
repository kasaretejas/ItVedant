import React, { useEffect, useState } from 'react'
import { useNavigate, useSearchParams } from 'react-router-dom'
import { toast } from 'react-toastify'

export default function Cart() {
  let[cartItems, setCartItems]=useState(null)
  let loggedInUser=JSON.parse(localStorage.getItem("user"))
  const navigate=useNavigate()
  
  useEffect(()=>{
    async function getCartProductsByCustomerId()
    {
        let response = await fetch(`http://localhost:8080/api/v1/customer/${loggedInUser.id}/cart`,
          {
              headers:{"Authorization":`Bearer ${loggedInUser.token}`}
          })
        let responseObject=await response.json()
        console.log(responseObject);
        
        if(response.ok)
        {
            setCartItems(responseObject.data)
        }  
    }
    getCartProductsByCustomerId()
  },[])

  // final total and subtotal calculation 
  const DELIVERY_CHARGE = 50;
  const DISCOUNT = 70;

  const subtotal = cartItems
  ? cartItems.reduce((sum, cartItem) => 
    {
      return sum + cartItem.product.price * cartItem.quantity;
    }, 0)
  : 0;

  const total = subtotal + DELIVERY_CHARGE - DISCOUNT;

  //update quantity functionality 
  async function updateQuantity(cartId, newQuantity)
  {

    if(newQuantity < 1)
      {
        return;
      }

    let response = await fetch(`http://localhost:8080/api/v1/customer/cart/${cartId}?quantity=${newQuantity}`,
      {
        method:"PUT",
        headers:
        {
            "Authorization":`Bearer ${loggedInUser.token}`
        }
    });

    if(response.ok){

        const updatedCart = cartItems.map(item=>{

            if(item.id===cartId){
                return {...item,quantity:newQuantity};
            }

            return item;

        });

        setCartItems(updatedCart);
    }
}

  // remove item from cart functionality
  async function removeFromCart (cartId)
  {

    let response = await fetch(`http://localhost:8080/api/v1/customer/cart/${cartId}`,{
        method:"delete",
        headers:{
            "Authorization":`Bearer ${loggedInUser.token}`
        }
    });
    let responseObject = await response.json()
    if(response.ok){
        toast.success(responseObject.message)
        const updatedCart = cartItems.filter(item=>item.id!==cartId);
        setCartItems(updatedCart);
    }

  }


//loading razorpay script
// Load Razorpay SDK
function loadRazorpayScript() {
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
async function handlePayment() {

  // Load Razorpay SDK
  const isLoaded = await loadRazorpayScript();

  if (!isLoaded) {
    toast.error("Razorpay SDK failed to load");
    return;
  }

  // Create order from Spring Boot
  console.log(`http://localhost:8080/api/v1/customer/create-order?amount=${total}&currency=INR&customerId=${loggedInUser.id}`);
  
  const createOrderResponse = await fetch(
    `http://localhost:8080/api/v1/customer/create-order?amount=${total}&currency=INR&customerId=${loggedInUser.id}`,
    {
      method: "POST",
      headers: {
        "Authorization": `Bearer ${loggedInUser.token}`
      }
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
    key: "rzp_test_TEyzYdk68AhvOM", // Your Key ID

    amount: total*100,
    currency: order.currency,
    order_id: order.id,

    name: "Easy-Mart",

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
                "Authorization": `Bearer ${loggedInUser.token}`
            },
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
    <div className='container mt-5'>
      <div className="row align-items-start">
        <div className="col-9">
          <h3>Your Cart</h3>
          <hr />
          { cartItems?
            cartItems.map((cartItem)=>{
              return <div className='border rounded-2 p-2 w-100 d-flex justify-content-between mb-1'>
            {/* left part : product details  */}
            <div className='w-100'>
              <h6 className='text-capitalize'>{cartItem.product.name}</h6>
              <div className="container">
                <div className='row'>
                <div className='d-flex  col-4'>
                    <div className=''>
                        <img src={`http://localhost:8080/api/v1/images/${cartItem.product.imageName}`} alt="" style={{height:"100px", width:"100px"}}/>
                    </div>
                    <div className='d-flex flex-column ms-2 lh-1'>
                      <p>SKU-921</p>
                      <p className='text-capitalize'>{cartItem.product.brand}</p>
                      <p className='bg-success text-light px-1'>In Stock</p>
                    </div>
                </div>
                <div className=' col-2 text-center'>
                  <p>Each</p>
                  <h6 className='mt-4'>₹ {cartItem.product.price}</h6>
                </div>
                <div className=' text-center col-3'>
                  <p>Quantity</p>
                  <div className='d-flex justify-content-center align-items-center'>
                    <p className='fs-4' style={{cursor:"pointer"}} onClick={() => updateQuantity(cartItem.id, cartItem.quantity-1)}>
                      <i class="bi bi-dash-circle" ></i>
                    </p>
                    <p className='p-2 mx-3'>{cartItem.quantity}</p>
                    <p className='fs-4' style={{cursor:"pointer"}} onClick={() =>updateQuantity(cartItem.id, cartItem.quantity+1)}>
                      <i class="bi bi-plus-circle" ></i>
                    </p>
                  </div>
                </div>
                <div className=' col-3 text-center'>
                  <p>Total</p>
                  <h6 className='mt-4'>₹ {Number(cartItem.product.price) * Number(cartItem.quantity)}</h6>
                </div>
                </div>
              </div>
            </div>

            {/* right part : delete button  */}
            <div className='bg-body-secondary p-2 d-flex align-items-center' style={{cursor:"pointer"}}>
              <h6 onClick={()=>removeFromCart(cartItem.id)}>x</h6>
            </div>
          </div>
            })
          : <div>
            <h1>Your cart is empty</h1>
            <img src="http://localhost:3000/empty_bin.gif" alt="" style={{height:"100px", width:"100px"}}/>
          </div> }
          
        </div>
        <div className="col-3 bg-body-secondary rounded-2 p-2">
          <h3>Order Summary</h3>
          <hr />
          <p>Enter Promo Code</p>
          <div className='d-flex'>
            <input type="text" placeholder='Promo Code' className='form-control me-2'/>
            <button className='btn btn-dark text-light'>Submit</button>
          </div>
          <hr />
          <div className='d-flex justify-content-between p-3'>
            <div>
              <p>Subtotal</p>
              <p>Delivery</p>
              <p className='text-danger'>Discount</p>
              <hr />
              <h5>Total</h5>
            </div>
            <div>
              <p>₹ {subtotal}</p>
              <p>₹ {DELIVERY_CHARGE}</p>
              <p className='text-danger'>₹ -{DISCOUNT}</p>
              <hr />
              <h5>₹ {total}</h5>
            </div>
          </div>
          <button className='btn w-100 text-light fs-6' style={{backgroundColor:"orange"}} onClick={handlePayment}>CHECKOUT</button>
        </div>
      </div> 
    </div>
  )
}
