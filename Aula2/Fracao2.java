import java.util.Scanner;

class Fracao {

	Scanner input = new Scanner(System.in);
	float numerador, denominador, fracao;

	public void set_numerador() {
		System.out.print("Digite o numerador: ");
		this.numerador = input.nextInt();
	}

	public void set_denominador() {
		do {
			System.out.print("Digite o denominador: ");
			this.denominador = input.nextInt();
		} while (this.denominador == 0);
	}

	public float fracao() {
		return numerador / denominador;
	}

}

public class Fracao2 {
    public static void main(String[] args) {
      Fracao fracao = new Fracao();
      fracao.set_numerador();
		  fracao.set_denominador();
      System.out.printf("A fracao = %f\n", fracao.fracao());
    }
}
