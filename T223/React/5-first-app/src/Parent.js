import { useState } from "react"
import { Button } from "./Button"
import { Display } from "./Display"

export function Parent()
{
  let [count, setCount]=useState(5)
  let changeCounter = ()=>
  {
      setCount(count+1)
  }
  return <>
    <Display countValue={count}/> {/*Display:Component, countValue:property */}
    <Button changeCounterFunction={changeCounter}/>
  </>
}