import { createContext, useState } from "react"

export const ThemeContext=createContext()

export function ThemeProvider(props)
{
    let [theme,setTheme]=useState("light")
    let themeStyle = {}
    if(theme==="dark")
    {
        themeStyle={navbar:"navbar-dark", text:"text-light", background:"bg-dark"}
    }
    else
    {
       themeStyle={navbar:"navbar-light", text:"text-dark", background:"bg-light"}
    }

    return (
        <ThemeContext.Provider value={{theme,setTheme,themeStyle}}>
            {props.children}
        </ThemeContext.Provider>
    )
}