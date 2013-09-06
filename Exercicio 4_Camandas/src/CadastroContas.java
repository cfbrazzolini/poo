public class CadastroContas {


	private RepositorioContasArray contas;

	public CadastroContas(RepositorioContasArray r) {
		this.contas = r;
	}

	public boolean cadastrar(Conta conta){

		boolean sucess;

		sucess = contas.inserir(conta);
		return sucess;
	}

	public Conta procurar(String numero){
		return contas.procurar(numero);
	}

	public boolean atualizar(Conta conta){

		boolean sucess;

		sucess = contas.atualizar(conta);
		return sucess;
	}


	public boolean remover(String numero){

		boolean sucess;
		
		sucess = contas.remover(numero);
		return sucess;
	}

	public boolean creditar(String numero, double valor){

		Conta conta;
		boolean sucess;

		conta = this.contas.procurar(numero);

		if(conta != null){
			conta.creditar(valor);
			sucess = true;
		}else{
			sucess = false;
		}

		return sucess;

	}

	public boolean debitar(String numero, double valor){

		Conta conta;
		boolean sucess;

		conta = this.contas.procurar(numero);

		if(conta != null){
			conta.debitar(valor);
			sucess = true;
		}else{
			sucess = false;
		}

		return sucess;

	}


	public ListaContas getListaContasByCpf(String cpf){

		int numero_contas,i;
		Conta [] contas; 
		ListaContas lista_contas = new ListaContas();
		Cliente cliente;


		numero_contas = this.contas.getIndice();

		if(numero_contas > 0){

			contas = this.contas.getContas();

			for(i=0;i<numero_contas;i++){

				cliente = contas[i].getCliente();

				if((cliente.getCpf()).equals(cpf)){
					lista_contas.insert(contas[i]);
				}
			}

		}

		return lista_contas;

	}

}