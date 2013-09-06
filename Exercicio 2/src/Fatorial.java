class Fatorial{

	public static void main(String[] args){



		if(args.length == 0){
			System.out.println("Argumento de entrada nao encontrado");
			System.exit(-1);
		}

		int i;
		int fatorial = 1;
		int num = Integer.parseInt(args[0]);





		if(num < 0){
			System.out.println("Argumento de entrada deve ser uma inteiro maior que 0");
			System.exit(0);
		}
		

		for(i=num;i>0;i--){
			fatorial = fatorial * i; 

		}

		System.out.println("Fatorial de " + num + " = " + fatorial);


		
	}
}