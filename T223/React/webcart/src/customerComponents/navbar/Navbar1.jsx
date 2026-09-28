import React from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function Navbar1() 
{
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
            <Link className="navbar-brand" to={"/"}><i className="bi bi-cart-check"></i> Web-Cart</Link>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarSupportedContent">
              <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" to={"/"}>Home</Link>
                </li>
                {
                  user && (
                    <>
                      <li className="nav-item">
                        <Link className="nav-link active" aria-current="page" to={"/my/cart"}>Cart</Link>
                      </li>
                      <li className="nav-item">
                        <Link className="nav-link active" aria-current="page" to={"/my/orders"}>Orders</Link>
                      </li>
                    </>
                  )
                }
              </ul>
            </div>
            <div>
                <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                  {
                      !user && (
                        <>
                          <li className="nav-item">
                            <Link className="nav-link active" aria-current="page" to={"/login"}>Login</Link>
                          </li>
                          <li className="nav-item">
                            <Link className="nav-link active" aria-current="page" to={"/register"}>Register</Link>
                          </li>
                        </>
                      )
                  }
                  {
                    user && (
                      <>
                        <li className="nav-item">
                          <Link className="nav-link active" aria-current="page" onClick={handleLogout}>Logout</Link>
                        </li>
                      </>
                    )
                  }
              </ul>
              </div>
          </div>
      </nav>
    </div>
  )
}


