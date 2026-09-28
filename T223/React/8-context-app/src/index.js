import React from 'react';
import ReactDOM from 'react-dom/client';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'
import { createBrowserRouter, Route, RouterProvider } from 'react-router-dom';
import App from './components/App.jsx';
import Products from './components/Products.jsx';
import Home from './components/Home.jsx';
import Contact from './components/Contact.jsx';
import { ThemeProvider } from './context/ThemeContext.jsx';
let routes = createBrowserRouter(
    [
        {
            path:"/",
            element:<App/>,
            children:
            [
                {element:<Home/>, index:true},
                {path:"/products",element:<Products/>},
                {path:"/contact",element:<Contact/>},

            ]
        }
    ])
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <ThemeProvider>
        <RouterProvider router={routes}/>
    </ThemeProvider>

);

