
public class 형변환_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=10;
		byte b=(byte)i;
		// byte b=10
		System.out.println("i="+i+",b="+b);
		
		i=350;  // 350-256 ==> 94
		b=(byte)i; // 오버플로우 b=(-128~127)
		System.out.println("i="+i+",b="+b);
		// 0010 1100  ==>  32+8+4 ==> 44
		//b => 8bit (0,1 => 8개만 저장)
		/*
		 * 	  256 128 64 32 16 8 4 2 0
		 *     1   0   0  1  0 1 1 0 0
		 *     
		 *     300 => 2진법
		 *     1 0010 1100
		 */
		// 위와 같이 오류(오버플로우_답이 틀려짐)가 날 수 있기 때문에 아무때나 형변환하면 안됨

	}

}
