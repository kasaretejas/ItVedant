import React, { useEffect, useState } from 'react'
import DisplayProducts from './DisplayProducts'
import FilterNavbar from '../navbar/FilterNavbar'

export default function FetchProducts() {
  let [products, setProducts]=useState(null)
  useEffect(()=>{
    async function fetchAllProducts()
    {
      let response=await fetch("http://localhost:8080/api/v1/get/products")
      let responseObject=await response.json()
      if(response.ok) setProducts(responseObject.data)
    }
  fetchAllProducts()
  },[])
  async function filterProducts(categoryName,subCategoryName, sortDirection, productName) 
  {
    let baseURL = "http://localhost:8080/api/v1/get/filtered-products?"
    let urlParams=new URLSearchParams()
    if(categoryName && categoryName !="All")
    {
      urlParams.append("categoryName", categoryName)
    }
    if(subCategoryName && subCategoryName !="All")
    {
      urlParams.append("subCategoryName", subCategoryName)
    }
    if(sortDirection && sortDirection !="All")
    {
      urlParams.append("sortDirection", sortDirection)
    }
    if(productName)
    {
      urlParams.append("productName", productName)
    }
    //console.log(`http://localhost:8080/api/v1/get/filtered-products?${urlParams.toString()}`);

    let response = await fetch(`http://localhost:8080/api/v1/get/filtered-products?${urlParams.toString()}`);
    let responseObject = await response.json();
    setProducts(responseObject.data) 
  }
  return (
    <div>
      {
        products == null ? <h5>Loading....</h5>: <>
        <FilterNavbar onFilterProducts={filterProducts}/>
        <DisplayProducts productsValue={products}/>
        </>
      }
    </div>
  )
}
