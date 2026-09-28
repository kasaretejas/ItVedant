import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

export default function ProductDetails() {
  const {id}=useParams()
  let [product, setProduct]=useState(null)
    useEffect(()=>{
      async function getAllProducts()
      {
        let responseObject=await fetch(`http://localhost:8080/api/v1/products/${id}`)
        let responseData =  await responseObject.json()
        setProduct(responseData.data)
      }
      getAllProducts()
    },[])
  return (
    <div className='container'>
      {product===null? "Loading" : <div>
        <img src={`http://localhost:8080/images/${product.imageName}`} alt="" />
        <h3>{product.name}</h3>
      </div>}
    </div>
  )
}
