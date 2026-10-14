import React, { useContext, useEffect, useState } from 'react'
import { LoggedInUserContext } from '../project_context/LoggedInUserContext'

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
                                                <td>{cartItem.product.price}</td>
                                                <td>{cartItem.qunatity}</td>
                                                <td>{cartItem.product.price}</td>
                                            </tr>
                                })
                            }
                        </tbody>
                    </table>
                </div>
                <div className='col-3'>
                    pay now button
                </div>
            </div> : <h1>There are no products in the cart</h1>
            }
    </div>
  )
}
