package cn.com.smartdevices.bracelet.d.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface e {
    String a() default "";

    boolean b() default false;

    boolean c() default false;

    String d() default "";

    boolean e() default false;
}
