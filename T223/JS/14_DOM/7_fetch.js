let root = document.getElementById("root")

fetch("https://api.github.com/users")
    .then((response)=>
        {
            response.json()
                        .then((data)=>
                            {
                                console.log(data);
                                data.map(user => 
                                    {
                                        let h1=document.createElement("h1")
                                        h1.textContent = user.login
                                        let img = document.createElement("img")
                                        img.setAttribute("src",user.avatar_url)
                                        root.appendChild(img)
                                    })

                            })
                        .catch((error)=>
                            {
                                console.log("data is may not be converted into json");
                            })
        })
    .catch((error)=>
        {
            console.log("API/URL may be wrong");
        })