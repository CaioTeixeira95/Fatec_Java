import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class ContaPoupanca {

	String nome_titular;
	String numero_conta;
	double saldo;

	public ContaPoupanca() {
		this.nome_titular = "";
		this.numero_conta = "";
		this.saldo = 0.01;
	}
	
	public ContaPoupanca(String nome, String conta, double saldo_inicial) {
		this.nome_titular = nome;
		this.numero_conta = conta;
		this.saldo = saldo_inicial;
	}
	
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
		if(valor <= this.saldo()) {
			System.out.printf("Valor sacado =  %f \n", valor);
			this.saldo = this.saldo - valor;
		} else {
			System.out.println("Valor a ser sacado é maior que o saldo.");
		}
	}
	
	public void rendimento(double porcentagem) {
		porcentagem = porcentagem / 100;
		this.saldo = this.saldo + (this.saldo * porcentagem);
	}

	public double saldo() {
		return this.saldo;
	}
	
	public String getNumeroConta() {
		return this.numero_conta;
	}
	
	public String getNomeTitular() {
		return this.nome_titular;
	}
}

class ContaCorrente {
	String nome_titular;
	String numero_conta;
	double saldo;

	public ContaCorrente() {
		this.nome_titular = "";
		this.numero_conta = "";
		this.saldo = 0.01;
	}
	
	public ContaCorrente(String nome, String conta, double saldo_inicial) {
		this.nome_titular = nome;
		this.numero_conta = conta;
		this.saldo = saldo_inicial;
	}
	
	public void depositar(double valor) {
		System.out.printf("Valor depositado =  %f \n", valor);
		this.saldo = this.saldo + valor;
	}
	
	public void saque(double valor) {
		if (this.saldo > -500.00 && (this.saldo - valor) > -500.00) {	
			System.out.printf("Valor sacado =  %f \n", valor);
			this.saldo = this.saldo - valor;
		}
		else {
			System.out.println("Valor sacado é maior que o permitido.");
		}
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public String getNumeroConta() {
		return this.numero_conta;
	}
	
	public String getNomeTitular() {
		return this.nome_titular;
	}
}

class CarteiraClientes {
	
	ArrayList<ContaPoupanca> poupadores = new ArrayList<>();
	ArrayList<ContaCorrente> correntistas = new ArrayList<>();
	
	public CarteiraClientes() {
		
	}
	
	public void criarConta(String nome, String numero_conta, int tipo, double valor) {
		if (tipo == 0) {
			ContaPoupanca nova_poupanca = new ContaPoupanca(nome, numero_conta, valor);
			this.poupadores.add(nova_poupanca);
		} 
		else {
			ContaCorrente nova_conta = new ContaCorrente(nome, numero_conta, valor);
			this.correntistas.add(nova_conta);
		}
	}
	
	public void depositar(String numero_conta, int tipo, double valor) {
		if (tipo == 1) {
			ContaCorrente conta_encontrada = this.encontrar_conta_corrente(numero_conta);
			if(conta_encontrada != null) {
				conta_encontrada.depositar(valor);
			}
			else {
				System.out.println("Conta Corrente não encontrada.");
			}
		} else {
			ContaPoupanca conta_encontrada = this.encontrar_conta_poupanca(numero_conta);
			if (conta_encontrada != null) {
				conta_encontrada.depositar(valor);
			}
			else {
				System.out.println("Conta Poupança não encontrada.");
			}
		}
	}

	public void sacar(String numero_conta, int tipo, double valor) {
		if (tipo == 1) {
			ContaCorrente conta_encontrada = this.encontrar_conta_corrente(numero_conta);
			if (conta_encontrada != null) {
				conta_encontrada.saque(valor);
			}
			else {
				System.out.println("Conta Corrente não encontrada.");
			}
		} else {
			ContaPoupanca conta_encontrada = this.encontrar_conta_poupanca(numero_conta);
			if (conta_encontrada != null) {
				conta_encontrada.resgatar(valor);
			}
			else {
				System.out.println("Conta Poupança não encontrada.");
			}
		}
	}
	
	public ContaCorrente encontrar_conta_corrente(String numero_conta) {

		ContaCorrente conta_encontrada = null;

		for (int x = 0; x < this.correntistas.size(); x++) {
			if (Objects.equals(this.correntistas.get(x).getNumeroConta(), numero_conta)) {
				conta_encontrada = this.correntistas.get(x);
				System.out.println("\n\n===================================");
				System.out.println("Dados Encontrados");
				System.out.println("===================================");
				System.out.println("Nome:\t" + conta_encontrada.getNomeTitular());
				System.out.println("Nº Conta Corrente:\t" + conta_encontrada.getNumeroConta());
				System.out.println("Saldo:\t" + conta_encontrada.getSaldo());
				System.out.println("===================================\n\n");
			}
		}

		return conta_encontrada;

	}

