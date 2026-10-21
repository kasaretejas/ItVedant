import React, { useContext, useEffect, useState } from 'react'
import { LoggedInUserContext } from '../project_context/LoggedInUserContext'
import { toast } from 'react-toastify'
import { useNavigate } from 'react-router-dom'

export default function Cart() {
    let { userData, setUserData }=useContext(LoggedInUserContext)
    let[cartItems, setCartItems]=useState(null)
    async function getCartItems()
    {
        let response=await fetch(`http://localhost:8080/api/v1/customer/carts/${userData.id}`,
                {
                    method:"get",
                    headers : 
                            {
                                "Authorization":`Bearer ${userData.jwtToken}`
                            }
                })
        let responseObject=await response.json()
        if(response.ok)
        {
            setCartItems(responseObject.data)
            console.log(responseObject.data);  
        }
    }
    useEffect(()=>{ getCartItems() },[])

    async function deleteCartItem(cartId)
    {
        let response=await fetch(`http://localhost:8080/api/v1/customer/carts/${cartId}`,
                {
                    method:"delete",
                    headers : 
                            {
                                "Authorization":`Bearer ${userData.jwtToken}`
                            }
                })
        let responseObject=await response.json()
        if(response.ok)
        {
            toast.success(responseObject.message)  
            getCartItems()
        }
        else
        {
            toast.error(responseObject.message)    
        }
    }

    async function changeQuantity(cartId,quantity)
    {
        if(quantity<1 || quantity>5)
        {
            return
        }
        else
        {
            let response=await fetch(`http://localhost:8080/api/v1/customer/carts/${cartId}/${quantity}`,
                {
                    method:"put",
                    headers : 
                            {
                                "Authorization":`Bearer ${userData.jwtToken}`
                            }
                })
            let responseObject=await response.json()
            if(response.ok)
            {
                toast.success(responseObject.message)  
                getCartItems()
            }
            else
            {
                toast.error(responseObject.message)    
            }  
        }
    }
 let totalCost =  cartItems?cartItems.reduce((sum, item)=>{return sum + item.product.price * item.qunatity},0):0
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
let navigateTo=useNavigate()
async function handlePayment() {


  // Load Razorpay SDK
  const isLoaded = await loadRazorpayScript();


  if (!isLoaded) {
    toast.error("Razorpay SDK failed to load");
    return;
  }


  // Create order from Spring Boot
  console.log(`http://localhost:8080/api/v1/customer/create-order?amount=${totalCost}&currency=INR&customerId=${userData.id}`);
 
  const createOrderResponse = await fetch(
    `http://localhost:8080/api/v1/customer/create-order?amount=${totalCost}&currency=INR&customerId=${userData.id}`,
    {
      method: "POST",
      headers: {
        "Authorization": `Bearer ${userData.jwtToken}`
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
    key: "rzp_test_TiD1BAW7x4d2v2", // Your Key ID


    amount: totalCost*100,
    currency: order.currency,
    order_id: order.id,


    name: "Shopify",


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
                "Authorization": `Bearer ${userData.jwtToken}`
            },
            body: JSON.stringify({
                razorpayOrderId: paymentResponse.razorpay_order_id,
                razorpayPaymentId: paymentResponse.razorpay_payment_id,
                razorpaySignature: paymentResponse.razorpay_signature,
                customerId: userData.id
            })
        });


    if(verifyResponse.ok){
        toast.success("Payment Successful");
        navigateTo("/"); //const navigate=useNavigate() import above


    }
    else{
        toast.error("Payment Verification Failed");
    }
    },


    prefill: {
      name: userData.name
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
    <div className='container mt-4'>
        {
            cartItems && cartItems.length>0?
            <div className='row'>
                <div className='col-9'>
                    <table className="table table-hover table-bordered text-center">
                        <thead className='text-center'>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">IMAGE</th>
                                <th scope="col">PRODUCT NAME</th>
                                <th scope="col">UNIT PRICE</th>
                                <th scope="col">QUANTITY</th>
                                <th scope="col">FINAL PRICE</th>
                                <th scope="col">DELETE</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                cartItems.map(cartItem => {
                                    return <tr key={cartItem.id}>
                                                <td>{cartItem.id}</td>
                                                <td>
                                                    <img src={`http://localhost:8080/api/v1/images/${cartItem.product.imageName}`} alt="" style={{width:"50px", height:"50px"}}  />
                                                </td>
                                                <td>{cartItem.product.name}</td>
                                                <td>₹{cartItem.product.price}</td>
                                                <td>
                                                    <button className='me-3 btn btn-danger' onClick={()=>{changeQuantity(cartItem.id, cartItem.qunatity-1)}}>-</button>
                                                    {cartItem.qunatity}
                                                    <button className='ms-3 btn btn-success' onClick={()=>{changeQuantity(cartItem.id, cartItem.qunatity+1)}}>+</button>
                                                </td>
                                                <td>₹{cartItem.product.price * cartItem.qunatity}</td>
                                                <td>
                                                    <button className='btn btn-danger' onClick={()=>{deleteCartItem(cartItem.id)}}>
                                                        <i className="bi bi-trash3"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                })
                            }
                        </tbody>
                    </table>
                </div>
                <div className='col-3 border border-1 rounded-2 text-center d-flex flex-column align-items-center justify-content-center'>
                    <h3>Total Price</h3>
                    <h4>₹{totalCost.toLocaleString("en-IN")}</h4>
                    <button className='btn btn-primary w-75' onClick={handlePayment}>Pay Now</button>
                </div>
            </div> : <h1>There are no products in the cart</h1>
            }
    </div>
  )
}
