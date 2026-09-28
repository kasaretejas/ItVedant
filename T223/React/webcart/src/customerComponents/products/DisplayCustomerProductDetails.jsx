import { Button } from 'bootstrap';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import { toast } from 'react-toastify';

export default function DisplayCustomerProductDetails() {
    const user = JSON.parse(localStorage.getItem("user"));
    console.log(user);
   let urlParams =  useParams()
   let [product,setProduct]=useState(null)
   useEffect(()=>{
        async function getProductById()
        {
            //let response = await fetch(`http://localhost:8080/api/v1/products/${urlParams.id}`)
            let response = await fetch(`http://localhost:8080/api/v1/get/products/${urlParams.id}`)
            let responseObject = await response.json()
            setProduct(responseObject.data)
        }
        getProductById()

   }, [])

   async function addToCart(productId)
   {
       // console.log(`http://localhost:8080/api/v1/customer/add-to-cart?customerId=${user.userId}&productId=${productId}`);

        let response= await fetch(`http://localhost:8080/api/v1/customer/add-to-cart?customerId=${user.userId}&productId=${productId}`,
                                        {
                                          headers : {Authorization: `Bearer ${user.token}`},
                                          method:"POST"
                                        })
                let responseObject = await response.json()
                if(response.ok)
                {
                    toast.success(responseObject.message)
                }
                else if (response.status === 302)
                {
                    toast.error(responseObject.message)
                }
                
        
   }
  return (
    <div className='container mt-5'>
      {
        product==null?"Loading....":
        <div class="card mb-3 w-100">
            <div class="row g-0">
                <div class="col-md-4  text-center">
                    <img src={`http://localhost:8080/images/${product.imageName}`} class="img-fluid rounded-start" alt="..."/>
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h3 class="card-title text-capitalize">{product.name}</h3>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p className='fw-bold'> &#8377; {product.price}</p>
                    </div>

                    <div className='mb-3 d-flex w-50 justify-content-between'>
                        <button className='btn btn-primary' onClick={()=>{addToCart(product.id)}}>Add to Cart</button>
                        <Link to={"/"} className='btn btn-success'>Buy Now</Link>
                    </div>
                </div> 
            </div>
        </div>
      }
    </div>
  )
}
