import React, { useContext } from 'react'
import { Link } from 'react-router-dom'
import { ThemeContext } from '../context/ThemeContext';

export default function Navbar() {
  let {theme, setTheme}=useContext(ThemeContext)
  console.log(theme);
  return (
    <div>
      <nav className={`navbar navbar-expand-lg bg-${theme}`} data-bs-theme={theme}>
        <div className="container-fluid">
          <Link className="navbar-brand" to={'/'}>Context-App</Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to={'/'}>Home</Link>
              </li> 
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to={'/products'}>Products</Link>
              </li> 
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to={'/contact'}>Contact</Link>
              </li> 
            </ul> 
            <div style={{cursor:'pointer'}}>
              {theme==='light'?
              <i className="bi bi-moon fs-3 " onClick={()=>{setTheme('dark')}}></i>:
              <i className="bi bi-brightness-high fs-3 text-light" onClick={()=>{setTheme('light')}}></i>} 
            </div>        
          </div>
        </div>
      </nav>
    </div>
  )
}
