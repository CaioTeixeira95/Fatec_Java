import java.util.Scanner;

public class MaiorMenor{
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int n1 = 0, n2 = 0;

    System.out.print("Digite o primeiro número: ");
    n1 = input.nextInt();

    System.out.print("Digite o segundo número: ");
    n2 = input.nextInt();

    if (n1 > n2) {
      System.out.println("O número " + n1 + " é maior.");
    } else if (n2 > n1) {
      System.out.println("O número " + n2 + " é maior.");
    } else {
      System.out.println("Os dois números são iguais.");
    }

  }
}
