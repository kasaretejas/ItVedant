import React from 'react'

export default function Button(props) {
  return (
    <div>
      <button onClick={()=>{props.onChangeCounter()}}>click me</button>
      
    </div>
  )
}
