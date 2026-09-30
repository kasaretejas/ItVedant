import { createRoot } from 'react-dom/client'
import Home from './customer/Home'

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'
import { BrowserRouter, createBrowserRouter, RouterProvider } from 'react-router-dom'
import Login from './common/Login.jsx'
import Register from './common/Register.jsx'
import { ToastContainer, Zoom } from 'react-toastify'
import AdminDashboard from './admin/AdminDashboard.jsx'
import VendorDashboard from './vendor/VendorDashboard.jsx'
import ManageCategories from './admin/ManageCategories.jsx'
import ManageSubCategories from './vendor/ManageSubCategories.jsx'
import AddProduct from './vendor/AddProduct.jsx'
import FetchMyProducts from './vendor/FetchMyProducts.jsx'
import UpdateProduct from './vendor/UpdateProduct.jsx'
import Cart from './customer/Cart.jsx'
import FetchCustomerProducts from './customer/FetchCustomerProducts.jsx'
import Orders from './customer/Orders.jsx'

const myRoutes=createBrowserRouter(
  [
    {
      path:'/',
      element:<Home/>,
      children:
      [
        {index:true, element:<FetchCustomerProducts/>},
        { path:"/login", element:<Login/> },
        { path:"/register", element : <Register/> },
        { path:"/my-cart", element : <Cart/> },
        { path:"/my-orders", element : <Orders/> }
      ]  
    },
    {
      path:"/admin",
      element : <AdminDashboard/>,
      children : 
      [
        { path:"/admin/manage-categories", element:<ManageCategories/> },
      ]
    },
    {
      path:"/vendor",
      element : <VendorDashboard/>,
      children :
      [
        { index:true, element:<FetchMyProducts/> },
        { path:"/vendor/manage-sub-categories", element:<ManageSubCategories/> },
        { path:"/vendor/add-product", element:<AddProduct/> },
        { path:"/vendor/update-product/:productId", element:<UpdateProduct/> },
      ]
    }
  ])

createRoot(document.getElementById('root')).render
(
  <>
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
      transition={Zoom}
    />
    <RouterProvider router={myRoutes} />
  </>
  
)
