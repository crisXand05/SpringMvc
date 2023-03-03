package com.chr.spring.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EvenNumberValidator implements ConstraintValidator<EvenNumber, Integer>{
	@Override
    public void initialize(EvenNumber evennumber) {
		
    }
	@Override
	public boolean isValid(Integer arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		if( arg0 % 2 == 0) return true;
		return false;
	}

}
