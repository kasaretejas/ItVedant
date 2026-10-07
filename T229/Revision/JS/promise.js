//here fetch will not directly gives data, instead it gives promise for response
//then()-----> for rersponse
//catch()----> for errors
fetch("https://dummyjson.com/test", {method : "get"})
    .then(repsonse => 
        {
            //convert respone to JSON
            repsonse.json()
                        .then(data=> { console.log(data)})
                        .catch(error => {console.log(error)})
        })
    .catch(error => {console.log(error)})
