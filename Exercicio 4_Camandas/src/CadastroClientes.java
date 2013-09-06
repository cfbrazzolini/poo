public class CadastroClientes{

	private RepositorioClientesArray clientes;

	public CadastroClientes(RepositorioClientesArray r) {
		this.clientes = r;
	}

	public boolean cadastrar(Cliente cliente){

		boolean sucess;

		sucess = clientes.inserir(cliente);
		return sucess;
	}

	public Cliente procurar(String cpf){
		return clientes.procurar(cpf);
	}

	public boolean atualizar(Cliente cliente){

		boolean sucess;

		sucess = clientes.atualizar(cliente);
		return sucess;
	}


	public boolean remover(String cpf){

		boolean sucess;
		
		sucess = clientes.remover(cpf);
		return sucess;
	}

}