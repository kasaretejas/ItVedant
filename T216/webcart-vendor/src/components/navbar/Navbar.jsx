import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-body-tertiary">
        <div className="container-fluid">
          <Link className="navbar-brand" to={'/vendor'}><i className="bi bi-cart4 me-3"></i>WebCart-Vendor</Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to={'/vendor'} replace>Home</Link>
              </li>
              
              <li className="nav-item dropdown">
              <Link className="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Manage
              </Link>
              <ul className="dropdown-menu">
                <li><Link className="dropdown-item" to={'/vendor/manage-categories'}>Categories</Link></li>
                <li><Link className="dropdown-item" to={'/vendor/manage-sub-categories'} >Sub-Categories</Link></li>
                <li><Link className="dropdown-item" href="#">Products</Link></li>
              </ul>
            </li>
            </ul>
            <div>
                <Link className="btn btn-primary text-light" aria-current="page" to={'/vendor/add-product'}>Add Product</Link>
            </div>
            
          </div>
        </div>
     </nav>
    </div>
  )
}
