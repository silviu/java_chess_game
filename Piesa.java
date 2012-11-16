import java.util.*;
import java.io.*;

public abstract class Piesa
{
	public static final int WHITE = 1;
	public static final int BLACK = 2;
	public static boolean isFirstWhite = true;
	public static boolean isFirstBlack = true;
	public static boolean lastWasWhite = true;
	public static boolean lastWasBlack = true;
	int color;
	String gnu_reprezentation;
	String o_reprezentation;

	public Piesa(int color_, String repr_gnu, String repr_o)
	{	
		color = color_;
		assert color == WHITE || color == BLACK:
				"invalid color for Piesa " + color;
		gnu_reprezentation = repr_gnu;
		o_reprezentation = repr_o;
		assert (gnu_reprezentation != null)&&(o_reprezentation != null) :
				"invalid null reprezentation";
	}

	public int getColor()
	{
		return color;
	}

	public boolean isWhite()
	{
		return color == WHITE;
	}
	
	public boolean isBlack()
	{
		return color == BLACK;
	}

	public String toGnuString()
	{
		if (color == WHITE)
			return gnu_reprezentation.toLowerCase();
		else 
			return gnu_reprezentation.toUpperCase();
	}
	public String toOString()
	{
		if (color == WHITE)
			return o_reprezentation.toLowerCase();
		else 
			return o_reprezentation.toUpperCase();
	}
	private boolean canEat(Piesa[][] tabla, Point mov)
	{
		// if noting at destination, we can eat void
		if (null == tabla[mov.x][mov.y])
			return true;

		// assert it's not of the same color
		if ((tabla[mov.x][mov.y].getColor() == this.getColor()))
			return false;
		
		// cannot eat that which cannot be eaten :)
		if (tabla[mov.x][mov.y] instanceof Rege)
			return false;
		
		// we can eat anything else
		return true;
	}

	protected int delta(int src, int dst)
	{
		if (src < dst)
			return 1;
		else if (src == dst)
			return 0;
		else 
			return -1;
	}

	public boolean isLegal(Piesa[][]tabla, Point src, Point dst)
	{
		if (!canEat(tabla, dst))
			return false;

		return isLegalImpl(tabla, src, dst);
	}

	public abstract boolean 
	isLegalImpl(Piesa[][] tabla, Point src, Point dst);
}
