package com.creditas.clientes.validation;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;

import com.creditas.clientes.model.CreditoModel;

/**
 * Implementacion de {@link ValidaTipoCredito} validator.
 **/
public class ValidaTipoCreditoValidator implements ConstraintValidator<ValidaTipoCredito, Object> {

//    private String fieldName;
	private String expectedFieldValue;
	private String dependFieldName;

	@Override
	public void initialize(ValidaTipoCredito annotation) {

		expectedFieldValue = annotation.fieldValue();
		dependFieldName = annotation.dependFieldName();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext ctx) {

		if (value == null) {
			return true;
		}

		try {

			CreditoModel credito = (CreditoModel) value;

			String fieldValue = credito.getTipoCreditoModel().getIdTipoCredito().toString();

			String dependFieldValue = BeanUtils.getProperty(value, dependFieldName);

			if (expectedFieldValue.equals(fieldValue) && dependFieldValue == null) {
				ctx.disableDefaultConstraintViolation();
				ctx.buildConstraintViolationWithTemplate(ctx.getDefaultConstraintMessageTemplate())
						.addNode(dependFieldName).addConstraintViolation();
				return false;
			}

		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}

		return true;
	}

}
