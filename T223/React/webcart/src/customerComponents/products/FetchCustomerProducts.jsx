import React, { useEffect, useState } from 'react'
import DisplayCustomerProducts from './DisplayCustomerProducts'
import { useFetcher } from 'react-router-dom'
import FilterNavbar from '../navbar/FilterNavbar'


export default function FetchCustomerProducts() {
    let [products, setProducts]=useState(null)
    console.log(products);
    
    useEffect(()=>
    {
        async function fetchProducts()
        {
            //let response=await fetch("http://localhost:8080/api/v1/products")
            let response=await fetch("http://localhost:8080/api/v1/get/products")
            let responseObject=await response.json()
            setProducts(responseObject.data)
        }
        fetchProducts()
    },[])

    async function filterProducts(categoryName, subCategoryName, sortDirection,productName)
    {
      let urlSearchParams=new URLSearchParams() 
      if(categoryName && categoryName !== "All" ) 
        urlSearchParams.append("categoryName", categoryName)
      if(subCategoryName && subCategoryName !== "All") 
        urlSearchParams.append("subCategoryName", subCategoryName)
      if(sortDirection && sortDirection !=="All") 
        urlSearchParams.append("sortDirection", sortDirection)
      if(productName && productName !=="") 
        urlSearchParams.append("productName", productName)
      
      //console.log(`http://localhost:8080/api/v1/products/filter?${urlSearchParams.toString()}`);

      //let response=await fetch(`http://localhost:8080/api/v1/products/filter?${urlSearchParams.toString()}`)
      let response=await fetch(`http://localhost:8080/api/v1/filter?${urlSearchParams.toString()}`)
      let responseObject=await response.json()
      setProducts(responseObject.data)
    }
  return (
    <div>
      <div className='container'>
         <FilterNavbar onfilterProducts={filterProducts}/>  
      </div>
      
      {
        products==null?"Loading....":<DisplayCustomerProducts productsValue={products}/>
      }
    </div>
  )
}
