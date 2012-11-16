
class Tura extends Regina
{
	public Tura(int color_)
	{
		super(color_, "r", "t");
	}


	public boolean isLegalImpl(Piesa[][] tabla, Point src, Point dst)
	{
		if (!super.isLegalImpl(tabla, src, dst))
			return false;
		// tower is qween moving horiz/vert -ically
		return ((src.x == dst.x) || (src.y == dst.y));
	}
}//~class TURA endtag
