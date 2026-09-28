import React from 'react';
import ReactDOM from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import App from './App';
import Home from './Home';
import Contact from './Contact';
import Producst from './Producst';
import Gallery from './Gallery';
import { ThemeProvider } from './ThemeContext';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'


let projectRoutes=createBrowserRouter([
  {
    path:"/",
    element:<App/>,
    children:[
      {
        element:<Home/>,
        index:true
      },
      {
        path:"contact",
        element:<Contact/>
      },
      {
        path:"products",
        element:<Producst/>
      },
      {
        path:"gallery",
        element:<Gallery/>
      }
    ]
  }
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <ThemeProvider>
    <RouterProvider router={projectRoutes}/>
  </ThemeProvider>

);
