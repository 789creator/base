/**
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */  
package com.base.api.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 校验真实名称
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */
public class IsTrueNameValidator implements ConstraintValidator<IsTrueName, String> {

	private static Logger logger = LoggerFactory.getLogger(IsTrueNameValidator.class);
	
	@Override
	public void initialize(IsTrueName constraintAnnotation) {
		//初始化，得到注解数据
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean ret = ValidatorUtil.checkTrueName(value);
		if(!ret){
			logger.error("姓名不符合规则：" + value);
		}
		return ret;

	}

}
