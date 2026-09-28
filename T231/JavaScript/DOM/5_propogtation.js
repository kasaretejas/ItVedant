let div = document.getElementById("div")
let btn = document.getElementById("btn")


//propogation : spreading of event from child to parent OR parent to child

//if event is propogating from child to parent : bubbling
//if event is propogating from parent to child : capturing

//bubbling
// div.addEventListener("click", ()=>{ console.log("div clicked") } )
// btn.addEventListener("click", ()=>{ console.log("button clicked") } )

//capturing
div.addEventListener("click", ()=>{ console.log("div clicked") },true )
btn.addEventListener("click", ()=>{ console.log("button clicked") } )