package component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NewInvocationHandler implements InvocationHandler{
	
	Object obj[];
	
	public NewInvocationHandler(Object obj[]) {
		this.obj = obj;
	}
		
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object object = null;
		
		for(Object o: obj) {
			Method methods[] = o.getClass().getDeclaredMethods();
			for(Method m: methods) {
				if(m.getName().equals(method.getName())) {
					m.setAccessible(true);
					object = method.invoke(o, args);
				}
			}
		}
		return object;
	}
}
