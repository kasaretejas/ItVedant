import React, { useEffect, useState } from 'react'
import ProductCard from './ProductCard'

export default function FetchProducts() 
{

 let [products, setProducts]=useState([])
 console.log(products);

 async function fetchAllProducts()
 {
    let response=await fetch("https://fakestoreapi.com/products")
    let data=await response.json()
    //console.log(data);
    setProducts(data)
 }
 //fetchAllProducts()
 useEffect(()=>{fetchAllProducts()},[])
  return (
    <div>
      fetch products component
      <ProductCard productsArray={products}/>
    </div>
  )
}
