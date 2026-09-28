import React from 'react'
import { Link, replace, useNavigate } from 'react-router-dom'

export default function Navbar() {
    // getting logged in user data from browser. Note : if user is not logged in then you will get null
  let user=JSON.parse(localStorage.getItem("user"))
  //console.log(user);
  
  //handling logout functionality
  const navigateTo=useNavigate()
  const handleLogout = ()=>
    {
      localStorage.removeItem("user")
      window.open("http://localhost:3000/");
      window.close()
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
                <Link className="nav-link active" aria-current="page" to={"/manage-categories"}>Categories</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to={"/manage-sub-categories"}>Sub-Categories</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to={"/add-product"}>Add Product</Link>
              </li>
            </ul>
            <div>
              <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                  <li className="nav-item">
                    <Link className="nav-link active" aria-current="page" onClick={handleLogout}>Logout</Link>
                  </li>
                  <li className="nav-item">
                    <Link className="nav-link active btn btn-primary text-light" aria-current="page" to={"/profile"}>My-Profile</Link>
                  </li>
              </ul>
            </div>
          </div>
        </div>
      </nav>
    </div>
  )
}