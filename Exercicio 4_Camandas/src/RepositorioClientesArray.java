public class RepositorioClientesArray{

	private int indice;
	private Cliente[] clientes;
	public final static int tamanhoCache = 100;



	public RepositorioClientesArray(){
		indice = 0;
		clientes = new Cliente[tamanhoCache];
	} 

	public Cliente [] getClientes(){
		return clientes;
	}

	public int getIndice(){
		return indice;
	}

	public void setIndice(int indice){
		this.indice = indice;
	}

	public boolean inserir(Cliente c){
		if(indice < tamanhoCache){
			clientes[indice] = c;
			indice = indice + 1;
			return true;
		}else{
			InterfaceTextual.mostrarMensagem("Nao ha espaco para novos clientes");
			return false;
		}
	}

	public int procurarIndice(String cpf){
		int pos = -1;
		int i = 0;
		boolean achou = false;

		while((!achou)&&(i<indice)){
			if((clientes[i].getCpf()).equals(cpf)){
				pos = i;
				achou = true;
			}
			i++;
		}

		return pos;

	}

	public boolean existe(String cpf){

		boolean sucess;

		if(this.procurarIndice(cpf) != -1){
			sucess = true;
		}else{
			sucess =  false;
		}

		return sucess;
	}

	public Cliente procurar(String cpf){

		Cliente c = null;
		int i;

		if(this.existe(cpf)){
			i = this.procurarIndice(cpf);
			c = clientes[i];
			return c;
		}else{
			InterfaceTextual.mostrarMensagem("Cliente nao cadastrado");
			return null;
		}

	}

	public boolean atualizar(Cliente c){

		int i;
		boolean sucess;

		if(this.existe(c.getCpf())){
			i = this.procurarIndice(c.getCpf());
			clientes[i] = c;
			sucess = true;
		}else{
			InterfaceTextual.mostrarMensagem("Cliente nao cadastrado");
			sucess =  false;
		}

		return sucess;
	}

	public boolean remover(String cpf){

		int i;
		boolean sucess;

		if(this.existe(cpf)){
			i = this.procurarIndice(cpf);
			clientes[i] = clientes[indice-1];
			clientes[indice-1] = null;
			indice = indice - 1;
			sucess = true;
		}else{
			InterfaceTextual.mostrarMensagem("Cliente nao cadastrado");
			sucess = false;
		}

		return sucess;

	}


}