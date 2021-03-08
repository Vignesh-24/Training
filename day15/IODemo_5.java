package day15;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.io.StringBufferInputStream;

public class IODemo_5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ByteArrayInputStream bis=new ByteArrayInputStream("helloWorld".getBytes());
		StringBufferInputStream sbis=new StringBufferInputStream("helo hai world");
		SequenceInputStream sis=new SequenceInputStream(bis, sbis);
		
		int c=0;
		while((c=sis.read())!=-1)
			System.out.print((char) c);
	}

}
