import { useEffect, useState } from "react";

function useFetch(url)
{
    let[data, setData]=useState(null)
    //if we have to call any sync function on dependency change in useEffect, then write that function
    //directly inside useEffect and also call it inside useEffect only
    useEffect(()=>
        {
            async function fetchData()
                {
                    let response=await fetch(url);
                    let responseData=await response.json()
                    setData(responseData)
                }
            fetchData()
        }, [url])

    return {data}
}

export default useFetch;