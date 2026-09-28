import React, { useContext } from 'react'
import { ThemeContext } from './ThemeContext';

export default function Contact() {

     let {theme,setTheme,themeStyle}=useContext(ThemeContext)
  return (
    <div>
      <h1 className={`${themeStyle.background} ${themeStyle.text}`}>Contact</h1>
    </div>
  )
}
