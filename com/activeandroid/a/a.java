package com.activeandroid.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface a {
    String a() default "";

    int b() default -1;

    boolean c() default false;

    b d() default b.FAIL;

    c e() default c.NO_ACTION;

    c f() default c.NO_ACTION;

    boolean g() default false;

    b h() default b.FAIL;

    String[] i() default {};

    b[] j() default {};

    boolean k() default false;

    String[] l() default {};
}
