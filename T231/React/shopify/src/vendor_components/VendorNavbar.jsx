import React, { useContext } from 'react'
import { LoggedInUserContext } from '../project_context/LoggedInUserContext'
import { Link, useNavigate } from 'react-router-dom'

export default function VendorNavbar() {
     let { userData, setUserData }=useContext(LoggedInUserContext)
     let navigateTo=useNavigate()
    function logout()
    {
        localStorage.removeItem("userData")
        setUserData(null)
        navigateTo("/")
    }
  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-body-tertiary">
        <div className="container-fluid">
          <Link className="navbar-brand" to={"/vendor"}><i className="bi bi-shop"></i> &nbsp; Shopify</Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to={"/vendor/manage-categories"}>Manage Categories</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to={"/vendor/manage-sub-categories"}>Manage Sub-Categories</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page">Add Product</Link>
              </li>
            </ul>
            <div>
             <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" onClick={()=>{logout()}}>Logout</Link>
                </li>
             </ul>
            </div>
          </div>
        </div>
      </nav>
    </div>
  )
}
