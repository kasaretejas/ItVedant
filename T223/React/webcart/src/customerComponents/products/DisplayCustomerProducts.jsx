import React from 'react'
import { Link } from 'react-router-dom';

export default function DisplayCustomerProducts(props) {
  let products = props.productsValue
  console.log(products);
  
  return (
    <div className='container'>
      
      <div className="row">
        {
          products.map((product)=>
            {
              return <div className="col-3 mb-4" key={product.id}>
                <div class="card" style={{width:"18rem"}}>
                  <img src={`http://localhost:8080/images/${product.imageName}`} className="card-img-top ms-auto me-auto" alt="..." style={{height:"150px", width:"150px"}}/>
                  <div class="card-body">
                    <h5 class="card-title text-capitalize text-center">{product.name.slice(0,15)}</h5>
                    <p className='fw-bold'> &#8377; {product.price}</p>
                    <div className='d-flex justify-content-between'>
                      <span className='bg-primary badge'>{product.brand}</span>
                      <span className='bg-warning badge'>{product.subCategory.category.name} - {product.subCategory.name}</span>
                    </div>
                    <p className='pb-0 mb-0' style={{textAlign:"justify"}}>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vero sapiente veniam, voluptate quaerat laboriosam at!</p>
                    <div className='text-end mt-0 pt-0'>
                        <Link to={`/${product.id}`} >
                          <i className="bi bi-arrow-right-circle-fill fs-4 text-secondary"></i>
                        </Link>
                    </div>
                  </div>
                </div>
              </div>
            })
        }
      </div>
    </div>
  )
}
