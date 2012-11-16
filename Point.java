class Point
{
	//create point coordinates from the string.
	int x,y;
	public Point(String s)
	{
		y = (int)((char)(s.charAt(0) - 96)-1);
		x = Integer.parseInt(String.valueOf(s.charAt(1))) - 1;
	}
}
