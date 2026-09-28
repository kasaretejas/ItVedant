import React, { useContext } from 'react'
import { Link } from 'react-router-dom'
import { LoggedInUserContext } from '../project_context/LoggedInUserContext'

export default function Navbar() {
 let { userData, setUserData }=useContext(LoggedInUserContext)
 console.log(userData);

 function logout()
 {
  localStorage.removeItem("userData")
  setUserData(null)
 }
 
  
  
  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-body-tertiary">
        <div className="container-fluid">
          <Link className="navbar-brand" to={"/"}><i className="bi bi-shop"></i> &nbsp; Shopify</Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <a className="nav-link active" aria-current="page" href="#">Home</a>
              </li>
            </ul>
            <div>
             <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              {
                userData?
                <>
                  <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" >Cart</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" >Orders</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" onClick={()=>{logout()}}>Logout</Link>
                </li>
                </>:
                <>
                  <li className="nav-item">
                    <Link className="nav-link active" aria-current="page" to={"/register"}>Register</Link>
                  </li>
                  <li className="nav-item">
                    <Link className="nav-link active" aria-current="page" to={"/login"}>Login</Link>
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
