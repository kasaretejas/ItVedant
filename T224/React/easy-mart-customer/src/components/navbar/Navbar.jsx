import React from 'react'
import { Link, replace, useNavigate } from 'react-router-dom'

export default function Navbar() 
{
  // getting logged in user data from browser. Note : if user is not logged in then you will get null
  let user=JSON.parse(localStorage.getItem("user"))
  console.log(user);
  
  //handling logout functionality
  const navigateTo=useNavigate()
  const handleLogout = ()=>
    {
      localStorage.removeItem("user")
      navigateTo("/",replace)
    }
  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-body-tertiary">
        <div className="container-fluid">
          <Link className="navbar-brand" to={"/"}><i className="bi bi-cart2 me-3"></i> Easy-Mart</Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to={"/"}>Products</Link>
              </li>
            </ul>
            <div>
              <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                {/* show login and register if user is not logged in */}
                {
                !user && <>
                  <li className="nav-item">
                    <Link className="nav-link active" aria-current="page" to={"/register"}>Register</Link>
                  </li>
                  <li className="nav-item">
                    <Link className="nav-link active" aria-current="page" to={"/login"}>Login</Link>
                  </li></>
                }
                
                {/* show cart, orders and logout if user is logged in  */}
                {
                  user &&  <>
                  <li className="nav-item">
                    <Link className="nav-link active" aria-current="page" to={"/my-cart"}>My-Cart</Link>
                  </li>
                  <li className="nav-item">
                    <Link className="nav-link active" aria-current="page" to={"/my-orders"}>My-Orders</Link>
                  </li>
                  <li className="nav-item">
                    <Link className="nav-link active" aria-current="page" onClick={handleLogout}>Logout</Link>
                  </li></>
                }

              </ul>
            </div>
          </div>
        </div>
      </nav>
    </div>
  )
}
