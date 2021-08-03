package com.ssafy.ws01.step3;

public class DigitTest1 {
	
	public static void main(String[] args) {
		int count=1;
		//String s="\t\t\t\t\t\t";
		for (int i =0; i <5; i++) {
			//System.out.printf("%s",s.substring(0,i));
			for(int j=0;j<5;j++) {
				if(j<i)
					System.out.printf("%3s"," ");
				else {
					System.out.printf("%3d",count);
					count++;
				}
			}
			System.out.println();
			
		}

	}

}
