let root = document.getElementById("root")
let btn = document.getElementById("btn")
//propogation : spreading/moving/expanding of event from parent to child and
//and vice-versa 

//bubling : spreading of event from child to parent
// root.addEventListener("click", ()=>{ console.log("div is clicked - parent") })
// btn.addEventListener("click", ()=>{ console.log("button is clicked - child") })

//capturing : spreading of event from parent to child
// root.addEventListener("click", ()=>{ console.log("div is clicked - parent") },true)
// btn.addEventListener("click", ()=>{ console.log("button is clicked - child") },true)

//stoping bubling propgation
// root.addEventListener("click", ()=>{ console.log("div is clicked - parent") })
// btn.addEventListener("click", (event)=>
//     { 
//         console.log(event);
//         event.stopPropagation()
//         console.log("button is clicked - child") 

//     })

//stoping capturing propgation
root.addEventListener("click", (event)=>
    { 
        event.stopPropagation()
        console.log("div is clicked - parent") 
    },true)
btn.addEventListener("click", ()=>{console.log("button is clicked - child") }, true)