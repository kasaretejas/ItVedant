import React from 'react'

export default function DisplayProducts(props) 
{
  console.log(props.productsValue);
  let products = props.productsValue
  
  return (
    <div>
      {
        products==null?"Loading....":
        products.map((product)=>{
          return <h1 key={product.id}>{product.title}</h1>
        })
      }
    </div>
  )
}
