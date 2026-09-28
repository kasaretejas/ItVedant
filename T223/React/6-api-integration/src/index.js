import React from 'react';
import ReactDOM from 'react-dom/client';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import FetchProducts from './FetchProducts.js';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <FetchProducts/>
);
