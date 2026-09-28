let myText = document.getElementById("text")
let btn = document.getElementById("btn")

btn.addEventListener("click",()=>{
    myText.textContent = "New Text"
})


let root = document.getElementById("root")
let btn2 = document.getElementById("btn2")

btn2.addEventListener("click",()=>{
    root.innerHTML = "<p> Hello I am new  p tag </p>"
})