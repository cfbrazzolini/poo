

import java.util.Scanner;
import java.util.Locale;



public class Banco{

	private static RepositorioClientesArray clientesArray;
	private static RepositorioContasArray contasArray;
	private static Scanner sc;

	public static void init(){

		sc = new Scanner(System.in);
		sc.useLocale(Locale.US);

		clientesArray = new RepositorioClientesArray();
		contasArray = new RepositorioContasArray();

	}



	public static void criarCliente(){

		String nome,cpf;
		Cliente cli1;

		sc.nextLine();

		System.out.print("Informe o nome do cliente: ");
		nome = sc.nextLine();

		System.out.print("Informe o CPF no cliente: ");
		cpf = sc.next();

		cli1 = new Cliente(nome,cpf);

		clientesArray.inserir(cli1);
		System.out.println("Cliente inserido com sucesso");
	}

	public static void consultarCliente(){

		String cpf;
		Cliente cli1;

		sc.nextLine();

		System.out.print("Informe o CPF no cliente: ");
		cpf = sc.next();

		cli1 = clientesArray.procurar(cpf);
		if(cli1 != null){
			System.out.println("Cliente: " + cli1.getNome());
			System.out.println("CPF: " + cli1.getCpf());
		}
	}

	public static void atualizarCliente(){

		String cpf,nome;
		Cliente cli1;

		sc.nextLine();

		System.out.print("Informe o CPF no cliente: ");
		cpf = sc.next();

		cli1 = clientesArray.procurar(cpf);
		if(cli1 != null){
			sc.nextLine();
			System.out.print("Informe o novo nome do cliente: ");
			nome = sc.nextLine();

			cli1.setNome(nome);
			clientesArray.atualizar(cli1);
		}
	}


	public static void removerCliente(){

		String cpf;
		Cliente cli1;
		Conta c1;

		sc.nextLine();

		System.out.print("Informe o CPF no cliente: ");
		cpf = sc.next();

		c1 = contasArray.procurarByCpf(cpf);
		if(c1 != null){
			contasArray.remover(c1.getNumero());
		}
		clientesArray.remover(cpf);
		System.out.println("Cliente removido com sucesso");
	}

	public static void criarConta(){

		String cpf, numero;
		Cliente cli1;
		Conta c1;

		sc.nextLine();

		System.out.print("Informe o CPF no cliente: ");
		cpf = sc.next();

		cli1 = clientesArray.procurar(cpf);
		if(cli1 != null){

			sc.nextLine();

			System.out.print("Informe o numero da conta: ");
			numero = sc.next();

			c1 = new Conta(numero,cli1);
			contasArray.inserir(c1);
			System.out.println("Conta criada com sucesso");
		}
	}

	public static void consultarConta(){

		String numero;
		Cliente cli1;
		Conta c1;

		sc.nextLine();

		System.out.print("Informe o numero da conta: ");
		numero = sc.next();

		c1 = contasArray.procurar(numero);
		if(c1 != null){

			cli1 = c1.getCliente();

			System.out.println("Numero: " + c1.getNumero());
			System.out.println("Saldo: " + c1.getSaldo());
			System.out.println("Nome do titular: " + cli1.getNome());
			System.out.println("CPF do titular: " + cli1.getCpf());
		}
	}

	public static void atualizarConta(){

		String numero;
		double saldo;
		Conta c1;


		sc.nextLine();

		System.out.print("Informe o numero da conta: ");
		numero = sc.next();

		c1 = contasArray.procurar(numero);

		if(c1 != null){

			sc.nextLine();
			System.out.print("Informe o novo saldo da conta: ");
			saldo = sc.nextDouble();
			c1.setSaldo(saldo);

		}
	}


	public static void removerConta(){

		String numero;


		sc.nextLine();

		System.out.print("Informe o numero da conta: ");
		numero = sc.next();

		contasArray.remover(numero);

		System.out.println("Conta removida com sucesso");
	}

	public static void creditar(){

		String numero;
		double valor;
		Conta c1;


		sc.nextLine();

		System.out.print("Informe o numero da conta: ");
		numero = sc.next();

		c1 = contasArray.procurar(numero);
		if(c1 != null){

			System.out.print("Informe o valor: ");
			valor = sc.nextDouble();

			c1.creditar(valor);
		}
	}

