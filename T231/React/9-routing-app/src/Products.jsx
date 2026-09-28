import React, { useEffect, useState } from 'react'
import DisplayProducts from './DisplayProducts'

export default function Products() {
  let [products, setProducts]=useState(null)
  
  useEffect(()=>
    {
        async function getAllProducts()
        {
          let response=await fetch("https://fakestoreapi.com/products")
          let data=await response.json()
          setProducts(data)
        }
        getAllProducts()
    }, [])

  return (
    <div>
      <DisplayProducts productsValue={products}/>
    </div>
  )
}



