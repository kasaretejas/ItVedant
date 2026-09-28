import React, { useState } from 'react'
import Display from './Display'
import Button from './Button'

export default function App() 
{
    //let count = 0;
    let [count, setCount]=useState(0)
    function changeCounter()
    {
        setCount(count+1)
    }
  return (
    <div>
        <h1>this is app component</h1>
        <Display countValue={count}/> {/* here countValue is property and count is value */}
        <Button onChangeCounter = {changeCounter}/> 
        {/* here onChangeCounter is property and changeCounter is function reference */}
    </div>
  )
}
