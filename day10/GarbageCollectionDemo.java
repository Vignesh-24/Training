package day10;

public class GarbageCollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime=Runtime.getRuntime();
		
		/*
		 * PhantomReference - Will Not be Managed by GC
		 * WeakReference - Will be cleared once System.gc() is called
		 * SoftReference - Can be reverted back
		 */
		
		System.out.println("Before Birth.. "+runtime.freeMemory());
		GrandParent thata=new GrandParent();
		System.out.println("After Birth.. "+runtime.freeMemory());
		thata=null;
		System.gc();
		System.out.println("After Death (Garbage Collection).. "+runtime.freeMemory());

	}

}

class GrandParent{
	String name;
	String space;
	public GrandParent() {
		for(int i=0;i<1000;i++)
			space=new String(" "+i);
	}
}