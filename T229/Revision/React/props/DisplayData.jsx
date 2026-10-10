import React from 'react'

export default function DisplayData(props) {
    let name=props.nameVariable
    let products=props.productsArray
  return (
    <div>
      <h1>{name}</h1>
      {
        products.map(product => {
            <p>{product.name}</p>
        })
      }
    </div>
  )
}
