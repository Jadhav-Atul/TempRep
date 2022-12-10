
public class JavaPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		1 2 3 4
		5 6 7
		8 9
		10	*/
		int k=1, kk=3;
		for(int i=0; i<4;i++)
		{
			
			for(int j=1;j<=4-i;j++)
			{
				System.out.print(k);
				System.out.print("\t");
				k++;
			}
			System.out.println(" ");
		}
		
		System.out.println("**************************************** ");
		//********************
		for(int i=1; i<5;i++)
		{
			
			for(int j=1;j<=i;j++)
			{
				System.out.print(kk);
				System.out.print("\t");
				kk=kk+3;
			}
			System.out.println(" ");
			//kk=1;
		}
		

	}

}
