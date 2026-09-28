let root = document.getElementById("root")

fetch("https://api.github.com/users")
    .then((response)=>
        {
            response.json()
                        .then((data)=>
                                {
                                    console.log(data);  
                                    for(let user of data)
                                    {
                                        let myh1=document.createElement("h1")
                                        myh1.textContent = user.login
                                        root.appendChild(myh1)
                                    }
                                })
                        .catch((error)=>{})
        })
    .catch((error)=>{})