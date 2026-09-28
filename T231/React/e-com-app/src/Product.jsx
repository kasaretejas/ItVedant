import React, { useEffect, useState } from 'react'

export default function Product() {
    let [products, setProducts] = useState(null)

    useEffect(()=>{
        async function fetchProducts() 
        {
           let response = await fetch("https://fakestoreapi.com/products") 
           let data=await response.json()
           setProducts(data)
        }
        fetchProducts()
    },[])
  return (
    <div>
      {
        products==null?"Loading...":
        products.map((product)=>{
            return <h4 key={product.id}>{product.id} - {product.title}</h4>
        })
      }
    </div>
  )
}
