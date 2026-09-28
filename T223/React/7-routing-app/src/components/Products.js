import React, { useEffect, useState } from 'react'
import DisplayProduct from './DisplayProduct';

export default function Products() 
{
  let [products, setProducts]=useState([])
  let [loading, setLoading]=useState(true)
  console.log(products);
  //new value is taken by setProducts and set it to the products variable
  //as soon as new value updated inside products variable, useState re-renders the component
  async function fetchAllProducts()
  {
    let response=await fetch("https://dummyjson.com/products")
    let data= await response.json()
    setProducts(data.products)
    setLoading(false)
  }
  //fetchAllProducts()
  //due to component re-rendering, above function get called repeatedly.
  //so to call function only once, we have to use - useEffect()
useEffect(()=>{fetchAllProducts()}, [])
  return (
    <div>
      <DisplayProduct productsArray={products} loadingValue={loading}/>
    </div>
  )
}
