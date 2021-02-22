package lab_book;

public class Question_45{
public static void main(String argv[]){
	Question_45 r = new Question_45();
r.amethod(r);
}
public void amethod(Question_45 r){
int i=99;
multi(r);
System.out.println(i);
}
public void multi(Question_45 r){
//r.i = r.i*2; // 'i' is a varibale created inside a method so throws error at compile time 
}
}
