package lab_book;
	class BaseClassOver{
		private void amethod(int iBase){
		System.out.println("Base.amethod");
		}
		}
		class Question_58 extends BaseClassOver{
		public static void main(String argv[]){
		Question_58 o = new Question_58();
		int iBase=0;
		o.amethod(iBase);
		}
		public void amethod(int iOver){
		System.out.println("Over.amethod"); // prints this line Over.amethod as object of Program59_Over is created and is used
		}
}
