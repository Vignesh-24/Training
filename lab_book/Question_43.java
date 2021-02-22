package lab_book;

class PriBase{ // if we declare as private error at compile time
PriBase(){
int i = 100;
System.out.println(i);
}
}
public class Question_43 extends PriBase{
static int i = 200;
public static void main(String argv[]){
	PriBase p = new PriBase();
System.out.println(i);
}
}
