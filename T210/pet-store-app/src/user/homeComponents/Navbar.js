import React, { useContext, useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { CartCounterContext } from '../contexts/CartCountContext';

export default function Navbar() 
{
  const user = JSON.parse(localStorage.getItem("user"));
  const navigate = useNavigate();

    const handleLogout = () => {
    localStorage.removeItem("user");
    navigate("/");
  };

  //display cart count functionality
  const token = user?.token;
  const userId = user?.userId;
  let {cartCount,setCartCount}=useContext(CartCounterContext)
  
  async function getAllCartItemsForPerticularUser()
  {
    if(user)
    {
      let response = await fetch(`http://localhost:8080/api/v1/customer/${userId}`,
                                {
                                  method:'GET',
                                  headers:{"Authorization": `Bearer ${token}`}
                                })
    let responseObject = await response.json();
    console.log(responseObject.data.length);
    console.log(typeof(responseObject.data));
    setCartCount(responseObject.data.length)
    }
  }
  useEffect(()=>{getAllCartItemsForPerticularUser()})



  return (
     <div>
      <nav className="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
        <div className="container-fluid mt-1">
          <Link className="navbar-brand" to={'/'}><i className="bi bi-shop"></i> &nbsp; Pet-Store</Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to={'/'}>Home</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to={'/'}>Pets</Link>
              </li>
              {user && (
              <>
                <li className="nav-item">
                  <Link className="nav-link active position-relative" aria-current="page" to={'/my/cart'}>
                  Cart
                    <span className="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                      {cartCount}
                      <span className="visually-hidden">unread messages</span>
                    </span>
                  </Link>
                </li>
                <li className="nav-item">
                  <a className="nav-link active" aria-current="page" href="#">Orders</a>
                </li>
              </>
            )}
              
            </ul>
          </div>
          <div >
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              {!user && (
              <>
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" to={'/register'}>Register</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link active" aria-current="page" to={'/login'}>Login</Link>
                </li>
              </>
            )}

            {user && (
              <>
                <li className="nav-item">
                   <button className="nav-link btn btn-link" onClick={handleLogout}>Logout</button>
                </li>
              </>
            )}
            </ul>
          </div>
        </div>
    </nav>
    </div>
  )
}
