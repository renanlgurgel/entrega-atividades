/* 

Esse foi o código parcial cedido pelo professor:

https://github.com/franciscodnn/pw2-2026-1/blob/main/examples/objects/Exam.js



Exercício disponível em:

https://ifpb.github.io/exercises/problems/object-exam/?authuser=3


*/

class Exam { 
    constructor (weight, correctAnswers) {
        this.weight = weight;
        this.correctAnswers = correctAnswers;
        this.studentAnswers = [];
    }
}

const pw2 = new Exam([2, 4, 4], ['a', 'd', 'b']);

pw2.add(['b', 'b', 'b']);

// Média das notas
pw2.avg();

// Vetor com três menores notas
pw2.min(3); 

// Vetor com cinco maiores notas
pw2.max(5);

// Vetor com todas as notas menores do que 5,0
pw2.lt(5);

// Vetor com todas as notas maiores do que 7,0
pw2.gt(7);