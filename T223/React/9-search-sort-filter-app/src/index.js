import React from 'react';
import ReactDOM from 'react-dom/client';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import '../node_modules/bootstrap-icons/font/bootstrap-icons.min.css'
import FetchProducts from './products/FetchProducts';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <FetchProducts/>
);

