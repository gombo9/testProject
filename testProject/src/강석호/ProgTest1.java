package °­¼®È£;

import java.util.Scanner;

public class ProgTest1 {
	public static int cVar=0;
	String[] iStr= {"0","1","2","3","4","5","6","7","8","9"};
	double iDouble;
	boolean iBool=false;
	char iChar='a';
	
	String getGugudan(int dan) {
		String gugu="";
		 if (dan > 0) {
	         for (int i = 1; i <= 9; i++) {

	            gugu += dan + "*" + i + "=" + String.valueOf(dan * i)+"\t";   
	        
	         }
	      }
	      return gugu;      

		
	}

}