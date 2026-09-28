import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import App from './components/App';
import FetchProducts from './components/products/FetchProducts';
import ProductDetails from './components/products/ProductDetails';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'
import NotFound from './components/errors/NotFound.jsx';
import Login from './components/authentication/Login.jsx';
import Register from './components/authentication/Register.jsx';
import Unauthorised from './components/errors/Unauthorised.jsx';
import ProtectedRoutes from './components/routerProtector/ProtectedRoutes.jsx';
import Cart from './components/cart/Cart.jsx';
import Orders from './components/cart/Orders.jsx';
import { Flip, ToastContainer } from 'react-toastify';
const myRoutes=createBrowserRouter([
  {
    path:"/",
    element:<App/>,
    errorElement:<NotFound/>,
    children:[
      // { element:<FetchProducts/>, index:true },
      { path:"/products/:id", element: <ProductDetails/>},
      { path:"login", element: <Login/>},
      { path:"register", element: <Register/>},
      { path:"unauthorized", element: <Unauthorised/>},
      {
        path:"my",
        element:<ProtectedRoutes roleRequired="CUSTOMER"/>,
        children:
        [
            { path: "cart", element: <Cart/> },
            { path: "orders", element: <Orders/> }
        ]

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

