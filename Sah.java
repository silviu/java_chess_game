import java.util.*;
import java.io.*;

public class Sah
{
	
	Piesa[][] tabla = new Piesa[8][8];

	public Sah()
	{	
		tabla = createTable();
	}

	public Piesa mkPiesa(char c, int color)
	{
		switch(java.lang.Character.toLowerCase(c))
		{
			case 'p':
				return new Pion(color);
			case 'r':
				return new Tura(color);
			case 'n':
				return new Cal(color);
			case 'b':
				return new Nebun(color);
			case 'q':
				return new Regina(color);
			case 'k':
				return new Rege(color);
		}
		assert false : "Unexpected code " + c +
							" for a chess figure";
		return null;
	}

	public Piesa[][] createTable()
	{
		String firstRow = "rnbqkbnr";
		String lastRow = firstRow.toUpperCase();
		for (int i = 0; i < 8; i++)
		{
			tabla[0][i] = mkPiesa(firstRow.charAt(i), Piesa.WHITE);
			tabla[1][i] = mkPiesa('p', Piesa.WHITE);
			tabla[6][i] = mkPiesa('P', Piesa.BLACK);
			tabla[7][i] = mkPiesa(lastRow.charAt(i), Piesa.BLACK);
		}
		return tabla;
	}//~createTable endtag



	public boolean muta(String color, String p_act, String p_mov, BufferedWriter out) throws Exception
	{
		Point poz = new Point(p_act);
		Point mov = new Point(p_mov);
		Piesa curr = tabla[poz.x][poz.y];
		if ((poz.x > 7) || (poz.x < 0) ||
		   (poz.y > 7) || (poz.y < 0) ||
		   (mov.x > 7) || (mov.x < 0) ||
		   (mov.y > 7) || (mov.y < 0))
		{
			out.write("ERR");
			return false;
		}
		if (curr == null)
			return false;
		if (!curr.isLegal(tabla, poz, mov))
			return false;
		if ( (curr.isWhite() && !color.equals("A")) ||
		     (curr.isBlack() && !color.equals("N")) )
			return false;
		
		//Thread.sleep(500);
		tabla[mov.x][mov.y] = tabla[poz.x][poz.y];
		tabla[poz.x][poz.y] = null;
		return true;
	}
	
	

	public void printTableGnu(BufferedWriter out)
		throws Exception
	{
		out.write("   ");
		for(int i = 0; i < 8; i++)
			out.write(" " + (char)(i+97));
		out.write("\n");
		for(int i = 7; i >=0 ; i--)
		{
		out.write((i+1)+ "  ");
		for(int j = 0; j < 8; j++)
			if (tabla[i][j] == null)
            	out.write(" _");
			else
				out.write(" " + tabla[i][j].toGnuString());
		out.write("   " + (i+1));
		out.write("\n");
		}
		out.write("\n");
		out.write("   ");
		for(int i = 0; i < 8; i++)
			out.write(" " + (char)(i+97));
		out.write("\n");
		
	}//~printTable endtag
	public void printTableO(BufferedWriter out)
		throws Exception
	{
		for(int i = 7; i >= 0; i--)
		{
			for (int j = 0; j < 8; j++)
			{
				if (tabla[i][j] == null)
					out.write("O");
				else
					if (tabla[i][j].isWhite())
						out.write((tabla[i][j].toOString().toUpperCase()));
					else
						out.write("O");
			}
			out.write("\n");
		}
		out.write("\n");
		for(int i = 7; i >= 0; i--)
		{
			for (int j = 0; j < 8; j++)
			{
				if (tabla[i][j] == null)
					out.write("O");
				else
					if (tabla[i][j].isBlack())
						out.write(tabla[i][j].toOString());
					else
						out.write("O");
			}
		out.write("\n");
		}
	}
		public void printTable()
	{
		try
		{
		Thread.sleep(2000);
		}
		catch (Exception e)
		{}
		String c = "\033[60C";
		System.out.print("\033[2J");
		System.out.print("\033[1;1f");
		System.out.print(c);
		for(int i = 0; i < 8; i++)
			System.out.print("   " + (char)(i+97));
		//System.out.print("\033[45m BLACK");
		System.out.println("\n  "+c+" _______________________________");
		for(int i = 7; i >=0 ; i--)
		{
		System.out.print(c + (i+1) + " " + "|");
		for(int j = 0; j < 8; j++)
			if (tabla[i][j] == null)
            	System.out.print("_" + "__|");
			else
				System.out.print("_" + tabla[i][j].toGnuString() + "_|");
		System.out.println();
		}
		System.out.println("\n");
		
	}//~printTable endtag

}//~class Sah endTag
