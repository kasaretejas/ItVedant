let employees = 
[
    { name:"raj", age:25},
    { name:"amit", age:29},
    { name:"rani", age:32}
]

let root = document.getElementById("root")
employees.map((employee) => {
    let h1=document.createElement("h1")
    h1.textContent = `${employee.name}`
    h1.style.color="blue"
    root.appendChild(h1)
})