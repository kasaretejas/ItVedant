import React from 'react'
import Navbar from './admin/homeComponents/Navbar'
import { Outlet } from 'react-router-dom'

export default function App() {
  return (
    <div>
      <Navbar/>
      <Outlet/>
    </div>
  )
}
