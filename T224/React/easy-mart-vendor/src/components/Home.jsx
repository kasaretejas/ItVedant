import React, { useEffect, useState } from 'react'
import Navbar from './manageNavbar/Navbar'
import { Outlet } from 'react-router-dom'

export default function Home() {

  const [loading, setLoading] = useState(true);

  //collecting token sent from port 3000 and saving to the local storage
  useEffect(()=>{
    const params = new URLSearchParams(window.location.search);
    const token = params.get("token")
    if(token)
    {
      const user = JSON.parse(decodeURIComponent(params.get("token")));
      localStorage.setItem("user", JSON.stringify(user));
    }
    setLoading(false);
  },[])

  if (loading) {
        return <h2>Loading...</h2>;
    }

  return (
    <div>
      <Navbar/>
      <Outlet/>
    </div>
  )
}
