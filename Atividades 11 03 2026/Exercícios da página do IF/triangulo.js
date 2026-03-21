function definirTipoTriangulo(a, b, c) {
    if (a <= 0 || b <= 0 || c <= 0 || (a + b <= c) || (a + c <= b) || (b + c <= a)) {
        return "none";
    }

    if (a === b && b === c) {
        return "equilateral";
    } else if (a === b || b === c || a === c) {
        return "isosceles";
    } else {
        return "escaleno";
    }
}

// Casos de Teste (0 a 12)
let [a0, b0, c0] = [2, 2, 2];     // equilateral
let [a1, b1, c1] = [10, 10, 10];  // equilateral
let [a2, b2, c2] = [3, 4, 4];     // isosceles
let [a3, b3, c3] = [4, 3, 4];     // isosceles
let [a4, b4, c4] = [4, 4, 3];     // isosceles
let [a5, b5, c5] = [10, 10, 2];   // isosceles
let [a6, b6, c6] = [3, 4, 5];     // escaleno
let [a7, b7, c7] = [10, 11, 12];  // escaleno
let [a8, b8, c8] = [5, 4, 2];     // escaleno
let [a9, b9, c9] = [0, 0, 0];     // none (Lados zero)
let [a10, b10, c10] = [3, 4, -5]; // none (Lado negativo)
let [a11, b11, c11] = [1, 1, 3];  // none (Não fecha o triângulo)
let [a12, b12, c12] = [2, 4, 2];  // none (Triângulo degenerado/linha)

// Execução
console.log(definirTipoTriangulo(a0, b0, c0));
console.log(definirTipoTriangulo(a1, b1, c1));
console.log(definirTipoTriangulo(a2, b2, c2));
console.log(definirTipoTriangulo(a3, b3, c3));
console.log(definirTipoTriangulo(a4, b4, c4));
console.log(definirTipoTriangulo(a5, b5, c5));
console.log(definirTipoTriangulo(a6, b6, c6));
console.log(definirTipoTriangulo(a7, b7, c7));
console.log(definirTipoTriangulo(a8, b8, c8));
console.log(definirTipoTriangulo(a9, b9, c9));
console.log(definirTipoTriangulo(a10, b10, c10));
console.log(definirTipoTriangulo(a11, b11, c11));
console.log(definirTipoTriangulo(a12, b12, c12));

//Exercícios retirados de https://ifpb.github.io/exercises/