import { createRoot } from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import Home from './customer_components/Home'

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'
import Login from './common_components/Login.jsx'
import Register from './common_components/Register.jsx'
import { Bounce, ToastContainer } from 'react-toastify'
import LoggedInUserProvider from './project_context/LoggedInUserContext.jsx'
import VendorDashboard from './vendor_components/VendorDashboard.jsx'
import ManageCategories from './vendor_components/ManageCategories.jsx'
import ManageSubCategories from './vendor_components/ManageSubCategories.jsx'

const projectRouts=createBrowserRouter([
  {
    path:"/",
    element:<Home/>,
    children:
    [
      { path:"/login" , element: <Login/>},
      { path:"/register" , element: <Register/>}
    ]
  },
  {
    path:"/vendor",
    element:<VendorDashboard/>,
    children:[
      { path:"/vendor/manage-categories", element:<ManageCategories/>},
      { path:"/vendor/manage-sub-categories", element:<ManageSubCategories/>}
    ]
  }
])

createRoot(document.getElementById('root')).render(
  <>
      <LoggedInUserProvider>
        <RouterProvider router={projectRouts}/>
      </LoggedInUserProvider>
      <ToastContainer
        position="top-right"
        autoClose={1000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick={false}
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
        theme="light"
        transition={Bounce}
        />
  </>
  
  
)
