import React from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function Navbar() {

    const user = JSON.parse(localStorage.getItem("user"));
    const navigate = useNavigate();
    const handleLogout = () => {
      localStorage.removeItem("user");
      navigate("/");
    };
  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-body-tertiary">
        <div className="container-fluid">
          <Link className="navbar-brand" to={"/vendor"}><i className="bi bi-cart2"></i> &nbsp; &nbsp; Web-Cart</Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to={"/vendor"}>Home</Link>
              </li>
              <li className="nav-item dropdown">
                <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Manage
                </a>
                <ul className="dropdown-menu">
                  <li><Link className="dropdown-item" to={"/vendor/manage-categories"}>Categories</Link></li>
                  <li><Link className="dropdown-item" to={"/vendor/manage-subcategories"}>SubCategories</Link></li>
                  <li><hr className="dropdown-divider"/></li>
                  <li><Link className="dropdown-item" to={"/vendor"}>Products</Link></li>
                </ul>
              </li>
            </ul>
            <div className='d-flex ps-3 pe-3'>
              <Link className="nav-link active" aria-current="page" onClick={handleLogout}>Logout</Link>
              <Link className="btn btn-primary" to={"/vendor/add-product"}>Add Product</Link>
            </div>
          </div>
        </div>
      </nav>
    </div>
  )
}
