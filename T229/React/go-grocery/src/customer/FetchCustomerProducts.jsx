import React, { useEffect, useState } from 'react'
import DisplayCustomerProducts from './DisplayCustomerProducts'

export default function FetchCustomerProducts() {
  let loggedInUser=JSON.parse(localStorage.getItem("user"))
  let [products, setProducts]=useState(null)
  console.log(products);
  
  async function  fetchAllProducts()
  {
     let response=await fetch("http://localhost:8080/api/v1/get/products")
        let responseObject=await response.json()
        setProducts(responseObject.data)
  }
  useEffect(()=>{
    fetchAllProducts()
  },[])

  async function filterProducts(categoryName, subCategoryName, sortDirection, productName)
  {
    let BASEURL = "http://localhost:8080/api/v1/get/filtered-products?"
    let urlParams  = new  URLSearchParams();
    if(categoryName!=null && categoryName!="All")
    {
      urlParams.append("categoryName", categoryName)
    }
    if(subCategoryName!=null && subCategoryName!="All")
    {
      urlParams.append("subCategoryName", subCategoryName)
    }
    if(sortDirection!=null && sortDirection!="All")
    {
      urlParams.append("sortDirection", sortDirection)
    }

     if(productName!=null && productName!="All")
    {
      urlParams.append("productName", productName)
    }

    console.log(BASEURL+urlParams.toString());
    let response=await fetch(BASEURL+urlParams.toString())
    let responseObject=await response.json()
    setProducts(responseObject.data)
     

  }
  return (
    <div>
      {
        products?<DisplayCustomerProducts productsArray={products} filterProductsFunction={filterProducts}/>:"Products Loading...."
      }
      
    </div>
  )
}
