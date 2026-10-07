let marks = [90,45,78,99]
console.log("--------- map --------------");
//display each mark separatly
//map( (multiple paramenetsr)=>{ multiline logic } ) 
//map( only one parameter => single line code) 
marks.map(mark => console.log(mark))

//give grace 2 marks for each subject
marks.map(mark => console.log(mark+2))


console.log("--------- filter --------------");
// let result = filter( () => condition )
//print only even marks ----->

let filtredMarks=marks.filter( mark => mark%2==0)
console.log(filtredMarks);

console.log("--------- reduce --------------");
//reduce entire array to single value - sum, avg, min, max
//reduce((accumativeValue, valueFromArray) => {logic},initialValue)
let sumOfArray=marks.reduce((sum, mark) => { return sum = sum+mark },0)
console.log(sumOfArray);
