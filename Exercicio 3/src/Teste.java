class Teste{

	public static void main(String[] args){

		Cliente cli1 = new Cliente("Alpha","0000001");
		Cliente cli2 = new Cliente("Bravo","0000002");


		Conta c1 = new Conta("0000001",cli1);
		Conta c2 = new Conta("0000002",cli2);

		c1.setSaldo(100);
		c2.setSaldo(20);

		System.out.println("O Saldo da conta c1 e : " + c1.getSaldo());
		System.out.println("O Saldo da conta c2 e : " + c2.getSaldo());

		c1.debitar(50);
		c2.creditar(30);

		System.out.println("O Saldo da conta c1 e : " + c1.getSaldo());
		System.out.println("O Saldo da conta c2 e : " + c2.getSaldo());

		c1.transferir(120,c2);

		System.out.println("\n\nO Saldo da conta c1 e : " + c1.getSaldo());
		System.out.println("O cliente da conta c1 e : " + c1.getCliente().getNome() + " \nCPF: " + c1.getCliente().getCpf());


		System.out.println("\n\nO Saldo da conta c2 e : " + c2.getSaldo());
		System.out.println("O cliente da conta c2 e : " + c2.getCliente().getNome() + " \nCPF: " + c2.getCliente().getCpf());
	}
}