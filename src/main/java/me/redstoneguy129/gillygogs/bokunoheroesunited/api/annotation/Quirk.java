package me.redstoneguy129.gillygogs.bokunoheroesunited.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Quirk {
    String name();
    int id();
    boolean random() default true;
}
