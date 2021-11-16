package com.creditas.clientes.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Valida que el campo {@code dependFieldName} tiene el valor
 * {@code fieldValue}.
 **/
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Repeatable(value = ValidaTipoCreditoContainer.class)
@Constraint(validatedBy = ValidaTipoCreditoValidator.class)
@Documented
public @interface ValidaTipoCredito {

//    String fieldName();
	String fieldValue();

	String dependFieldName();

	String message() default "{ValidaTipoCredito.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ TYPE, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		ValidaTipoCredito[] value();
	}

}