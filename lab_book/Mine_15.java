package lab_book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Mine_15 {

	public static void main(String argv[]){
		Mine_15 m=new Mine_15();          
		System.out.println(m.amethod());
	}
	
	public int amethod() { 
		try {  
			FileInputStream dis=new FileInputStream("Hello.txt");     
            }catch (FileNotFoundException fne) {      
            	System.out.println("No such file found");              
            	return -1;                      
            	}catch(IOException ioe) {  
            		
            	} finally{      
            		System.out.println("Doing finally"); 
            	}         
		return 0;     
      }
	

}

/*OUTPUT
No such file found
Doing finally
-1
*/