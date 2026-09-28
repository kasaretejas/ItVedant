import React, { useEffect, useState } from 'react'
import DisplayProducts from './DisplayProducts'

export default function FetchProducts() 
{
  let [products, setProducts]=useState(null)

 useEffect(()=>
  {
    async function fetchAllProducts()
      {
          let response=await fetch("https://fakestoreapi.com/products")
          let data=await response.json()
          setProducts(data)
      }
      fetchAllProducts()
 },[])

  return (
    <div>
      <h1>Fetch</h1> 
      <DisplayProducts productsValue={products}/> 
    </div>
  )
}
