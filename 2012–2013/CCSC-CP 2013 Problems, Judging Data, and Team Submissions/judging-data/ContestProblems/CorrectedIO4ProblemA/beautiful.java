import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class beautiful {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(new File("beautiful.in"));
		int num=scan.nextInt();
		for (int n=0;n<num;n++)
		{
		
			boolean[]a=new boolean[408];
			for (int i=0;i<a.length;i++)
				a[i]=true;
			String input=scan.next();
			String answer="";
			for(int i=0;i<input.length();i++)
			{
				//System.out.println("Checking:"+input.charAt(i));
				if (a[input.charAt(i)])
				{
					a[input.charAt(i)]=false;
					answer+=input.charAt(i);
				}
				else
				{
					
						//System.out.println(""+answer+"@@@@@");
						if(answer.length()>answer.indexOf(input.charAt(i))+1)
					if (answer.charAt(answer.indexOf(input.charAt(i))+1)>input.charAt(i))
					{
						//System.out.println("%^&*");
						int remove=answer.indexOf(input.charAt(i));
						answer=answer.substring(0,remove)+answer.substring(remove+1,answer.length());
						answer+=input.charAt(i);
					}
				}
			}
			System.out.println(answer);
		}
	}

}
