import React, { useEffect, useState } from 'react'
import DisplayProducts from './DisplayProducts'
import { toast } from 'react-toastify'

export default function FetchProducts() 
{
  let [isProductDeleted, setIsProductDeleted]=useState(false)
  let [products, setProducts]=useState(null)
  const user = JSON.parse(localStorage.getItem("user"));
  console.log(user);
  

  useEffect(()=>{
    async function getProductsByVendor()
    {
      let response=await fetch(`http://localhost:8080/api/v1/vendor/${user.userId}/products`, 
        {
          headers:{ Authorization: `Bearer ${user.token}` }
        })
      let responseObject =await response.json()
      setProducts(responseObject.data)
      
    }
    getProductsByVendor()
  },[isProductDeleted])

  async function deleteProduct(productId)
    {
      setIsProductDeleted(false)
        let response=await fetch(`http://localhost:8080/api/v1/vendor/${user.userId}/products/${productId}`, 
            { 
                method:"DELETE",
                headers:{ Authorization: `Bearer ${user.token}` }
            })
        if(response.status === 200)
        {
            toast.success("product deleted")
            setIsProductDeleted(true)
        }
        else
        {
            toast.error("product not deleted!")
        }
    }
  return (
    <div>
      {products==null?"Loading....":<DisplayProducts productsValue={products} onDeleteProduct={deleteProduct}/>}
    </div>
  )
}
