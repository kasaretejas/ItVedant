import React from 'react';
import ReactDOM from 'react-dom/client';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Home from './components/Home.jsx';
import FetchProducts from './components/manageProduct/FetchProducts.jsx';
import Categories from './components/manageCategories/Categories.jsx';
import SubCategories from './components/manageSubCategories/SubCategories.jsx';
import Profile from './components/manageProfile/Profile.jsx';
import AddProduct from './components/manageProduct/AddProduct.jsx';
import UpdateProduct from './components/manageProduct/UpdateProduct.jsx';
import { ToastContainer, Zoom } from 'react-toastify';

let vendorRoutes=createBrowserRouter([
    {
        path:"/",
        element:<Home/>,
        children:[
            {index:true, element:<FetchProducts/>},

            {path:"profile", element:<Profile/>},

            {path:"manage-categories", element:<Categories/>},
            {path:"manage-sub-categories", element:<SubCategories/>},

            {path:"add-product", element:<AddProduct/>},
            {path:"update-product/:id", element:<UpdateProduct/>}

        ]
    }
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
 <>
    <RouterProvider router={vendorRoutes}/>
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

