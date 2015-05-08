package ro.teamnet.zth.api.annotations;

import java.lang.annotation.*;

/**
 * Created by Taranu on 06/05/15.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMethod {
    String methodType() default "GET";
    String urlPath();

}