	public static void debitar(){

		String numero;
		double valor;
		Conta c1;


		sc.nextLine();

		System.out.print("Informe o numero da conta: ");
		numero = sc.next();

		c1 = contasArray.procurar(numero);
		if(c1 != null){

			System.out.print("Informe o valor: ");
			valor = sc.nextDouble();

			c1.debitar(valor);
		}
	}

	public static void transferir(){

		String numero_origem,numero_destino;
		double valor;
		Conta conta_origem,conta_destino;


		sc.nextLine();

		System.out.print("Informe o numero da conta de origem: ");
		numero_origem = sc.next();

		if(contasArray.existe(numero_origem)){

			sc.nextLine();
			System.out.print("Informe o numero da conta de destino: ");
			numero_destino = sc.next();

			if(contasArray.existe(numero_destino)){

				sc.nextLine();
				System.out.print("Informe o valor a ser trasferido: ");
				valor = sc.nextDouble();


				conta_origem = contasArray.procurar(numero_origem);
				conta_destino = contasArray.procurar(numero_destino);

				conta_origem.debitar(valor);
				conta_destino.creditar(valor);
			}
		}
	}


	public static void consultarContaByCpf(){

		String cpf;
		Cliente cli1;
		Conta c1;

		sc.nextLine();

		System.out.print("Informe o cpf do cliente: ");
		cpf = sc.next();

		c1 = contasArray.procurarByCpf(cpf);
		if(c1 != null){

			cli1 = c1.getCliente();

			System.out.println("Numero: " + c1.getNumero());
			System.out.println("Saldo: " + c1.getSaldo());
			System.out.println("Nome do titular: " + cli1.getNome());
			System.out.println("CPF do titular: " + cli1.getCpf());
		}
	}

	public static void listarContas(){

		Conta[] contas;
		int indice,i;

		contas = contasArray.getContas();
		indice = contasArray.getIndice();

		for(i=0;i<indice;i++){

			System.out.println("\n\nNumero: " + contas[i].getNumero());
			System.out.println("Saldo: " + contas[i].getSaldo());
		}

		System.out.println("\n\n");
	}


	public static void listarClientes(){

		Cliente[] clientes;
		int indice,i;

		clientes = clientesArray.getClientes();
		indice = clientesArray.getIndice();

		for(i=0;i<indice;i++){

			System.out.println("\n\nNumero: " + clientes[i].getNome());
			System.out.println("Saldo: " + clientes[i].getCpf());
		}

		System.out.println("\n\n");
	}







	public static void showMenu(){

		System.out.println("*** Aplicacao Bancaria ***\n");
		System.out.println("Operacoes disponiveis:\n");
		System.out.println("1  - Criar cliente");
		System.out.println("2  - Consultar cliente");
		System.out.println("3  - Atualizar cliente");
		System.out.println("4  - Remover cliente");
		System.out.println("5  - Criar conta");
		System.out.println("6  - Consultar conta");
		System.out.println("7  - Atualizar conta");
		System.out.println("8  - Remover conta");
		System.out.println("9  - Creditar conta");
		System.out.println("10 - Debitar conta");
		System.out.println("11 - Transferir entre contas");
		System.out.println("12 - Exibir os dados da conta de um determinado cliente");
		System.out.println("13 - Exibir os dados de todas as contas");
		System.out.println("14 - Exibir os dados de todos os clientes");
		System.out.println("15 - Sair da aplicacao");
		System.out.print("\nFavor escolher uma opcao:");
	}

	public static int getOp(){
		int op = sc.nextInt();
		return op;
	}

	public static void trataOp(int op){

		switch(op){

				case 1:
					criarCliente();
					break;
				case 2:
					consultarCliente();
					break;
				case 3:
					atualizarCliente();
					break;
				case 4:
					removerCliente();
					break;
				case 5:
					criarConta();
					break;
				case 6:
					consultarConta();
					break;
				case 7:
					atualizarConta();
					break;
				case 8:
					removerConta();
					break;
				case 9:
					creditar();
					break;
				case 10:
					debitar();
					break;
				case 11:
					transferir();
					break;
				case 12:
					consultarContaByCpf();
					break;
				case 13:
					listarContas();
					break;
				case 14:
					listarClientes();
					break;
				case 15:
					System.out.println("Finalizando aplicacao");
					break;
				default:
					System.out.println("Opcao invalida");
					break;
			}
		
	}

	public static void main(String[] args){

		int op;
		
		init();

		do{
			showMenu();
			op = getOp();
			trataOp(op);
		}while(op != 15);
	}
	
}