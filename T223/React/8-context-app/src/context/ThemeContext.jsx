//prop drilling : passing data between multiple components
//context solve this problem by providing one stop solution
//steps 
//  1. we have to create context, 
//  2. add data in it, 
//  3. apply context on root or component level, 
//  4. useContext in any component we want --> we will get data without props

import { createContext, useState } from "react";

export const ThemeContext=createContext()

export function ThemeProvider(props)
{
    let[theme, setTheme]=useState('light')
    let themeStyle = ""
    theme==='light'?
        themeStyle="bg-light text-dark":
        themeStyle="bg-dark text-light"
    return (
        <ThemeContext.Provider value={{theme, setTheme, themeStyle}}>
            {props.children}
        </ThemeContext.Provider>
    )
}