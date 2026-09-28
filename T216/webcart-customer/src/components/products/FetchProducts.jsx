import React, { useEffect, useState } from 'react'
import DisplayProducts from './DisplayProducts'
import FilterNavbar from '../home/FilterNavbar';

export default function FetchProducts() 
{
  let [products, setProducts]=useState(null)
  async function filterProducts(categoryName,subCategoryName,productName,sortDirection,minPrice,maxPrice)
  {
      let urlParameter = new URLSearchParams();
      if(categoryName) urlParameter.append("categoryName",categoryName)
      if(subCategoryName) urlParameter.append("subCategoryName",subCategoryName)
      if(productName) urlParameter.append("productName",productName)
      if(sortDirection) urlParameter.append("sortDirection",sortDirection)
      if(minPrice) urlParameter.append("minPrice",minPrice)
      if(maxPrice) urlParameter.append("maxPrice",maxPrice)
      console.log(`http://localhost:8080/api/v1/products/filter?${urlParameter.toString()}`);

      let responseObject=await fetch(`http://localhost:8080/api/v1/products/filter?${urlParameter.toString()}`)
      let responseData =  await responseObject.json()
      setProducts(responseData.data)
  }
  useEffect(()=>{
    async function getAllProducts()
    {
      let responseObject=await fetch("http://localhost:8080/api/v1/products")
      let responseData =  await responseObject.json()
      setProducts(responseData.data)
    }
    getAllProducts()
  },[])
  return (
    <div>
      <FilterNavbar onfilterProducts = {filterProducts}/>
      <DisplayProducts productsArray={products}/>
    </div>
  )
}
