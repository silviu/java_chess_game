import java.util.*;
import java.io.*;
class MainClass
{
    public static String prevColor;

    // Parses and Prints the output for the Gnu output model
    public static void gnuParser(Sah player, BufferedReader in, String path)
	    throws Exception
    {
	    // Find the filename without the extenssion
	    String fileName = "";
	    StringTokenizer pathFind = new StringTokenizer(path, "/");
	    while (pathFind.hasMoreTokens())
	    {
		    fileName = pathFind.nextToken();
	    }

    	    StringTokenizer file = new StringTokenizer(fileName, ".");
	    fileName = file.nextToken();
	    System.out.println(fileName);
	    //write the output to a file with the found filename + speciffic extenssion
    	    BufferedWriter out = new BufferedWriter(new FileWriter("results/" + fileName + "_user.out"));

       	    String color = null;
	    String poz = null;
	    String mov = null;
	    String str = null;
	    while ((str = in.readLine()) != null) 
	    {
		    StringTokenizer st = new StringTokenizer(str);
		    if (st.hasMoreTokens())
			    color = st.nextToken();
		    if (st.hasMoreTokens())
			    poz = st.nextToken();
		    if (st.hasMoreTokens())
			    mov = st.nextToken();
		    if (color.equals("S"))
		    {
			    player.printTableGnu(out);
			    out.write("\n");
			    continue;
		    }

	    	    if (!(prevColor.equals(color)))
    		    {
			    if ((poz != null) && (mov != null)) 
			    {
				    if (player.muta(color, poz, mov, out))
					    prevColor = color;
				    else
					    out.write("NV\n");
			    }

		    }
		    else
			    out.write("NV\n");

	    } 
	    out.close();
    }
    // Parses and Prints the output for the O output model
    public static void oParser(Sah player, BufferedReader in, String path,String str)
	    throws Exception
    {
	    // Find the filename without the extenssion
	    String fileName = "";
	    StringTokenizer pathFind = new StringTokenizer(path, "/");
	    while (pathFind.hasMoreTokens())
	    {
		    fileName = pathFind.nextToken();
	    }

    	    StringTokenizer file = new StringTokenizer(fileName, ".");
	    fileName = file.nextToken();
	    System.out.println(fileName);

	    //write the output to a file with the found filename + speciffic extenssion
    	    BufferedWriter out = new BufferedWriter(new FileWriter("results/" + fileName + "_user.out"));

       	    String color = null;
	    String poz = null;
	    String mov = null;
	    do
	    {
		    StringTokenizer st = new StringTokenizer(str);
		    if (st.hasMoreTokens())
			    color = st.nextToken();
		    if (st.hasMoreTokens())
			    poz = st.nextToken();
		    if (st.hasMoreTokens())
			    mov = st.nextToken();
		    if (color.equals("S"))
		    {
			    player.printTableO(out);
			    out.write("\n");
			    continue;
		    }

	    	    if (!(prevColor.equals(color)))
    		    {
			    if ((poz != null) && (mov != null)) 
			    {
				    if (player.muta(color, poz, mov, out))
					    prevColor = color;
				    else
					    out.write("NV\n");
			    }

		    }
		    else
			    out.write("NV\n");

	    } while ((str = in.readLine()) != null); 
	    out.close();
    }
    public static void main (String[] argv)
    {
	    try
	    {
		    for (int i = 0 ; i < argv.length; i++)
	    	    {
			    Sah player = new Sah();
			    BufferedReader in = new BufferedReader(new FileReader("tests/" + argv[i] + ".in"));
			    String str;
			    prevColor = "N";
			    if ((str = in.readLine()) != null) 
			    {	
				    if (str.equals("[gnuchess]"))
					    gnuParser(player, in, argv[i]);
				    else
					    oParser(player, in, argv[i], str);
		    }
		}
	    }
	    catch (Exception e)
	    {
		e.printStackTrace(System.err);
	    }
	}
}//~class endtag
