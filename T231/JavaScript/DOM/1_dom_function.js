let h1_red=document.getElementById("h1_red")
console.log(h1_red);
h1_red.style.color="red"


let in_green = document.getElementsByClassName("in_green")
console.log(in_green);
//in_green.style.color="green"
for(let element of in_green)
{
    element.style.color="green"
}


let paragraphs = document.getElementsByTagName("p")
for(let paragraph of paragraphs)
{
    paragraph.style.color="blue"
}

let nestedP=document.querySelector("div>section>p")
nestedP.style.color="orange"

let nestedAllP =  document.querySelectorAll("div>section>p")
for(let p of nestedAllP)
{
    p.style.backgroundColor="pink"
}
