package hex.com.test15.This;
class B extends A {  
	private String name = "class B";  
    public B() {  
        System.out.println("B: "+ this.getClass().getName() );  
        System.out.println("B: "+this.name);  
    }  
}  