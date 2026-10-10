import React from 'react'
import Navbar from './Navbar'
import { Outlet } from 'react-router-dom'
import Products from './Products'

export default function Home() {
  return (
    <div>
      <Navbar/>
      <Outlet/>
    </div>
  )
}
