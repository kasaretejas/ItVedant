let root = document.getElementById("root")

async function fetchUsersData ()
{
   let response = await fetch("https://api.github.com/users")
   let data = await response.json()
   console.log(data);
   for(let user of data)
   {
        let myImage = document.createElement("img")
        myImage.setAttribute("src", user.avatar_url)
        myImage.setAttribute("height", "200")
        myImage.setAttribute("width", "200")
        root.appendChild(myImage)
   }
}

fetchUsersData()