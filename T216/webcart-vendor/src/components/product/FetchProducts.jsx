import React, { useEffect, useState } from 'react'
import DisplayProducts from './DisplayProducts'

export default function FetchProducts() {
  let [products, setProducts]=useState(null)
  let [isProductDeleted, setIsProductDeleted]=useState(false)
  useEffect(()=>{
    async function fetchAllProductsByVendorId()
    {
        let responseObject=await fetch(`http://localhost:8080/api/v1/vendor/products/1`)
        let responseData=await responseObject.json()
        setProducts(responseData.data)
    }
    fetchAllProductsByVendorId()
  }, [isProductDeleted])
  return (
    <div>
      {products===null?<p>There are no products added by you!</p>:<DisplayProducts productsArray={products} 
      setIsProductDeletedFunction={setIsProductDeleted}/>}
    </div>
  )
}
