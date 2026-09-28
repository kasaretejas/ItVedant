import React from 'react'
import { Link, replace, useNavigate } from 'react-router-dom'

export default function CustomerNavbar() {
  let loggedInUser=JSON.parse(localStorage.getItem("user"))
  console.log(loggedInUser);

  let navigateTo=useNavigate()

  function handleLogout()
  {
    localStorage.removeItem("user")
    navigateTo("/",replace)
  }
  
  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-body-tertiary">
        <div className="container-fluid">
          <Link className="navbar-brand" to={"/"}><i className="bi bi-shop"></i> Go-Grocery</Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to={"/"}>Home</Link>
              </li>
            </ul>
            <div>
              <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                {
                  !loggedInUser && <>
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" to={'/register'}>Register</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" to={'/login'}>Login</Link>
                </li>
                  </>
                }



                {
                  loggedInUser && <>
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" to={'/my-cart'}>Cart</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" to={'/login'}>Orders</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" onClick={handleLogout}>Logout</Link>
                </li>
                  </>
                }
              </ul>
            </div>
          </div>
        </div>
      </nav>
    </div>
  )
}
