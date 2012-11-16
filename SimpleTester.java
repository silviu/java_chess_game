import java.util.*;
import java.io.*;
class SimpleTester
{
	public static void main(String[] tests)
	{
		int passed, failed;
		System.out.println("Starting...");
		passed = failed = 0;
		for(String test : tests)
		{
			System.out.println();
			System.out.print(test+".........");
			
			String reference_output = GetFileText("tests" + File.separatorChar + test + "_reference.out");
			
			String  user_output = GetFileText("results" + File.separatorChar + test + "_user.out");
			
			if ( (reference_output.length()>0) && (reference_output.equals(user_output)) ) 
			{
				System.out.print("OK");
				passed++;
			}
			else 
			{	
				System.out.println("\n"+reference_output + "\nversus\n" + user_output+"\n");
				System.out.println("FAILED");
				failed++;
			}
		}
		System.out.println("Passed " + passed + " of " + (passed+failed) + " tests.");
	}
	
	public static String GetFileText(String filename)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filename);
			int x = fis.available();
			byte b[] = new byte[x];
			fis.read(b);
			String text = new String(b);
			text = text.replaceAll(" ","");
			text = text.replaceAll("\r","");
			text = text.replaceAll("\n","");
			return text;
		}
		catch(FileNotFoundException ex)
		{
			System.out.print("[FILENOTFOUND:"+filename+"]");
			return new String();
		}
		catch(IOException ex)
		{
			System.out.print("[IO ERROR]");
			return new String();
		}
	}
}