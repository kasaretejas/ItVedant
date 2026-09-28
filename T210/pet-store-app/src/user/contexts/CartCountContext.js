const { createContext, useState } = require("react");


export const CartCounterContext=createContext()

export default function CartCounterProvider(props)
{
    let [cartCount, setCartCount]=useState(0)
    return(
        <CartCounterContext.Provider value={{cartCount,setCartCount}}>
            {props.children}
        </CartCounterContext.Provider>
    )
}