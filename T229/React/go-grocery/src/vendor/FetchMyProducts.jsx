import React, { useEffect, useState } from 'react'
import DisplayMyProducts from './DisplayMyProducts'
import { toast } from 'react-toastify'

export default function FetchMyProducts() {
    let loggedInUser=JSON.parse(localStorage.getItem("user"))
    let [products, setProducts]=useState(null)
    let [isProductDeleted, setIsProductDeleted]=useState(false)
    
    async function deleteProductByid(productId)
    {
        console.log(productId);
        let response=await fetch(`http://localhost:8080/api/v1/vendor/products/${productId}`,
                                {
                                    method:"delete",
                                    headers:{Authorization:`Bearer ${loggedInUser.jwtToken}`},
                                })
        let responseObject=await response.json()
        console.log(responseObject);
        if(response.ok)
          {
            toast.success(responseObject.message)
            setIsProductDeleted(true)
          }
        else
          {
            toast.error("Product not deleted!")
          } 
    }

    async function getProductsByVendorId()
    {
          setIsProductDeleted(false)
         let response=await fetch(`http://localhost:8080/api/v1/vendor/products/${loggedInUser.id}`,
            {
                headers:{Authorization:`Bearer ${loggedInUser.jwtToken}`},
            })
            let responseObject=await response.json()
            console.log(responseObject);
            setProducts(responseObject.data)
    }

    useEffect(()=>{ getProductsByVendorId() },[isProductDeleted])
  return (

    <div>
      {
        products?<DisplayMyProducts productsArray={products} deleteProductFunction={deleteProductByid}/>: <h3 className='text-center border-bottom p-5'>There are no products found, please add some!</h3>
        // DisplayMyProducts --> component
        // productsArray ------> property (component ki property)
      }
      
    </div>
  )
}
