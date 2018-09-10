package bitcamp.java110.cms.annotaion;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
 @Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value() default "";
    //  Controller의 호출 적용되는 Annotation.
}
