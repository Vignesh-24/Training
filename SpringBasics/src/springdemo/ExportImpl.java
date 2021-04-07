package springdemo;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ExportImpl extends DelegatingIntroductionInterceptor implements Export{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doExport() {
		System.out.println("do export method is called...");
		
	}

}
