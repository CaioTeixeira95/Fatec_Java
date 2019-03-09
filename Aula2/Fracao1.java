import java.util.Scanner;

public class Fracao1 {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    double numerador = 0.0, denominador = 0.0, fracao = 0.0;

    System.out.print("Digite o numerador: ");
    numerador = input.nextInt();

    System.out.print("Digite o denominador: ");
    denominador = input.nextInt();

    fracao = numerador / denominador;

    System.out.println("A fração é: " + fracao);

  }
}
