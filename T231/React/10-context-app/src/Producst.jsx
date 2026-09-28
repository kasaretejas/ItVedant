import React, { useContext } from 'react'
import { ThemeContext } from './ThemeContext';

export default function Producst() {
     let {theme,setTheme,themeStyle}=useContext(ThemeContext)
  return (
    <div>
      <h1 className={`${themeStyle.background} ${themeStyle.text}`}>Products</h1>
    </div>
  )
}
