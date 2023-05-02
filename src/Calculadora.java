package src;

class Calculadora extends Operaciones {
    public double sumar(double a, double b) {
        return 0;
    }
    public double restar(double a, double b) {
        return 0;
    }
    public double multiplicar(double a, double b) {
        return 0;
    }
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        return 0;
    }
}