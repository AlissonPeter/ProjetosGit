//functons expression
//functions anonymous
const sum =  function(number1, number2){
    //console.log(number1 + number2);
    let total = number1 + number2;
    return total;
}

sum(2, 3)

console.log(` A soma é ${sum(28, 23)}`)


let subject = 'Create video'

function createThing(subject) {
    subject = 'study'
    return subject;
}

console.log(createThing(subject))
console.log(subject);




//arrow function
const sayMyName = (name2) => {
    console.log(name2)
}

sayMyName('Alisson');




//callback function
function sayMyName2(name) {
    console.log('antes de executar a função callback')
    name()
    console.log('depois de executar callback')
}

sayMyName2(
    () => {
        console.log('estou em uma callback')
    }
)




// Function() construtor
function Person(name) {
    this.name = name;
    this.walk = function() {
        return this.name + " está andando"
    }
}

const mayk = new Person('Mayk')
const joao = new Person('João')
console.log(mayk.walk())
console.log(joao.walk())