import React from 'react'
import FilterNavbar from '../navbar/FilterNavbar'
import { Link } from 'react-router-dom'
import { toast } from 'react-toastify'

export default function DisplayProducts(props) {
  let products = props.productsValue
  let loggedInCustomer=JSON.parse(localStorage.getItem("user"))
  async function addToCart(productId)
  {
    if(!loggedInCustomer) return alert(`Login Required ! ${productId}` )
    
      let response=await fetch(`http://localhost:8080/api/v1/customer/${loggedInCustomer.id}/cart/${productId}`,
      {
        method:"post",
        headers:{Authorization: `Bearer ${loggedInCustomer.token}`}
      }
    )
    let responseObject=await response.json()
    if(response.ok)
    {
      toast.success(responseObject.message)
      // navigateTo("/", {replace:true})
    }
    else
    {
      toast.error(responseObject.message)
    }
  }
  return (
    <div className='container mt-5'>
        <div className='row'>
            {products.map((product)=>{
              return (
                <div className='col-3'>
                    <div class="card" style={{width:"15rem"}}>
                      <img src={`http://localhost:8080/api/v1/images/${product.imageName}`} style={{height:"170px", width:"170px"}} className="card-img-top ms-auto me-auto" alt="..."/>
                      <div class="card-body">
                        <h5 class="card-title text-center text-capitalize">{product.name}</h5>
                        <div className='d-flex justify-content-between'>
                          <span className='bg-warning text-light border rounded-pill ps-1 pe-1'>{product.subCategory.category.name}</span>
                          <span className='bg-secondary text-light border rounded-pill ps-1 pe-1'>{product.subCategory.name}</span>
                        </div>
                        <p class="card-text text-center">&#8377;{product.price}</p>
                        <div className='d-flex justify-content-between'>
                          <Link onClick={()=>{addToCart(product.id)}}>Add to Cart</Link>
                          <Link>View More</Link>
                        </div>
                      </div>
                    </div>
                </div>
              )
            })}
        </div>
    </div>
  )
}
