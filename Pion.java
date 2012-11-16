import java.io.*;
import java.util.*;
class Pion extends Piesa
{
	public Pion(int color_)
	{
		super(color_, "p", "p");
	}
	
	private boolean isMovingForward(Point src, Point dst)
	{
		// white moves forward to superior coords
		// black moves forward to inferior coords
		if (this.isWhite())
		   return (dst.x > src.x);
		else
			return (dst.x < src.x);
	}
	public boolean isLegalImpl(Piesa[][] tabla, Point src, Point dst)
	{
		// Pawns must move forward
		if (!isMovingForward(src, dst))
			return false;
		
		// normal move, noting is eaten
		if (src.y == dst.y)
		{
			// cannot eat if moving forward
			if (tabla[dst.x][dst.y] != null)
				return false;

			int diffx = Math.abs(dst.x - src.x);
			switch(diffx)
			{
				case 2:
					int middle_x = (src.x + dst.x) / 2;
					if ((src.x != 1) && (src.x != 6))
						return false;
					// en-passant - must not jump over a piece
					// return success if nothing in between
					return (tabla[middle_x][src.y] == null);
				case 1:
					// normal forward move, noting to see here, move along
					return true;
				default:
					// any other move is wrong
					return false;
			}
		}

		// not a normal forward move => we eat a piece

		// cannot move on a diagonal more than one position
		if ( (Math.abs(dst.y - src.y) != 1) &&
			 (Math.abs(dst.x - dst.x) != 1))
			return false;

		// cannot move on a diagonal, but not eat anything
		if(tabla[dst.y][dst.x] == null)
			return false;
		
		return true;
	}
}
