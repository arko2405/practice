package practice.bitwise;

public class BitwiseAdd {
public static void main(String[] args) {
	int i=-2;
	int j=-4;
	while(j!=0){
		int carry=i&j;
		i=i^j;
		j=carry<<1;
	}
	System.out.println(i);
}
}
