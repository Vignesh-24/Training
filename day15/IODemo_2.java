package day15;

import java.io.File;
import java.io.FilenameFilter;

public class IODemo_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file=new File("src/day15/abc.txt");
		System.out.println("Path of the file: "+file.getAbsolutePath());
		System.out.println("Name of the File: "+file.getName());
		System.out.println(file.exists()?"File Exists":"No it doesnt exist");
		System.out.println(file.canWrite());
		File destFolder=new File("D:\\Vicky\\Resume");
		String filelist[]=destFolder.list(new MyFileFilter("pdf"));
		for(String s:filelist) {
			System.out.println(s);
		}
	}

}




class MyFileFilter implements FilenameFilter{
	
	String extension;
	public MyFileFilter(String ext) {
		// TODO Auto-generated constructor stub
		this.extension=ext;
	}
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith("."+extension);
	}
	
}