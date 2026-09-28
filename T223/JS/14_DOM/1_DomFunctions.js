let inRed = document.getElementById("inRed")
console.log(inRed);
inRed.style.color = "red"

let inGreen= document.getElementsByClassName("inGreen")
console.log(inGreen); //here we are getting an array
//inGreen.style.color = "green"
for(let element of inGreen)
{
    element.style.color="green"
}


let h3Tags = document.getElementsByTagName("h3")
for(let h3tag of h3Tags)
{
    h3tag.style.color = "blue"
}



let nested_h1=document.querySelector("div>section>h1")
nested_h1.style.color = "aqua"



let all_nested_h1 = document.querySelectorAll("div>section>h1")
for(let myh1 of all_nested_h1)
{
    myh1.style.backgroundColor = "pink"
}
