class WhileTest{

	public static void main(String[] args){

		int i;


		i = 0;

		while(i<10){
			System.out.println("Iteration: "+i);
			i++;
		}

		i = 0;

		do{
			System.out.println("Iteration: "+i);
			i++;
		}while(i<10);
	}
}