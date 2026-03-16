function calcular(x, i, j) {
    switch (x) {
        case "+": 
            return (i+j)
        case "-": 
            return (i-j)
        
        case "*": 
            return (i*j)
        
        case "/": 
            return (i/j)
        
    }
}

let soma = "+"
let subtracao = "-"
let multiplicacao = "*"
let divisao = "/"

let a = 15
let b = 2

console.log(calcular(soma, a, b))
console.log(calcular(subtracao, a, b))
console.log(calcular(multiplicacao, a, b))
console.log(calcular(divisao, a, b))

