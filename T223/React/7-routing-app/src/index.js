import React from 'react';
import ReactDOM from 'react-dom/client';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'
import { createBrowserRouter, Navigate, RouterProvider } from 'react-router-dom';
import Home from './components/Home.js';
import Products from './components/Products.js';
import Contact from './components/Contact.js';
import App from './components/App.js';
import ErrorComponent from './components/ErrorComponent.js';
import ProductDetails from './components/ProductDetails.jsx';

let myRoutes=createBrowserRouter([
    {
        path:"/",
        element:<App/>, 
        children:
            [
                {path:"/",element:<Home/>, index:true},
                {path:"/products",element:<Products/>},
                {path:"/contact",element:<Contact/>},
                {path:"/products/:id",element:<ProductDetails/>},
                {path: "*",element: <Navigate to="/" replace />}
            ],
        
        
    }, 
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <RouterProvider router={myRoutes}/> 
);


