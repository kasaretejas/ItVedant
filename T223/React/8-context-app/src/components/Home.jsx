import React, { useContext } from 'react'
import { ThemeContext } from '../context/ThemeContext'

export default function Home() {
  let {theme, setTheme}=useContext(ThemeContext)
  console.log(theme);
  
  return (
    <div>
      Home
    </div>
  )
}
