package JavaSkill.JavaMap;//Complete this code or write your own from scratch
import java.util.HashMap;
import java.util.Scanner;

class Solution{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		HashMap<String,Integer> stringIntegerHashMap = new HashMap<>();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			stringIntegerHashMap.put(name,phone);
			in.nextLine();
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
			Integer c = stringIntegerHashMap.getOrDefault(s,null);
			System.out.println(c == null ? "Not found" : (s +"="+c));
		}
	}
}



