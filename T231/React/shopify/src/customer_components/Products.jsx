import React, { useContext, useEffect, useState } from 'react'
import FilterNavbar from './FilterNavbar'
import { LoggedInUserContext } from '../project_context/LoggedInUserContext';
import { Link, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

export default function Products() {
    let [products, setProducts]=useState(null)
    let { userData, setUserData } = useContext(LoggedInUserContext);
    console.log("userData", userData);
    
    console.log(products);
    

    async function getProducts()
    {

        let response=await fetch("http://localhost:8080/api/v1/get/products")
            let responseObject=await response.json()  
            setProducts(responseObject.data)      
    }

     useEffect(()=>{ getProducts() },[]) 

    async function filterProducts(categoryName, subCategoryName, sortDirection, productName)
    {
        let BaseURL = "http://localhost:8080/api/v1/get/filtered-products?"
        let urlParams=new URLSearchParams()
        if(categoryName && categoryName!="all")
        {
            urlParams.append("categoryName", categoryName)
        }
        if(subCategoryName && subCategoryName!="all")
        {
            urlParams.append("subCategoryName", subCategoryName)
        }
        if(sortDirection && sortDirection!="all")
        {
            urlParams.append("sortDirection", sortDirection)
        }
        if(productName)
        {
            urlParams.append("productName", productName)
        }

        //console.log(BaseURL+urlParams.toString());
        let response=await fetch(BaseURL+urlParams.toString())
        let responseObject=await response.json()  
        setProducts(responseObject.data)  
        
    }

    //add to cart functionality
    let navigateTo=useNavigate()
    async function addToCart(productId)
    {
        if(userData==null) 
        {
            navigateTo("/login")
        }
        else
        {
            let response=await fetch(`http://localhost:8080/api/v1/customer/add-to-cart/${userData.id}/${productId}`,
                {
                    method:"post",
                    headers : 
                            {
                                "Authorization":`Bearer ${userData.jwtToken}`
                            },
                })
            let responseObject=await response.json()
            console.log(responseObject);
            
            if(response.ok)
            {
                toast.success(responseObject.message)
            }
            else
            {
                toast.error(responseObject.message)
            }
        }
        
    }
  return (
    <div className='container'>
        <FilterNavbar filterProductsFunction={filterProducts}/>
        <div className='row mt-3'>
            {
                products?products.map(product => {
                    return <div className="col-3" key={product.id}>
                                <div className="card" style={{width:"15rem"}}>
                                <img src={`http://localhost:8080/api/v1/images/${product.imageName}`} className="card-img-top ms-auto me-auto" alt="..." style={{height:"150px", width:"150px"}}/>
                                <div className="card-body">
                                    <h5 className="card-title text-capitalize">{product.name}</h5> 
                                    <span>{product.subCategory.name}</span>
                                    <h5 className="card-title text-capitalize">₹ {product.price} </h5>
                                    
                                    <p className="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ea, officia?</p>
                                    <button className="btn btn-primary w-100" onClick={()=>{ addToCart(product.id)}}>Add to cart</button>
                                </div>
                                </div>
                            </div>
            }):""
            }
        </div>
    </div>
  )
}
