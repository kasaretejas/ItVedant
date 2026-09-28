import React, { useEffect, useState } from 'react'
import DisplayProducts from './DisplayProducts'
import { toast } from 'react-toastify'

export default function FetchProducts() {
  let [products, setProducts]=useState(null)

  //logic to get all products for specific vendor
  let loggedInVendor=JSON.parse(localStorage.getItem("user"))
  async function getProductsByVendorId()
    {
       
        let response=await fetch(`http://localhost:8080/api/v1/vendor/products/${loggedInVendor.id}`,
          {
            headers:{Authorization: `Bearer ${loggedInVendor.token}`}
          })
        let responseObject=await response.json()
        setProducts(responseObject.data)
    }
  
  useEffect(()=>{
    //remove logic for get all products from here and paste outside of useEffect (check above ^)
    getProductsByVendorId()
  }, [])

  async function deleteProduct(productId)
  {
    //consider that product is deleted
    let response=await fetch(`http://localhost:8080/api/v1/vendor/${loggedInVendor.id}/products/${productId}`,
          {
            method:"delete",
            headers:{Authorization: `Bearer ${loggedInVendor.token}`}
          })
        let responseObject=await response.json()
        if(response.ok)
        {
          toast.success(responseObject.message)
          getProductsByVendorId()
        }
        else
        {
          toast.error(responseObject.message)
        }
  }


  return (
    <div>
      { products==null? <h1>There are no products, please add some! </h1>: 
      <DisplayProducts allProducts={products} ondeleteProduct={deleteProduct}/>}
      
    </div>
  )
}
