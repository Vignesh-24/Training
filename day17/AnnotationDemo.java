package day17;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class AnnotationDemo {
	public static void main(String[] args)throws Exception {
		PaintBrush brush=PaintContainer.getBrush();
		brush.doPaint();
	}

}

@Retention(RetentionPolicy.RUNTIME)
@interface In{
	String paintClass();
}

class PaintContainer{
	public static PaintBrush getBrush()throws Exception {
		PaintBrush brush=new PaintBrush();
		Field f=brush.getClass().getDeclaredField("paint");
		f.setAccessible(true);
		In in=f.getAnnotation(In.class);
		if(in!=null) {
			String paintClass=in.paintClass();
			brush.paint=(Paint)Class.forName(paintClass).getConstructor().newInstance();
		}
		else {
			
		}
		//dependency injection
		
		return brush;
	}
}

class PaintBrush{
	@In(paintClass = "day17.RedPaint")
	Paint paint;
	public void doPaint() {
		System.out.println(paint);
	}
}




abstract class Paint{
	public Paint() {
		
	}
}
class RedPaint extends Paint{
	public RedPaint() {
	}
}
class BluePaint extends Paint{
	public BluePaint() {
		
	}
}