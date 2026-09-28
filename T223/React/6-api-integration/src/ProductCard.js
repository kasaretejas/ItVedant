import React from 'react'

export default function ProductCard(props)
 {
    let products = props.productsArray
    console.log(`products in ProductCard comp - ${products}`);
    
  return (
        <div className='container'>
            <div className='row'>
                {products.length>0? products.map(
                    (product)=>
                        {
                            // return <h1 key={product.id}>{product.title}</h1>
                            return (
                                <div key={product.id} className='col-3'>
                                        <div className="card p-3" style={{width:"18rem"}}>
                                            <img src={product.image} className="card-img-top" alt="..." height={300} width={200}/>
                                            <div className="card-body">
                                                <h5 className="card-title">{product.title.slice(0,20)}</h5>
                                                <div className='d-flex justify-content-between'>
                                                    <p>&#8377;{product.price}</p>
                                                    <p><span className='text-warning'>★</span>{product.rating.rate}/5</p>
                                                </div>
                                                <p className="card-text text-justify">{product.description.slice(0,80)}...</p>
                                                <div className='d-flex justify-content-between'>
                                                    <a href="#" className="btn btn-primary">View</a>
                                                    <a href="#" className="btn btn-warning">Add to Cart</a>
                                                </div>
                                            </div>
                                        </div>           
                                </div>
                            )
                        }
                ):""}
            </div>
        </div>
  )
}
