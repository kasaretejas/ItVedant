import React, { useEffect, useState } from 'react'

export default function Cart() 
{
  let loggedInUser=JSON.parse(localStorage.getItem("user"))
  let [cartItems, setCartItems]=useState(null)
  let [totalCartItems, setTotalCartItems]=useState(0)
  async function getCartItemsByCustomerId()
  {
    
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

  useEffect(()=>{ getCartItemsByCustomerId() }, [])
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
                      <button class="btn border-0 shadow-none">-</button>
                      <button className='btn ps-3 pe-3' style={{cursor:"default"}}>1</button>
                      <button className='btn  border-0 shadow-none'>+</button>
                    </div>
                  </div>
                  <div className='col-3 '>
                    <h4>₹ {cart.product.price}</h4>
                    <p className='text-decoration-line-through'>₹ {(cart.product.price)+50}</p>
                    <span className='bg-warning rounded-pill px-2'>You Save ₹50</span>
                  </div>
                </div>
              )
            }):"Loading"
          }
          
        </div>

        {/* to show final price */}
        <div className='col-5 border border-danger'>

        </div>
      </div>
    </div>
  )
}
