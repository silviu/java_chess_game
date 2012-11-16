
class Regina extends Piesa
{
	String color;
	protected Regina(int color_, String gnu, String o)
	{
		super(color_, gnu, o);
	}

	public Regina(int color_)
	{
		this(color_, "q", "d");
	}

	public boolean isLegalImpl(Piesa[][] tabla, Point src, Point dst)
	{

		
		int dx = delta(src.x, dst.x);
		int dy = delta(src.y, dst.y);
		if ((dst.x != src.x) && 
		    (dst.y != src.y) &&
		    (Math.abs(dst.x - src.x) != (Math.abs(dst.y - src.y))))
			return false;
			
		int x = src.x + dx;
		int y = src.y + dy;
		int stopx = dst.x;
		int stopy = dst.y;
		
		if ((Math.abs(dst.x - src.x) == 1) ||
		    (Math.abs(dst.y - src.y) == 1))
			return true;

		for (; (x != stopx) || (y != stopy); x += dx, y += dy)
			if (tabla[x][y] != null)
				return false;
		return true;
	}
}
