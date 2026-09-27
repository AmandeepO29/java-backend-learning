package in.strikes.aopCustomAnnotations.annotation;

//configured annotation
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {

    long warnAfter() default 1000;
    String operation() default "";
}
