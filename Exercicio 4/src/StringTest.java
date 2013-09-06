class StringTest{

	public static void main(String[] args){

		String s1,s2;
		String s3 = "Charlie";
		String s4 = "Delta";

		s1 = new String("Alpha");
		s2 = new String("Alpha");

		System.out.println("A soma dos tamanhos e: " + (s1.length()+s2.length()));

		if(s1.equals(s2)){
			System.out.println(s1+" = "+s2);
		}

		if(s1 == s2){
			System.out.println("s1 = s2");
		}else{
			System.out.println("s1 != s2");
		}

		System.out.println("");

		if(s3.equals(s4)){
			System.out.println(s3 + " == " + s4);
		}else{
			System.out.println(s3 + " != " + s4);
		}

		if(s3 == s4){
			System.out.println("s3 == s4");
		}else{
			System.out.println("s3 != s4");
		}


	}
}