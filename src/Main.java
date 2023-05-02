package src;

public class Main {
        public static void main(String[] args) {
            Calculadora calcBasica = new Calculadora();
            System.out.println("3 + 2 = " + calcBasica.sumar(3, 2));
            System.out.println("3 - 2 = " + calcBasica.restar(3, 2));
            System.out.println("3 * 2 = " + calcBasica.multiplicar(3, 2));
            System.out.println("3 / 2 = " + calcBasica.dividir(3, 2));
        }
}