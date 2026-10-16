import React, { useContext, useEffect, useState } from 'react'
import { LoggedInUserContext } from '../project_context/LoggedInUserContext'
import { toast } from 'react-toastify'

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
  return (
    <div className='container mt-4'>
        {
            cartItems && cartItems.length>0?
            <div className='row'>
                <div className='col-9'>
                    <table class="table table-hover table-bordered text-center">
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
                                    return <tr>
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
                                                        <i class="bi bi-trash3"></i>
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
                    <button className='btn btn-primary w-75'>Pay Now</button>
                </div>
            </div> : <h1>There are no products in the cart</h1>
            }
    </div>
  )
}
