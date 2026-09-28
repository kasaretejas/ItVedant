import React from 'react'
import Navbar from './Navbar'
import { Outlet } from 'react-router-dom'

export default function App() {
  return (
    <div>
      <Navbar/>
      <Outlet/> 
      {/* outlet is used to render components dynamically as per url */}
    </div>
  )
}
