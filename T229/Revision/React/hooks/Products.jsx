import React, { useState } from 'react'

export default function Products() {

    function fetchProducts(p) //user defined function
    {
        //logic
        console.log(p);
        let numbers = [20,30]
        return  numbers

    }

    let [x,y]=fetchProducts("hello")

    let [variable, functionToChangeVariableValue]=useState(null) //react built in function
  return (
    <div>
      
    </div>
  )
}
