import React from 'react'

export default function Display(props) { //props is an object
  return (
    <div>
      <h1>{props.countValue}</h1> 
    </div>
  )
}
