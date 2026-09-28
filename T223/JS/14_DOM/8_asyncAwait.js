// setInterval(() => {
//     console.log("Hi after 2 sec");
    
// }, 2000);

// function getUsers()
// {
//     fetch("https://api.github.com/users")
//     .then((response)=>
//         {
//             console.log("Hello I got response");
//             response.json()
//                         .then((data)=>{console.log(data)})
//                         .catch((error)=>{})
//         })
//     .catch((error)=>{})
// }
// getUsers()

// function sayHello()
// {
//     console.log("Hello");
// }
// sayHello()

// console.log("This is last line");


async function getUsers()
{
    console.log("Calling fetch");
    let response= await fetch("https://api.github.com/users")
    console.log("converting into json");
    let data = await response.json()
    console.log(data); 
}
getUsers()
console.log("DONE");






