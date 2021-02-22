package lab_book;

public class Question_42{
public static void main(String argv[]){
Question_42 l = new Question_42();
l.amethod();
}
public void amethod(){
int ia[] = new int[4];
for(int i=0; i< ia.length;i++) // iterates from i value 0 to 4
{
ia[i]=i;
System.out.println(ia[i]);
}
}
}