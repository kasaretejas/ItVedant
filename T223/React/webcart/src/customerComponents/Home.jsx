import React from 'react'
import Navbar1 from './navbar/Navbar1'
import { Outlet } from 'react-router-dom'

export default function Home() {
  return (
    <div>
      <Navbar1/>
      <Outlet/>
    </div>
  )
}
