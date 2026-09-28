import React, { useContext } from 'react'
import { ThemeContext } from './ThemeContext'

export default function Navbar() {
    let {theme,setTheme,themeStyle}=useContext(ThemeContext)
    console.log(theme);
    
    
  return (
    <div>
      <nav className={`navbar navbar-expand-lg ${themeStyle.navbar} ${themeStyle.background}`}>
        <div className="container-fluid">
          <a className="navbar-brand" href="#">Navbar</a>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <a className="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#">Link</a>
              </li>
              <li className="nav-item dropdown">
                <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Dropdown
                </a>
                <ul className="dropdown-menu">
                  <li><a className="dropdown-item" href="#">Action</a></li>
                  <li><a className="dropdown-item" href="#">Another action</a></li>
                  <li><hr className="dropdown-divider"/></li>
                  <li><a className="dropdown-item" href="#">Something else here</a></li>
                </ul>
              </li>
            </ul>
            <div>
              {
                  theme==='dark'?
                  <i className={`bi bi-brightness-high fs-3 pe-auto ${themeStyle.text}`} onClick={()=>{setTheme("light")}}></i>:
                  <i className={`bi bi-moon fs-3 pe-auto ${themeStyle.text}`} onClick={()=>{setTheme("dark")}}></i>
              }
              {/* <i className={`bi bi-moon ${themeStyle.text}`}></i> */}
              
              
            </div>
            
          </div>
        </div>
      </nav>
    </div>
  )
}
