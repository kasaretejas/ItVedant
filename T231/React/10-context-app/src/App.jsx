import React, { useContext } from 'react'
import Navbar from './Navbar'
import { Outlet } from 'react-router-dom'
import { ThemeContext } from './ThemeContext'

export default function App() {
  let {themeStyle}=useContext(ThemeContext)
  return (
    <div className={`vh-100 ${themeStyle.background}  ${themeStyle.text}`}>
      <Navbar/>
      <Outlet/>
    </div>
  )
}
