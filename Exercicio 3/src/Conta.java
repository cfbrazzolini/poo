public class Conta{


	private String numero;
	private double saldo;
	private Cliente cliente;


	public Conta(String numero, double saldo, Cliente cliente){

		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public Conta(String numero, Cliente cliente){

		this(numero,0.0,cliente);

	}

	public void setNumero(String numero){
		this.numero = numero;
	}

	public void setSaldo(double saldo){
		this.saldo = saldo;
	}

	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}


	public String getNumero(){
		return numero;
	}

	public double getSaldo(){
		return saldo;
	}

	public Cliente getCliente(){
		return cliente;
	}

	public void creditar(double valor){
		this.saldo = this.saldo + valor;
	}

	public void debitar(double valor){
		
		if(this.saldo<valor){
			System.out.println("\nSaldo insuficiente.");
		}else{
			this.saldo = this.saldo - valor;
			System.out.println("Operacao realizado com sucesso");
		}
	}

	public void transferir(double valor,Conta conta){

		if(this.saldo < valor){
			System.out.println("\nSaldo insuficiente para transferencia");
		}else{
			this.debitar(valor);
			conta.creditar(valor);
		}


	}

}