import React from 'react'
import { Link } from 'react-router-dom';

export default function DisplayProduct(props) 
{
    let products = props.productsArray
    console.log(products);
    
  return (
    <div className='container mt-5'>
        <div className='row'>
            {props.loadingValue?"Loading....":products.map(product => {return (
                <div className='col-3 mb-3' key={product.id}>
                    <div className="card" style={{width:"18rem"}}>
                        <img src={product.thumbnail} height={250} width={100} className="card-img-top" alt="..." />
                        <div className="card-body">
                            <h5 className="card-title">Card title</h5>
                            <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                            <Link to={`/products/${product.id}`}  className="btn btn-primary">View More</Link>
                        </div>
                    </div>
                </div>
            )})}
        </div>
    </div>
  )
}
