package ro.teamnet.zth.api.annotations;

import java.lang.annotation.*;

/**
 * Created by Taranu on 06/05/15.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyController {
    String urlPath();
}