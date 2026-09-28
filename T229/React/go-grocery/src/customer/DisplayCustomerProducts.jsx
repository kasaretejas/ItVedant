import React from 'react'
import FilterNavbar from './FilterNavbar'
import { toast } from 'react-toastify'
import { Link, useNavigate } from 'react-router-dom'

export default function DisplayCustomerProducts(props) {
   let loggedInUser=JSON.parse(localStorage.getItem("user"))
   let navigateTo=useNavigate()
   async function addToCart(productId)
    {
      if(!loggedInUser) navigateTo("/login")
      let response=await fetch(`http://localhost:8080/api/v1/customer/carts/${loggedInUser.id}/${productId}`,
            {
              method:"post",
              headers:{Authorization:`Bearer ${loggedInUser.jwtToken}`},
            })
        let responseObject=await response.json()
        if(response.ok)
        {
            toast.success(responseObject.message) 
        }
        else
        {
            toast.error(responseObject.message)
        }
    }
  let products=props.productsArray
  return (
    <div className='container'>
        <FilterNavbar filterProductsFunction={props.filterProductsFunction}/>
        <div className="row">
          {
            products.map(product=>{
              return (
              <div className="col-3">
                <div className="card" style={{width:"15rem"}}>
                  <img src={`http://localhost:8080/api/v1/images/${product.imageName}`}  className="card-img-top ms-auto me-auto" alt="..." style={{height:"200px", width:"200px"}}/>
                  <div className="card-body">
                    <h5 className="card-title text-capitalize text-center">{product.name}</h5>
                    <div className='d-flex justify-content-between mb-2'>
                      <span className='bg-primary text-light ps-2 pe-2 rounded'>&#8377; {product.price}</span>
                      <span className='bg-warning  ps-2 pe-2 rounded'>{product.subCategory.name}</span>
                    </div>
                    <button  className="btn btn-secondary w-100" onClick={()=>{addToCart(product.id)}}>Add to Cart</button>
                  </div>
                </div>
              </div>)
            })
          }
        </div>
    </div>
  )
}
