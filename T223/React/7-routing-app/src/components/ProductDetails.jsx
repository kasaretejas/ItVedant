import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'

export default function ProductDetails() 
{
    let urlParameters=useParams()
    console.log(urlParameters); //urlParameters={id:'1'}
    console.log(urlParameters.id); //1
    let productId = urlParameters.id

    let [product, setProduct]=useState({})

    async function fetchProductById(productId)
    {
        let respone=await fetch(`https://dummyjson.com/products/${productId}`)
        let data =await respone.json()
        setProduct(data)
    }
    useEffect(()=>{fetchProductById(productId)},[productId])
    
    
  return (
    <div>
        {
            Object.keys(product).length === 0?"Loading....":
                    <div className="card m-5" style={{width:"18rem"}}>
                        <img src={product.thumbnail} height={250} width={100} className="card-img-top" alt="..." />
                        <div className="card-body">
                            <h5 className="card-title">Card title</h5>
                            <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                            <Link className="btn btn-warning">Add to cart</Link>
                        </div>
                    </div>
        }
    </div>
  )
}
