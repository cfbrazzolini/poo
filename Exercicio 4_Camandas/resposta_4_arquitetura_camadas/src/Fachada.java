public class Fachada {

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
		initCadastros();
	}

	private void initCadastros() {
		RepositorioContasArray rep = new RepositorioContasArray();
		contas = new CadastroContas(rep);
		RepositorioClientesArray repClientes = new RepositorioClientesArray();
		clientes = new CadastroClientes(repClientes);
	}

	// metodos para manipular clientes
	public void atualizar(Cliente c) {
		clientes.atualizar(c);
	}

	public Cliente procurarCliente(String cpf) {
		return clientes.procurar(cpf);
	}

	public void cadastrar(Cliente c) {
		clientes.cadastrar(c);
	}

	public void descadastrarCliente(String cpf) {
		clientes.descadastrar(cpf);
	}

	// metodos para manipular contas
	public int atualizar(Conta c) {
		int r = -1;
		Cliente cliente_lido, cliente_existente = null;
		cliente_lido = c.getCliente();
		if (cliente_lido != null) {
			cliente_existente = clientes.procurar(cliente_lido.getCpf());
			if (cliente_existente != null) {
				// o comando abaixo eh importante para nao precisarmos pedir o nome do cliente
				// pois soh lemos o cpf do cliente passado dentro da conta c
				cliente_lido.setNome(cliente_existente.getNome());
				r = contas.atualizar(c);
			} 
		} 
		return r;

	}

	public Conta procurarConta(String n) {
		return contas.procurar(n);
	}

	public int cadastrar(Conta c) {
		int r = -1;
		Cliente cliente_lido, cliente_existente = null;
		cliente_lido = c.getCliente();
		if (cliente_lido != null) {
			cliente_existente = clientes.procurar(cliente_lido.getCpf());
			if (cliente_existente != null) {
				// o comando abaixo eh importante para nao precisarmos pedir o nome do cliente
				// pois soh lemos o cpf do cliente passado dentro da conta c
				cliente_lido.setNome(cliente_existente.getNome());
				r = contas.cadastrar(c);
			} 
		} 
		return r;
	}

	public int descadastrarConta(String n) {
		return contas.descadastrar(n);
	}

	public int creditar(String n, double v) {
		return contas.creditar(n, v);
	}

	public int debitar(String n, double v) {
		return contas.debitar(n, v);
	}

	public int transferir(String origem, String destino, double val) {
		return contas.transferir(origem, destino, val);
	}

	public ListaContas listaContasCliente(String cpf) {
		ListaContas lc = null;
		Cliente cliente = clientes.procurar(cpf);
		if (cliente != null) {
			lc = contas.listaContasCliente(cpf);
		} 
		return lc;
	}

	public ListaContas listaContas() {

		return contas.listaContas();
		
	}

	public ListaClientes listaClientes() {
		// 
		return clientes.listaClientes();
	}

}
