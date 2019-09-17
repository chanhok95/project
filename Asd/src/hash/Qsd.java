package hash;

public class Qsd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 10;
		int z;
		System.out.println("------------");
		x++; // 10
		++x; // 11
		System.out.println("x" + x); // 12 

		System.out.println("--------------");
		y--; // 10
		--y; // 9
		System.out.println("y="+y); // 8
		System.out.println("--------------");
		z= x++; // z = 12  x = 13
		System.out.println("z=" + z ); 
		System.out.println("x="+x);
		
		System.out.println("--------------");
		z=++x;   // z= 14 	x =14
		System.out.println("z="+z);
		System.out.println("x="+x);
		
		System.out.println("--------------");
		
		z= ++x + y++;  // x = 15  y= 8
		System.out.println("z = " +z ); // 23 
		System.out.println("x = " +x ); // 15 
		System.out.println("y = " +y );	// 9
		
		
	
	}

}