	public ContaPoupanca encontrar_conta_poupanca(String numero_conta) {
		
		ContaPoupanca conta_encontrada = null;

		for(int i = 0; i < this.poupadores.size(); i++) {
			if(Objects.equals(this.poupadores.get(i).getNumeroConta(), numero_conta)) {
				conta_encontrada = this.poupadores.get(i);
				System.out.println("\n\n===================================");
				System.out.println("Dados Encontrados");
				System.out.println("===================================");
				System.out.println("Nome:\t" + conta_encontrada.getNomeTitular());
				System.out.println("Nº Conta Poupança:\t" + conta_encontrada.getNumeroConta());
				System.out.println("Saldo:\t" + conta_encontrada.saldo());
				System.out.println("===================================\n\n");
			}
		}

		return conta_encontrada;
	}
}

public class Bancov3 {

    public static void main (String[] args) throws IOException{

		CarteiraClientes agencia_Araras = new CarteiraClientes();
		Console console = System.console();		
		Scanner input = new Scanner(System.in);
		double movimentacao = 0;
		String numero_conta = "0";
		int opcao = 10;

		do {

			System.out.println("Banco FATEC");	
			System.out.println("============");	
			System.out.println("1.\t Criar uma conta");	
			System.out.println("**********************************");
			System.out.println("2.\t Deposito em conta corrente");	
			System.out.println("3.\t Saque em conta corrente");	
			System.out.println("4.\t Encontrar Conta Corrente");
			System.out.println("**********************************");
			System.out.println("5.\t Deposito em conta poupanca");	
			System.out.println("6.\t Saque em conta  poupanca");	
			System.out.println("7.\t Encontrar conta poupanca");
			System.out.println("**********************************");
			System.out.println("0.\t Encerrar sistema");	
			opcao = input.nextInt();

			if (opcao == 1) {
				System.out.println("Digite o nome do cliente: ");	
				String nome_cliente = console.readLine();
				System.out.println("Digite 1 para Conta Corrente, 0 para Poupança: ");	
				int tipo =  input.nextInt();
				System.out.println("Digite o número da conta: ");	
				numero_conta = console.readLine();
				System.out.println("Digite o valor a se depositar: ");	
				movimentacao = input.nextDouble();
				agencia_Araras.criarConta(nome_cliente, numero_conta, tipo, movimentacao);

				System.out.println("Press Enter to continue...");
				System.in.read();
			}

			if (opcao == 2) {
				System.out.println("Digite o número da conta corrente: ");	
				numero_conta = console.readLine();
				System.out.println("Digite o valor a se depositar: ");	
				movimentacao = input.nextDouble();
				agencia_Araras.depositar(numero_conta, 1, movimentacao);

				System.out.println("Press Enter to continue...");
				System.in.read();
			}

			if (opcao == 3) {
				System.out.println("Digite o número da conta corrente: ");	
				numero_conta = console.readLine();
				System.out.println("Digite o valor que deseja sacar: ");	
				movimentacao = input.nextDouble();
				agencia_Araras.sacar(numero_conta, 1, movimentacao);

				System.out.println("Press Enter to continue...");
				System.in.read();
			}
			
			if (opcao == 4) {
				System.out.println("Digite o número da conta: ");	
				numero_conta = console.readLine();
				if(agencia_Araras.encontrar_conta_corrente(numero_conta) == null) {
					System.out.println("Nenhuma conta poupança encontrada com este número.");
				}

				System.out.println("Press Enter to continue...");
				System.in.read();
			}
			
			if (opcao == 5) {
				System.out.println("Digite o número da conta poupança: ");
				numero_conta = console.readLine();
				System.out.println("Digite o valor que deseja depositar: ");
				movimentacao = input.nextDouble();
				agencia_Araras.depositar(numero_conta, 0, movimentacao);

				System.out.println("Press Enter to continue...");
				System.in.read();
			}

			if (opcao == 6) {
				System.out.println("Digite o número da conta poupança: ");
				numero_conta = console.readLine();
				System.out.println("Digite o valor que deseja sacar: ");
				movimentacao = input.nextDouble();
				agencia_Araras.sacar(numero_conta, 0, movimentacao);

				System.out.println("Press Enter to continue...");
				System.in.read();	
			}

			if (opcao == 7) {
				System.out.println("Digite o número da conta: ");	
				numero_conta = console.readLine();
				if(agencia_Araras.encontrar_conta_poupanca(numero_conta) == null) {
					System.out.println("Nenhuma conta poupança encontrada com este número.");
				}

				System.out.println("Press Enter to continue...");
				System.in.read();	
			}

		} while (opcao != 0);
		
		System.out.println("****************************************");
		System.out.println("\t\t Banco FATEC");
		System.out.println("\t\t Volte Sempre !");
		System.out.println("****************************************");
		
		
    }
}