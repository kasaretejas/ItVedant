import React from 'react';
import ReactDOM from 'react-dom/client';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import App from './components/App.jsx';
import FetchProducts from './components/product/FetchProducts.jsx';
import AddProduct from './components/product/AddProduct.jsx';
import UpdateProduct from './components/product/UpdateProduct.jsx';
import ManageCategories from './components/category/ManageCategories.jsx';
import ManageSubCategories from './components/subcategory/ManageSubCategories.jsx';
import { ToastContainer, Zoom } from 'react-toastify';
import Home from './customerComponents/Home.jsx';
import FetchCustomerProducts from './customerComponents/products/FetchCustomerProducts.jsx';
import DisplayCustomerProductDetails from './customerComponents/products/DisplayCustomerProductDetails.jsx';
import Register from './customerComponents/authentication/Register.jsx';
import Login from './customerComponents/authentication/Login.jsx';

let projectRoutes = createBrowserRouter([
    {
        path:"/vendor",
        element:<App/>,
        children:[
            {
                element:<FetchProducts/>,
                index:true
            },
            {
                path:"add-product",
                element:<AddProduct/>
            },
            {
                path:"update-product/:id",
                element:<UpdateProduct/>
            },
            {
                path:"manage-categories",
                element:<ManageCategories/>
            },
            {
                path:"manage-subcategories",
                element:<ManageSubCategories/>
            }
        ]
    },
    {
        path:"/",
        element:<Home/>,
        children:[
            {
                element:<FetchCustomerProducts/>,
                index:true
            },
            {
                path:"/:id",
                element:<DisplayCustomerProductDetails/>
            },
            {
                path:"/register",
                element:<Register/>
            },
            {
                path:"/login",
                element:<Login/>
            }

        ]
    }
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <>
        <RouterProvider router={projectRoutes}></RouterProvider>
        <ToastContainer
            position="top-right"
            autoClose={2000}
            hideProgressBar={false}
            newestOnTop={false}
            closeOnClick={false}
            rtl={false}
            pauseOnFocusLoss
            draggable
            pauseOnHover
            theme="dark"
            transition={Zoom}
            />
    </>
);

