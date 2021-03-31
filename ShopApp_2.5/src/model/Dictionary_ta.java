package model;

import java.util.ListResourceBundle;

public class Dictionary_ta  extends ListResourceBundle{
	
	Object obj[][]= {
			{"username",
				"உங்கள் பெயர்"
			},
			{"password"," கடவுச் சொல்"
				}
			
	};
	
	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return obj;
	}

}


