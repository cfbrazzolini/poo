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

	public void inserir(Cliente c){
		if(indice < tamanhoCache){
			clientes[indice] = c;
			indice = indice + 1;
		}else{
			System.out.println("Nao ha espaco para novos clientes");
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

		if(this.procurarIndice(cpf) != -1){
			return true;
		}else{
			return false;
		}

	}

	public Cliente procurar(String cpf){

		Cliente c = null;
		int i;

		if(this.existe(cpf)){
			i = this.procurarIndice(cpf);
			c = clientes[i];
			return c;
		}else{
			System.out.println("Cliente nao cadastrado");
			return null;
		}

	}

	public void atualizar(Cliente c){

		int i;

		if(this.existe(c.getCpf())){
			i = this.procurarIndice(c.getCpf());
			clientes[i] = c;

		}else{
			System.out.println("Cliente nao cadastrado");
		}
	}

	public void remover(String cpf){

		int i;

		if(this.existe(cpf)){
			i = this.procurarIndice(cpf);
			clientes[i] = clientes[indice-1];
			clientes[indice-1] = null;
			indice = indice - 1;
		}else{
			System.out.println("Cliente nao cadastrado");
		}

	}


}