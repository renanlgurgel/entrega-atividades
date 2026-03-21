const produtos = [
    {
        id: '1',
        preco: 10,
        qte: 2,
    },

    {
        id: '2',
        preco: 10,
        qte: 2,
    },

    {
        id: '3',
        preco: 10,
        qte: 2,
    },

    {
        id: '4',
        preco: 10,
        qte: 0
    },

    {
        id: '5',
        preco: 30,
        qte: 1
    }
]

let somatorio = 0;

for (let i = 0; i < Object.keys(produtos).length; i++) {  //Essa solução com Object.keys é interessante nesse caso
        somatorio += produtos[i].preco * produtos[i].qte //Essa alternativa permite calcular o valor total independentemente da quantidade de produtos no carrinho
    }

console.log(somatorio)