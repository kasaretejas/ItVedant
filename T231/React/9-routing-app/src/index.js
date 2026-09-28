import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Products from './Products';
import Contact from './Contact';
import Home from './Home';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'


let myRoutes=createBrowserRouter([
  {
    path:"/",
    element:<App/>,
    children:
    [
      {
        element:<Home/>,
        index:true
      },
      {
        path:"/products",
        element:<Products/>
      },
      {
        path:"/contact",
        element:<Contact/>
      }
    ]
  }
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
<RouterProvider router={myRoutes}/>
);


