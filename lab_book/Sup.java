package lab_book;

class Base_class{ 
    Base_class(int i){ 
    System.out.println("base constructor"); 
    } 
    Base_class(){ 
    } 
}

public class Sup extends Base_class{
    public static void main(String args[]){ 
         Sup s= new Sup(); 
    //One 
    } 
    Sup() 
    { 
        super(10);
    } 
    public void derived() 
    { 
        //Three 
    } 
} 


