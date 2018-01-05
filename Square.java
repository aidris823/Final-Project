public class Square{
    private int color;
    private int xcor;
    private int ycor;
    private int[] coordinates;
    public Square(int x, int y){
	x = xcor;
	y = ycor;
	coordinates = {x,y};
    }
    public void setX(int x){
	xcor = x;
    }
    public void setY(int y){
	ycor = y;
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public void setColor(int c){
	color = c;
    }
    public int getColor(){
	return color;
    }
}
