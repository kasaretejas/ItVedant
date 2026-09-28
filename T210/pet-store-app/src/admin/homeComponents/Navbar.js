import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  const handleLogout = () => {
  localStorage.removeItem("user"); // remove token + role + userId
  window.location.href = "/login"; // hard redirect to clean memory
};
  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
        <div className="container-fluid">
          <Link className="navbar-brand" to={'/admin'}><i className="bi bi-shop"></i> &nbsp; Pet-Store</Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              {/* <li className="nav-item">
                <a className="nav-link active" aria-current="page" href="#">Home</a>
              </li> */}
              <li className="nav-item dropdown">
                <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Pets
                </a>
                <ul className="dropdown-menu">
                  <li><Link className="dropdown-item" to={'/admin/add-pet-type'}>Add Pet Type</Link></li>
                  <li><hr className="dropdown-divider"/></li>
                  <li><Link className="dropdown-item" to={'/admin/add-pet-breed'}>Add Pet Breed</Link></li>
                  <li><hr className="dropdown-divider"/></li>
                  <li><Link className="dropdown-item" to={'/admin/add-pet'}>Add Pet</Link></li>
                  <li><hr className="dropdown-divider"/></li>
                  <li><Link className="dropdown-item" to={'/admin/manage-pets'}>Manage Pets</Link></li>
                </ul>
              </li>
            </ul>
          </div>
          <div >
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">

             
              <li className="nav-item">
                {/* <a className="nav-link active" aria-current="page" href="#">Logout</a> */}
                <button className="nav-link btn btn-link" onClick={handleLogout}>
                  Logout
                </button>
              </li>
              
            </ul>
          </div>
        </div>
    </nav>
    </div>
  )}