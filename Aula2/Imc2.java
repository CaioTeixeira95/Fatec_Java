import java.util.Scanner;

class Imc {

  float peso = 0, altura = 0;

  public void set_peso(float peso) {
    this.peso = peso;
  }

  public void set_altura(float altura) {
    this.altura = altura;
  }

  public float imc() {
    return this.peso / (this.altura * this.altura);
  }

}

public class Imc2 {
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    float peso = 0, altura = 0;
    Imc i = new Imc();

    System.out.print("Digite o seu peso: ");
    peso = s.nextFloat();
    i.set_peso(peso);

    System.out.print("Digite o seu altura: ");
    altura = s.nextFloat();
    i.set_altura(altura);

    System.out.println("O seu ICM é: " + i.imc());

  }
}
