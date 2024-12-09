package ru.godl1ght.lab6.task3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Аннотация @Validate, которая указывает на класс с тестами
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Validate {
    // Содержит классы тестов, которые должны быть применены к объекту
    Class<?>[] value();
}
