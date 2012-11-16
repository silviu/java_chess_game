
class Nebun extends Regina
{
	public Nebun(int color_)
	{
		super(color_, "b", "n");
	}


	public boolean isLegalImpl(Piesa[][] tabla, Point src, Point dst)
	{
		if (!super.isLegalImpl(tabla, src, dst))
			return false;
		// tower is qween moving diagonally
		return ((src.x != dst.x) && (src.y != dst.y));
	}
}//~class TURA endtag
