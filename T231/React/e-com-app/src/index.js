import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import App from './App';
import Home from './Home';
import Product from './Product';
import Contact from './Contact';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'

let myRoutes=createBrowserRouter([
  {
    path:"/",
    element:<App/>,
    children:[
      {
        index:true,
        element:<Home/>
      },
      {
        path:"product",
        element:<Product/>
      },
      {
        path:"contact",
        element:<Contact/>
      },

    ]
  }
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
<RouterProvider router={myRoutes}/>
);

