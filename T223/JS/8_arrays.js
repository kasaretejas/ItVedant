//array is collection of values inside []
//array is zero based index
//duplicate values are allowed
//no fixed size

//1. creating array
let marks = [90,96,93,99]
console.log(marks);

//2. getting array size
console.log(marks.length);


//3. adding values in array
marks[0]=100 //value at index zero will be overriden
console.log(marks);
marks[8]=300 //dont use index larger than array size
console.log(marks);


//4. removing array items
delete marks[0] //not recommonded
console.log(marks);

//built in functions on array
//built in function to add values in array
let prices = []
console.log(prices);
prices.push(199) //add at the end
prices.push(399)
console.log(prices);
prices.unshift(499); //add at the start
console.log(prices);

prices.pop() //remove from end
console.log(prices);
prices.shift() //remove from start
console.log(prices);

//accessing array elemets
let values = [24,45,7,6,97]

//single element : using index/position
console.log(values[0]);  //24
console.log(values[-1]); //undefined
console.log(values[8]);  //undefined

//elemets one by one : using simple for loop
console.log("using simple for loop");
for(let i=0; i<values.length; i++)
{
    console.log(values[i]);
    
}
//elemets one by one : using for of loop
console.log("using for of loop");
for(let value of values)
{
    console.log(value); 
}

//elemets one by one : using for in loop
console.log("using for in loop");
for(let index in values)
{
    console.log(index); 
}

//map, filter, reduce

