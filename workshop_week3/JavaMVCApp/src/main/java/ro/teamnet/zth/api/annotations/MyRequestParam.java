package ro.teamnet.zth.api.annotations;

import java.lang.annotation.*;

/**
 * Created by Taranu on 07/05/15.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestParam {
    String paramName();
}
