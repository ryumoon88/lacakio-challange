package com.naufal.codingtask.utils;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WrapWithKey {
    String value() default "data";
}
