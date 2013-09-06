public class RepositorioContasArray {
	private Conta[]  contas;
	private int indice;
	private final static int tamanhoCache = 100;

	public RepositorioContasArray() {
	  indice = 0;
	  contas = new Conta[tamanhoCache];
	}

    public Conta [] getContas() {
        return contas;
	}

    public int getIndice() {
        return indice;
    }
    public boolean inserir(Conta c){

    	if(indice < tamanhoCache){
    		contas[indice] = c;
	    	indice = indice + 1;
	    	InterfaceTextual.mostrarMensagem("Conta cadastrada com sucesso");
	    	return true;
    	}else{
    		InterfaceTextual.mostrarMensagem("Nao ha espaco para novas contas");
    		return false;
    	}
	}

	private int procurarIndice(String num) {
	  int     i = 0;
	  int     ind = -1;
	  boolean achou = false;

	  while ((i < indice) &&!achou) {
	    if ((contas[i].getNumero()).equals(num)) {
		ind = i;
		achou = true;
	    }
	    i = i + 1;
	  }
	  return ind;
	}

	public boolean existe(String num) {
	  boolean resp = false;

	  int i = this.procurarIndice(num);
	  if(i != -1){
		resp = true;
	  }

	  return resp;
	}

	public boolean atualizar(Conta c){
		int i = procurarIndice(c.getNumero());
		
		if (i != -1) {
			contas[i] = c;
			return true;
		}else{
		    InterfaceTextual.mostrarMensagem("Conta nao encontrada");
		    return false;
		}
	}

	public Conta procurar(String num){
	  Conta c = null;
	  if (existe(num)) {
  	    int i = this.procurarIndice(num);
	    c = contas[i];
	  } else {
	    InterfaceTextual.mostrarMensagem("Conta nao encontrada");
	  }

	  return c;
	}

	public boolean remover(String num){

		boolean sucess;


		if (existe(num)) {
	  		int i = this.procurarIndice(num);
		    contas[i] = contas[indice - 1];
		    contas[indice - 1] = null;
		    indice = indice - 1;
		    sucess = true;
		    InterfaceTextual.mostrarMensagem("Conta removida com sucesso");
		}else {
		    InterfaceTextual.mostrarMensagem("Conta nao encontrada");
		    sucess = false;
		}

		return sucess;
	}


	public Conta procurarByCpf(String cpf){

		int     i = 0;
	  	boolean achou = false;
	  	Cliente cli1;

	  	while ((i < indice) && !achou) {
	  		cli1 = contas[i].getCliente();
	    	if ((cli1.getCpf()).equals(cpf)) {
				achou = true;
				return contas[i];
	    	}
	    	i = i + 1;
	  	}

	  	return null;

	}
}
