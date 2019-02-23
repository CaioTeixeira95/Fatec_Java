import java.util.Scanner;

public class Adicao {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int n1 = 0, n2 = 0;

    System.out.print("Digite o primeiro número: ");
    n1 = input.nextInt();

    System.out.print("Digite o primeiro número: ");
    n2 = input.nextInt();

    System.out.println("A soma entre " + n1 + " e " + n2 + " é: " + (n1 + n2));
    
  }
}
