import React from 'react';
import ReactDOM from 'react-dom/client';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import App from './components/App.jsx';
import FetchProducts from './components/product/FetchProducts.jsx';
import ManageCategories from './components/category/ManageCategories.jsx';
import ManageSubCategories from './components/subCategory/ManageSubCategories.jsx';
import AddProduct from './components/product/AddProduct.jsx';
import { Flip, ToastContainer } from 'react-toastify';
import UpdateProduct from './components/product/UpdateProduct.jsx';
import UpdateProductTest from './components/product/UpdateProductTest.jsx';

let myRoutes = createBrowserRouter([
    {
        path:"/vendor",
        element:<App/>,
        children:[
            {
                element:<FetchProducts/>,
                index:true
            },
            {
                path:"manage-categories",
                element:<ManageCategories/>,
            },
            {
                path:"manage-sub-categories",
                element:<ManageSubCategories/>,
            },
            {
                path:"manage-products",
                element:<FetchProducts/>,
            },
            {
                path:"add-product",
                element:<AddProduct/>,
            },
            {
                path:"update-product/:id",
                //element:<UpdateProduct/>,
                element:<UpdateProductTest/>,
            }
        ]
    }
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <>
        <RouterProvider router={myRoutes}/>
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
            theme="light"
            transition={Flip}
            />
    </>
);


