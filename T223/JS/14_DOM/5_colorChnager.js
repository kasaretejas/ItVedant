let myName = document.getElementById("myName")
let start = document.getElementById("start")
let stop = document.getElementById("stop")

let intervalID;
function startChangingColor()
{
    let colors = ["red","blue","green","yellow","aqua",
        "orange","purple","black","red","blue"]
    intervalID=setInterval(()=>{
        myName.style.color = colors[Math.floor(Math.random()*10)]
    }, 100)
}

start.addEventListener("click", ()=>{ startChangingColor() })

stop.addEventListener("click", ()=>{ clearInterval(intervalID) })