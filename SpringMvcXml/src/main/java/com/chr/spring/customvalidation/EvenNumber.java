package com.chr.spring.customvalidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=EvenNumberValidator.class)//Clase que contiene la logica de validacion
@Target({ElementType.METHOD, ElementType.FIELD})//Objetivo de la validacion, metodo o campo
@Retention(RetentionPolicy.RUNTIME)// valida la el campo o metodo en tiempo de ejecucion
public @interface EvenNumber {
	
	public String message() default "Ingrese un numero par";
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
