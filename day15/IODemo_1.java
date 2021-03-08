package day15;

import java.io.FileReader;
import java.io.FileWriter;

public class IODemo_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IODemo_1().copyFile("src/day15/abc.txt", "src/day15/copyabc.txt");
		
	}
	
	public void copyFile(String srcFile, String destFile) {
		
		FileReader reader=null;
		
		//Try with resource block, it automatically closes the connection and commits the data..
		
		try(FileWriter writer=new FileWriter(destFile)){
			reader=new FileReader(srcFile);
			int numchars;
			char c[]=new char[8];
			while((numchars=reader.read(c))!=-1) {
				System.out.println("Writing "+numchars+" Characters..");
				writer.write(new String(c, 0, numchars));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
	}

}
