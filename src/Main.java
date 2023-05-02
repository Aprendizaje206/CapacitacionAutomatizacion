package src;

public class Main {
        public static void main(String[] args) {
            Calculadora calculadora = new Calculadora();
            System.out.println("3 + 2 = " + calculadora.sumar(3, 2));
            System.out.println("3 - 2 = " + calculadora.restar(3, 2));
            System.out.println("3 * 2 = " + calculadora.multiplicar(3, 2));
            System.out.println("3 / 2 = " + calculadora.dividir(3, 2));
        }
}