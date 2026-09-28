let myh1=document.getElementById("myh1")
let btn1=document.getElementById("btn1")

btn1.addEventListener("click", ()=>{
    myh1.textContent = "New Text"
})

let root = document.getElementById("root")
btn2.addEventListener("click", ()=>{
    root.innerHTML = "<h3>Hello JS </h3>"
})