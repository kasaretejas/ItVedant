async function fetchData()
{
    let repsonse=await fetch("https://dummyjson.com/test")
    let data =  await repsonse.json()
    console.log(data);
    
}

fetchData()