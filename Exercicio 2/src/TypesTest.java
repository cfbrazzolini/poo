class TypesTest {
	
	public static void main(String[] args){

		/*a)ok*///int a = 2;long b = a;
		/*b)N*///long c = 4;int d = c;
		/*c)N*///boolean bol = false;int g = bol;
		/*d)N*///int a = 10L;
		/*e)ok*///int a = (int)(10L);
		/*f)N*///int a = 48;char c = a;
		/*g)ok*///double d = 29.0f;
		/*h)N*///float f = 21.2;
		/*i)ok*///double d = 2.0;int a = (int)d;
		/*j)C*///int h = 2000;byte b = (byte)h;

		System.out.println("Valor: " + c);


	}
}