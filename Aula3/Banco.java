import java.util.Scanner;

class Usuario {

	Scanner s = new Scanner(System.in);
	String nome;
	String senha;
	int conta;

	public Usuario(String nome, String senha, int conta) {
		this.nome = nome;
		this.senha = senha;
		this.conta = conta;
	}

	public void alterarConta() {
		


		if(this.pedirSenha()) {

			int contaTemp = 0;

			System.out.print("Digite o seu tipo de conta.\n\n 1 - Conta Corrente.\n 2 - Conta Poupanca.\n 3 - Ambas"); 
			contaTemp = s.nextInt();

		}
		else {
			System.out.println("Senha incorreta!");
		}

	}

	public void alterarSenha() {
		
		String senhaTemp = "";
		System.out.print("Digite a sua senha: ");
		senhaTemp = s.next();

		if(this.pedirSenha()) {

			System.out.print("Digite a nova senha: "); 
			this.senha = s.next();

		}
		else {
			System.out.println("Senha incorreta!");
		}

	}

	public boolean pedirSenha() {

		String senhaTemp = "";
		System.out.print("Digite a sua senha: ");
		senhaTemp = s.next();

		if(senhaTemp.equals(this.senha)) {
			return true;
		}

		return false;
	}
}

class ContaCorrente {

	double saldo = 0.0;

	public void depositar(double valor) {
		System.out.printf("Valor depositado =  %f \n", valor);
		this.saldo = this.saldo + valor;
	}
		
	public void depositar(String string_valor) {
		double valor = Double.parseDouble(string_valor);
		System.out.printf("Valor depositado =  %f \n", valor);
		this.saldo = this.saldo + valor;
	}
	
	public void saque(double valor) {
		System.out.printf("Valor sacado =  %f \n", valor);
		this.saldo = this.saldo - valor;
	}
	
	public double saldo() {
		return this.saldo;
	}
}

class ContaPoupanca {
	
	double saldo = 0.0;

	public void depositar(double valor) {
		System.out.printf("Valor depositado =  %f \n", valor);
		this.saldo = this.saldo + valor;
	}
	
	public void depositar(String string_valor) {
		double valor = Double.parseDouble(string_valor);
		System.out.printf("Valor depositado =  %f \n", valor);
		this.saldo = this.saldo + valor;
	}
	
	public void resgatar(double valor) {
		System.out.printf("Valor sacado =  %f \n", valor);
		this.saldo = this.saldo - valor;
	}
	
	public void rendimento(double porcentagem) {
		porcentagem = porcentagem / 100;
		this.saldo = this.saldo + (this.saldo * porcentagem);
	}

	public double saldo() {
		return this.saldo;
	}
}

public class Banco {

    public static void main (String[] args) {

    	Scanner s = new Scanner(System.in);
    	Usuario user = new Usuario("Orlando Saraiva Jr.", "python>java", 3);
    	ContaCorrente cc = new ContaCorrente();
    	ContaPoupanca cp = new ContaPoupanca();

    	int op = 0;
    	do {	

    		double valor = 0.0;

    		System.out.println("Bem-vindo ao banco Fatec!!\n");
    		System.out.println("1 - Depositar CC");
    		System.out.println("2 - Depositar CP");
    		System.out.println("3 - Sacar CC");
    		System.out.println("4 - Resgatar CP");
    		System.out.println("5 - Saldo CC");
    		System.out.println("6 - Saldo CP");
    		System.out.println("7 - Alterar tipo de Conta");
    		System.out.println("8 - Alterar Senha");
    		System.out.println("9 - Sair\n");

    		op = s.nextInt();

	    	switch(op) {

	    		case 1:
	    			if(user.pedirSenha()) {
	    				System.out.print("Digite o valor para depositar: ");
	    				valor = s.nextDouble();
	    				if(valor > 0) {
	    					cc.depositar(valor);
	    				}
	    				else {
	    					System.out.println("Não é possível depositar valor zerado ou negativo.");
	    				}
	    			}
	    		break;

	    		case 2:
	    			if(user.pedirSenha()) {
	    				System.out.print("Digite o valor para depositar: ");
	    				valor = s.nextDouble();
	    				if(valor > 0) {
	    					cp.depositar(valor);
	    				}
	    				else {
	    					System.out.println("Não é possível depositar valor zerado ou negativo.");
	    				}
	    			}
	    		break;

	    		case 3:
	    			if(user.pedirSenha()) {
	    				System.out.print("Digite o valor para à ser sacado: ");
	    				valor = s.nextDouble();
	    				if(valor > 0) {
	    					cc.saque(valor);
	    				}
	    				else {
	    					System.out.println("Não é possível sacar um valor zerado ou negativo.");
	    				}
	    			}
	    		break;

	    		case 4:
	    			if(user.pedirSenha()) {
	    				System.out.print("Digite o valor para à ser resgatado: ");
	    				valor = s.nextDouble();
	    				if(valor > 0) {
	    					cp.resgatar(valor);
	    				}
	    				else {
	    					System.out.println("Não é possível sacar um valor zerado ou negativo.");
	    				}
	    			}
	    		break;

	    		case 5:
	    			if(user.pedirSenha()) {
	    				cc.saldo();
	    			}
	    		break;
    			
    			case 6:
    				if(user.pedirSenha()) {
    					cp.saldo();
    				}
	    		break;

    			case 7:
    				user.alterarConta();
    			break;

    			case 8:
    				user.alterarSenha();
    			break;

    			case 9:
    			break;

    			default:
    				System.out.println("Opção inválida");
    			break;
    		}

    	} while(op != 9);
    }
}