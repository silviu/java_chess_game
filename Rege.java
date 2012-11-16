
class Rege extends Piesa
{
	String color;
	public Rege(int color_)
	{
		super(color_, "k", "r");
	}

	public boolean isFreeWay(Piesa[][] tabla,Point poz, Point mov)
	{
		return true;
	}
	public boolean isLegalImpl(Piesa[][] tabla, Point poz, Point mov)
	{
		if (poz.x == mov.x)
			if (Math.abs(poz.y - mov.y) > 1)
				return false;
		if (poz.y == mov.y)
			if (Math.abs(poz.x - mov.x) > 1)
				return false;
		if ((poz.x != mov.x) && (poz.y != mov.y))
			return ((Math.abs(poz.y - mov.y) == 1) && 
			       (Math.abs(poz.x - mov.x) == 1));
		return true;
	}
}//~class REGE endtag
