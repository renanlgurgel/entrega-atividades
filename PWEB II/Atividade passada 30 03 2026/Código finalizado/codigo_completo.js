/*

Exercício disponível em:

https://ifpb.github.io/exercises/problems/object-exam/?authuser=3

*/

class Exam {
  #weight;
  #answer;
  #exams = [];


  constructor(answer, weight) {
    this.#answer = answer;
    this.#weight = weight;
  }

  add(studentAnswers) {
    let grade = 0;
    for (let i = 0; i < this.#answer.length; i++) {
      if (studentAnswers[i] === this.#answer[i]) {
        grade += this.#weight[i];
      }
    }
    this.#exams.push(grade);
  }

  avg() {
    if (this.#exams.length === 0) return 0;
    const total = this.#exams.reduce((acc, curr) => acc + curr, 0);
    return total / this.#exams.length;
  }

  min(count = 1) {
    return [...this.#exams].sort((a, b) => a - b).slice(0, count);
  }

  max(count = 1) {
    return [...this.#exams].sort((a, b) => b - a).slice(0, count);
  }

  lt(limit) {
    return this.#exams.filter(val => val < limit);
  }

  gt(limit) {
    return this.#exams.filter(val => val > limit);
  }

  get allExams() {
    return this.#exams;
}

}

const pw2 = new Exam(['a', 'b', 'a', 'c', 'd'], [2, 2, 2, 2, 2]);

pw2.add(['a', 'b', 'b', 'b', 'b']); //Caso de teste mencionado na questão
pw2.add(['a', 'b', 'a', 'c', 'd']); //Um aluno que supostamente gabaritou a prova e acertou tudo
pw2.add(['b', 'b', 'b', 'b', 'b']); //Um aluno que chutou tudo B
pw2.add(['a', 'c', 'd', 'b', 'a']); //Outro caso de teste hipotético


console.log(pw2.allExams);