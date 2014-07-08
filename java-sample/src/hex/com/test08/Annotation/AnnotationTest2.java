package hex.com.test08.Annotation;
public class AnnotationTest2 {
	
	@MyAnnotation("001")
	String name;

    @MyAnnotation("002")
    public void execute(){
        System.out.println("method");
    }
}