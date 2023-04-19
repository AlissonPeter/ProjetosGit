let name = "Mike";
let age = 18;

console.log(`O ${name} tem ${age} anos`);

//objeto
const person = {
    name: 'John',
    age:30,
    weight: 88.6
}

//Array
const animals = [
    'Lion',
    'Monkey',
    'Cat'
]

//Array com objeto
const test = [
    'Lion',
    'Monkey',
    {
        name1: 'Cat',
        age1: 3
    }
]

console.log(test[2].age1);