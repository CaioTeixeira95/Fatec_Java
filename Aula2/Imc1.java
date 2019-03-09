import java.util.Scanner;

public class Imc1 {
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.00");
    float peso = 0, altura = 0;

    System.out.print("Digite o seu peso: ");
    peso = s.nextFloat();

    System.out.print("Digite o seu altura: ");
    altura = s.nextFloat();

    System.out.println("Seu IMC é: " + df.format((peso) / (altura * altura)));

  }
}
