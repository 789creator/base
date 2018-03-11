package com.base.api.common.web.converter;

import com.google.common.collect.Sets;
import com.base.api.common.annotation.DecryptionAnnotation;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.Set;


/**
 * 数据解密
 * @author xiaohaizi
 * @date 2017年3月9日 上午11:22:33   
 *
 */
public class DecryptionConversionServiceFactoryBean implements AnnotationFormatterFactory<DecryptionAnnotation>{
	private final Set<Class<?>> fieldTypes;
	private final DecryptionFormatter formatter;
    public DecryptionConversionServiceFactoryBean() {
        Set<Class<?>> set = Sets.newHashSet();
        set.add(String.class);
        this.fieldTypes = set;
        this.formatter = new DecryptionFormatter();
    }
	
	@Override
	public Set getFieldTypes() {
		return fieldTypes;
	}

	@Override
	public Printer<?> getPrinter(DecryptionAnnotation annotation, Class<?> fieldType) {
		return formatter;
	}

	@Override
	public Parser<?> getParser(DecryptionAnnotation annotation, Class<?> fieldType) {
		return formatter;
	}

}
