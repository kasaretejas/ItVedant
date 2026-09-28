import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'
import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import App from './App';
import ErrorComponent from './ErrorComponent';
import AddPetType from './admin/petComponents/AddPetType';
import AddPetBreed from './admin/petComponents/AddPetBreed';


import AddPet from './admin/petComponents/AddPet.js';
import UpdatePet from './admin/petComponents/UpdatePet.js';
import FetchAllPets from './admin/petComponents/FetchAllPets.js';
import Home from './user/homeComponents/Home.js';
import Unauthorized from './Unauthorized.js';
import Login from './common/Login.js';
import Register from './common/Register.js';
import ProtectedRoute from './routeProtector/ProtectedRoute.js';
import GetAllPets from './user/petComponents/GetAllPets.js';
import Cart from './user/cartAndOrderComponents/Cart.js';
import CartCounterProvider from './user/contexts/CartCountContext.js';

const allRoutes=createBrowserRouter([
    //new routing after spring security
    //ADMIN routes
    {
        path:'/admin',
        element:<ProtectedRoute roleRequired="ADMIN"/>,
        children:
        [
            {
                path:"",
                element:<App/>,
                errorElement:<ErrorComponent/>,
                children:[
                    { path: "add-pet-type", element: <AddPetType /> },
                    { path: "add-pet-breed", element: <AddPetBreed /> },
                    { path: "add-pet", element: <AddPet /> },
                    { path: "manage-pets", element: <FetchAllPets /> },
                    { path: "update-pet/:petId", element: <UpdatePet /> }

                ]
            }
        ]
    },

    // PUBLIC ROUTES
    {
        path: "/",
        element: <CartCounterProvider><Home/></CartCounterProvider>,
        errorElement: <ErrorComponent />,
        children:
        [
            { path: "", element: <GetAllPets /> },
            { path: "login", element: <Login /> },
            { path: "register", element: <Register /> },
            { path: "unauthorized", element: <Unauthorized /> }, // Create a simple unauthorized page,
            {
                path: "my",
                element: <ProtectedRoute roleRequired="CUSTOMER" />,  // ⭐ Customer protected
                children: 
                    [
                        { path: "cart", element: <Cart/> }
                    ]
            },  
        ]
    }
])



const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <RouterProvider router={allRoutes}/>
);

