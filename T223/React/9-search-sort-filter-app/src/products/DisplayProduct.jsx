import React from 'react'

export default function DisplayProduct(props) {
  let products = props.productsArray
  console.log(products);
  return (
    <div className="row">
      {products.map(product => {return (
        <div className="col-3 mb-5" key={product.id}>
          <div className="card" style={{width:"18rem"}}>
            <img src={product.thumbnail} className="card-img-top" alt="..." style={{height:"200px",width:"200px"}}/>
            <div className="card-body">
              <h5 className="card-title">Card title</h5>
              <p className='card-text'>{product.category}</p>
              <p className='card-text'>{product.price}</p>
              <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
              <a href="https://facebook.com" className="btn btn-primary">Go somewhere</a>
            </div>
          </div>
        </div>
      )})}
    </div>
  )
}
