import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// This is the custom java annotation.

//Using this custom annotation for implementing Role Based Access Control.

//Target the type and method of the application where Annotation is mentioned
@Target({ElementType.TYPE, ElementType.METHOD})
//Application will check for the annotation at run time.
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresRole {
	String value();
}