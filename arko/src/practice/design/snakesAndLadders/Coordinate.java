package practice.design.snakesAndLadders;

public class Coordinate {	
	int x;
	int y;
	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Coordinate c) {
		return (x == c.x && y== c.y);
	}
	
	public String toString() {
		return new String("("+x + "," + y +")");
	}
	
}