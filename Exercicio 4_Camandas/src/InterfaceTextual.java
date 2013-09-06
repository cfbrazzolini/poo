import java.util.Scanner;
import java.util.Locale;


public class InterfaceTextual {

	private static Scanner sc;
	public static Fachada fachada;

	private static final int OP_CRIAR_CLIENTE         	=  1;
	private static final int OP_CONSULTAR_CLIENTE     	=  2;
	private static final int OP_ATUALIZAR_CLIENTE     	=  3;
	private static final int OP_REMOVER_CLIENTE       	=  4;
	private static final int OP_CRIAR_CONTA           	=  5;
	private static final int OP_CONSULTAR_CONTA       	=  6;
	private static final int OP_ATUALIZAR_CONTA       	=  7;
	private static final int OP_REMOVER_CONTA   		=  8;
	private static final int OP_CREDITAR_CONTA 			=  9;
	private static final int OP_DEBITAR_CONTA 			= 10;
	private static final int OP_TRANSFERIR_CONTAS 		= 11;
	private static final int OP_EXIBIR_CONTAS_CLIENTE 	= 12;
	private static final int OP_EXIBIR_CONTAS 			= 13;
	private static final int OP_EXIBIR_CLIENTES 		= 14;
	private static final int OP_SAIR 					= 15;
	private static final int OP_INICIAL 				= -1;


	

	public static void init(){

		sc = new Scanner(System.in);
		sc.useLocale(Locale.US);

		fachada = Fachada.obterInstancia();

	}

	public static void mostrarMensagem(String msg){
		System.out.println(msg);
	}

	public static void showStatusOperacao(boolean sucess){

		if(sucess){
			System.out.println("Operacao ralizada com sucesso");
		}else{
			System.out.println("Erro na operacao");
		}
	}

	public static void criarCliente(){

		String nome,cpf;
		Cliente cli1;
		boolean sucess;

		sc.nextLine();

		System.out.print("Informe o nome do cliente: ");
		nome = sc.nextLine();

		System.out.print("Informe o CPF no cliente: ");
		cpf = sc.next();

		cli1 = new Cliente(nome,cpf);

		sucess = fachada.cadastrarCliente(cli1);

		showStatusOperacao(sucess);
	}

	public static void consultarCliente(){

		String cpf;
		Cliente cliente;

		sc.nextLine();

		System.out.print("Informe o CPF no cliente: ");
		cpf = sc.next();

		cliente = fachada.getCliente(cpf);
		if(cliente != null){
			System.out.println("Cliente: " + cliente.getNome());
			System.out.println("CPF: " + cliente.getCpf());
		}else{
			showStatusOperacao(false);
		}
	}

	public static void atualizarCliente(){

		String cpf,nome;
		Cliente cliente;
		boolean sucess;

		sc.nextLine();

		System.out.print("Informe o CPF no cliente: ");
		cpf = sc.next();

		sc.nextLine();
		
		System.out.print("Informe o novo nome do cliente: ");
		nome = sc.nextLine();

		cliente = new Cliente(nome,cpf);
		
		sucess = fachada.atualizarCliente(cliente);

		showStatusOperacao(sucess);
	
	}


	public static void removerCliente(){

		String cpf;
		Cliente cliente;
		boolean sucess;

		sc.nextLine();

		System.out.print("Informe o CPF no cliente: ");
		cpf = sc.next();

		sucess = fachada.removerCliente(cpf);
		
		showStatusOperacao(sucess);

	}

	public static void criarConta(){

		String cpf, numero;
		Cliente cliente;
		Conta conta;
		boolean sucess;

		sc.nextLine();

		System.out.print("Informe o CPF no cliente: ");
		cpf = sc.next();

		sc.nextLine();

		System.out.print("Informe o numero da conta: ");
		numero = sc.next();

		cliente = new Cliente(null,cpf);

		conta = new Conta(numero,cliente);
		sucess = fachada.criarConta(conta);
		
		showStatusOperacao(sucess);
	}

	public static void consultarConta(){

		String numero;
		Cliente cliente;
		Conta conta;

		sc.nextLine();

		System.out.print("Informe o numero da conta: ");
		numero = sc.next();

		conta = fachada.consultarConta(numero);
		if(conta != null){

			cliente = conta.getCliente();

			System.out.println("Numero: " + conta.getNumero());
			System.out.println("Saldo: " + conta.getSaldo());
			System.out.println("Nome do titular: " + cliente.getNome());
			System.out.println("CPF do titular: " + cliente.getCpf());
		}else{
			showStatusOperacao(false);
		}
	}

	/*public static void atualizarConta(){

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
	}*/


	public static void removerConta(){

		String numero;
		boolean sucess;


		sc.nextLine();

		System.out.print("Informe o numero da conta: ");
		numero = sc.next();

		sucess = fachada.removerConta(numero);

		showStatusOperacao(sucess);
		
	}

	public static void creditar(){

		String numero;
		double valor;
		boolean sucess;


		sc.nextLine();

		System.out.print("Informe o numero da conta: ");
		numero = sc.next();

		System.out.print("Informe o valor: ");
		valor = sc.nextDouble();

		sucess = fachada.creditar(numero,valor);

		showStatusOperacao(sucess);

	}

	public static void debitar(){

		String numero;
		double valor;
		boolean sucess;


		sc.nextLine();

		System.out.print("Informe o numero da conta: ");
		numero = sc.next();

		System.out.print("Informe o valor: ");
		valor = sc.nextDouble();

		sucess = fachada.debitar(numero,valor);

		showStatusOperacao(sucess);
	}

	/*public static void transferir(){

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
*/



	public static void showMenu(){

		System.out.println("*** Aplicacao Bancaria ***\n");
		System.out.println("Operacoes disponiveis:\n");
		System.out.println(OP_CRIAR_CLIENTE 		+ "  - Criar cliente");
		System.out.println(OP_CONSULTAR_CLIENTE 	+ "  - Consultar cliente");
		System.out.println(OP_ATUALIZAR_CLIENTE 	+ "  - Atualizar cliente");
		System.out.println(OP_REMOVER_CLIENTE 		+ "  - Remover cliente");
		System.out.println(OP_CRIAR_CONTA 			+ "  - Criar conta");
		System.out.println(OP_CONSULTAR_CONTA 		+ "  - Consultar conta");
		System.out.println(OP_ATUALIZAR_CONTA 		+ "  - Atualizar conta");
		System.out.println(OP_REMOVER_CONTA 		+ "  - Remover conta");
		System.out.println(OP_CREDITAR_CONTA 		+ "  - Creditar conta");
		System.out.println(OP_DEBITAR_CONTA 		+ " - Debitar conta");
		System.out.println(OP_TRANSFERIR_CONTAS 	+ " - Transferir entre contas");
		System.out.println(OP_EXIBIR_CONTAS_CLIENTE + " - Exibir os dados da conta de um determinado cliente");
		System.out.println(OP_EXIBIR_CONTAS 		+ " - Exibir os dados de todas as contas");
		System.out.println(OP_EXIBIR_CLIENTES 		+ " - Exibir os dados de todos os clientes");
		System.out.println(OP_SAIR 					+ " - Sair da aplicacao");
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
			/*case 7:
				atualizarConta();
				break;*/
			case 8:
				removerConta();
				break;
			case 9:
				creditar();
				break;
			case 10:
				debitar();
				break;
			/*case 11:
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
				break;*/
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

		op = OP_INICIAL;

		do{
			showMenu();
			op = getOp();
			trataOp(op);
		}while(op != 15);
	}
}