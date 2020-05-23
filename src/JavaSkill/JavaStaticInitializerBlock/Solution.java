package JavaSkill.JavaStaticInitializerBlock;

import java.util.Scanner;

public class Solution {

//Write your code here
private static boolean flag = true;
private static int B;
private static int H;
static {
	Scanner scanner = new Scanner(System.in);
	B = scanner.nextInt();
	H = scanner.nextInt();
	if (B <=0 || H <= 0){
		System.out.println("java.lang.Exception: Breadth and height must be positive");
		System.exit(0);
	}

}
public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

