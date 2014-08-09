package hex.com.test12.cloneObject1;

public class Snippet {
	public static void main(String[] args)    
	     {    
	       Student s1=new Student("zhangsan",18);    
	       Student s2=(Student)s1.clone();    
	       s2.name="lisi";    
	       s2.age=20;    
	       System.out.println("name="+s1.name+","+"age="+s1.age);//修改学生2后，不影响学生1的值。    
	    }   
}

