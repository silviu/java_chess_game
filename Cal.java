
class Cal extends Piesa
{
	
	public Cal(int color_)
	{
		super(color_, "n", "c");
	}


	public boolean isFreeWay(Piesa[][] tabla,Point poz, Point mov)
	{
		return true;
	}
	public boolean isLegalImpl(Piesa[][] tabla, Point poz, Point mov)
	{
		if ( 	   ((mov.x == poz.x + 1) && (mov.y == poz.y + 2))
		   		|| ((mov.x == poz.x + 1) && (mov.y == poz.y - 2)) 
				|| ((mov.x == poz.x - 2) && (mov.y == poz.y + 1))
				|| ((mov.x == poz.x - 2) && (mov.y == poz.y - 1))
				|| ((mov.x == poz.x + 2) && (mov.y == poz.y - 1))
				|| ((mov.x == poz.x + 2) && (mov.y == poz.y + 1))
				|| ((mov.x == poz.x - 1) && (mov.y == poz.y + 2))
				|| ((mov.x == poz.x - 1) && (mov.y == poz.y - 2))
			)
			if (tabla[mov.x][mov.y] == null)
				return true;
			else
				if ((tabla[poz.x][poz.y].isWhite()) && (tabla[mov.x][mov.y].isBlack()))
				 		return true;
				 else
				 	if ((tabla[poz.x][poz.y].isBlack()) && (tabla[mov.x][mov.y].isWhite()))
						return true;
		return false;
	}
}
