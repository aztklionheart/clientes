package com.creditas.clientes.utils;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.creditas.clientes.model.CreditoModel;

public class MapperHelper {

	static ModelMapper modelMapper = new ModelMapper();

	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
	}

	public static <S, T> T map(S source, Class<T> targetClass) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		return modelMapper.map(source, targetClass);

	}

	public static <S, T> T map2(CreditoModel creditoModel, Type listType) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(creditoModel, listType);

	}

}
