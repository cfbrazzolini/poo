public class Fachada{


	private static Fachada instancia;
	private CadastroContas contas;
	private CadastroClientes clientes;

	public static Fachada obterInstancia() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}

	private Fachada() {
		init();
	}

	public void init(){
		
		RepositorioContasArray rep = new RepositorioContasArray();
		RepositorioClientesArray repClientes = new RepositorioClientesArray();

		contas = new CadastroContas(rep);
		clientes = new CadastroClientes(repClientes);
	}



	public boolean cadastrarCliente(Cliente cliente){

		boolean sucess;

		sucess = this.clientes.cadastrar(cliente);

		return sucess;

	}

	public Cliente getCliente(String cpf){
		return clientes.procurar(cpf);		
	}

	public boolean atualizarCliente(Cliente cliente){

		boolean sucess = false;
		ListaContas lista_contas;
		Conta conta_temp;
		Cliente cliente_temp;



		cliente_temp = clientes.procurar(cliente.getCpf());

		if(cliente_temp != null){

			lista_contas = this.contas.getListaContasByCpf(cliente.getCpf());

			while(lista_contas.hasNext()){
				conta_temp = lista_contas.next();
				cliente_temp = conta_temp.getCliente();
				cliente_temp.setNome(cliente.getNome());
				
			}

			sucess = clientes.atualizar(cliente);
		}


		
		return sucess;
	}


	public boolean removerCliente(String cpf){

		ListaContas lista_contas;
		Conta conta_temp;
		Cliente cliente;
		boolean sucess;
		int numero_contas,i;


		cliente = this.clientes.procurar(cpf);

		if(cliente != null){
			lista_contas = this.contas.getListaContasByCpf(cpf);
			while(lista_contas.hasNext()){
				conta_temp = lista_contas.next();
				this.contas.remover(conta_temp.getNumero());
			}
		}
		sucess = this.clientes.remover(cpf);
		return sucess;
	}

	public boolean criarConta(Conta conta){

		Cliente cliente_lido,cliente;
		boolean sucess;

		cliente_lido = conta.getCliente();

		if(cliente_lido != null){
			cliente = clientes.procurar(cliente_lido.getCpf());

			if(cliente != null){
				cliente_lido.setNome(cliente.getNome());
				sucess = contas.cadastrar(conta);
			}else{
				sucess = false;
			}
		}else{
			sucess = false;
		}
		
		return sucess;
	}

	public Conta consultarConta(String numero){

		return this.contas.procurar(numero);
	}

	/*public void atualizarConta(){

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
	*/

	public boolean removerConta(String numero){
		return	this.contas.remover(numero);
	}

	public boolean creditar(String numero, double valor){
		return contas.creditar(numero,valor);
	}

	public boolean debitar(String numero, double valor){
		return contas.debitar(numero,valor);
	}

	/*public void transferir(){

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


	public void consultarContaByCpf(){

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

	public void listarContas(){

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


	public void listarClientes(){

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


}