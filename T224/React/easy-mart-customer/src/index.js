import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'

import Home from './components/Home';
import FetchProducts from './components/products/FetchProducts';
import Register from './components/authentication/Register';
import Login from './components/authentication/Login';
import Cart from './components/cart/Cart';
import Orders from './components/orders/Orders';
import ProductDetails from './components/products/ProductDetails';
import { ToastContainer, Zoom } from 'react-toastify';

let projectRoutes=createBrowserRouter([
    {
        path:"/",
        element:<Home/>,
        children:[
            {
                element:<FetchProducts/>,
                index:true
            },
            { path : "/register", element:<Register/>},
            { path : "/login", element:<Login/>},
            { path : "/my-cart", element:<Cart/>},
            { path : "/my-orders", element:<Orders/>},
            { path : "/products/:id", element:<ProductDetails/>}
        ]
    }
])
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <>
        <RouterProvider router={projectRoutes}/>
        <ToastContainer
        position="top-right"
        autoClose={2000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
        theme="light"
        transition={Zoom}
        />
    </>
);


