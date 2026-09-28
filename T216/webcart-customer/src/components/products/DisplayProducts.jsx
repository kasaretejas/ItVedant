import React from 'react'
import { Link } from 'react-router-dom'

export default function DisplayProducts(props) 
{
    let products = props.productsArray
  return (
    <div className='container'>
      <div className='row'>
        {products===null? "Loading" : products.map((product)=>{
            return (
                <div className='col' key={product.id}>
                    <div className="card" style={{width:"15rem"}}>
                        <img src={`http://localhost:8080/images/${product.imageName}`} className="card-img-top" alt="..."/>
                        <div className="card-body">
                            <h5 className="card-title">{product.brand}</h5>
                            <p className="card-title">{product.name.slice(0,20)}...</p>
                            <p className="card-title">{product.subCategory.category.name} : {product.subCategory.name}</p>
                            <p className="card-title"> &#8377; {product.price}</p>
                            <div className='d-flex justify-content-between'>
                                <Link href="#" className="btn btn-primary" to={`/products/${product.id}`}>View More</Link>
                                <Link href="#" className="btn btn-success">Buy Now</Link>
                            </div>
                        </div>
                    </div>
                </div>
            )
        })}
      </div>
    </div>
  )
}
