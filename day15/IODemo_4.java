package day15;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class IODemo_4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PushbackInputStream pbs=new PushbackInputStream
						(new ByteArrayInputStream
						(new String("hello this is vicky").getBytes()));
		int c=0;
		while((c=pbs.read())!=-1) {
			if((char)c=='v')
				pbs.unread('V');
			else {
				System.out.print((char)c);
			}
		}

	}

}
