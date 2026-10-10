import React, { useContext, useEffect, useState } from 'react'
import FilterNavbar from './FilterNavbar'
import { LoggedInUserContext } from '../project_context/LoggedInUserContext';

export default function Products() {
    let [products, setProducts]=useState(null)
    let { userData, setUserData } = useContext(LoggedInUserContext);
    console.log(products);
    

    async function getProducts()
    {

        let response=await fetch("http://localhost:8080/api/v1/get/products")
            let responseObject=await response.json()  
            setProducts(responseObject.data)      
    }

     useEffect(()=>{ getProducts() },[]) 
  return (
    <div className='container'>
        <FilterNavbar/>
        <div className='row mt-3'>
            {
                products?products.map(product => {
                    return <div className="col-3">
                                <div className="card" style={{width:"15rem"}}>
                                <img src={`http://localhost:8080/api/v1/images/${product.imageName}`} className="card-img-top ms-auto me-auto" alt="..." style={{height:"150px", width:"150px"}}/>
                                <div className="card-body">
                                    <h5 className="card-title text-capitalize">{product.name}</h5> 
                                    <span>{product.subCategory.name}</span>
                                    <h5 className="card-title text-capitalize">₹ {product.price} </h5>
                                    
                                    <p className="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ea, officia?</p>
                                    <a href="#" className="btn btn-primary w-100">Add to cart</a>
                                </div>
                                </div>
                            </div>
            }):""
            }
        </div>
    </div>
  )
}
