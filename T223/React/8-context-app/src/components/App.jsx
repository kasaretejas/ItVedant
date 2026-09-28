import React, { useContext } from 'react'
import Navbar from './Navbar'
import { Outlet } from 'react-router-dom'
import { ThemeContext } from '../context/ThemeContext'

export default function App() {
  let {theme, themeStyle}=useContext(ThemeContext)
  return (
    <div className={themeStyle} data-bs-theme={theme}>
      <Navbar/>
      <Outlet/>
    </div>
  )
}
