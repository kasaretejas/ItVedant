let root1 = document.getElementById("root1")
let btn1 = document.getElementById("btn1")

btn1.addEventListener("click", ()=>
    {
        let myh1 = document.createElement("h1")
        myh1.textContent = "Hello JS"
        root1.appendChild(myh1)
    })


let root2 = document.getElementById("root2")
let btn2 = document.getElementById("btn2")
btn2.addEventListener("click", ()=>
    {
        let myImage = document.createElement("img")
        myImage.setAttribute("src", "https://freepngimg.com/thumb/categories/2897.png")
        root2.appendChild(myImage)
    })