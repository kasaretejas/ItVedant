import React from 'react'
import VendorNavbar from './VendorNavbar'
import { Outlet } from 'react-router-dom'
import FetchMyProducts from './FetchMyProducts'

export default function VendorDashboard() {
  let loggedInUser=JSON.parse(localStorage.getItem("user"))
  return (
    <div>
      <VendorNavbar/>
      Welcome  {loggedInUser.username}
      <Outlet/>
    </div>
  )
}
