import React from 'react'
import DisplayData from './DisplayData'

export default function FetchData() {
    let products = [{id:10, name:"brush"},{id:25, name:"laptop"}]
    let name = "raj"
  return (
    <div>
      <DisplayData nameVariable={name}  productsArray={products}/>
    </div>
  )
}


//function display(x) {}

//display(20)