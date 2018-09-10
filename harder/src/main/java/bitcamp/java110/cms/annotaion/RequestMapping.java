package bitcamp.java110.cms.annotaion;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
 @Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value() default "";
    //  메소드에도 Annotation을 적용하는것임.
    //  Controller의 호출 방법이 바뀌게 됨.
}
