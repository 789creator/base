/**
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */  
package com.base.api.common.validator;

import com.base.api.common.utils.IDCardValidateUtil;
import com.base.api.common.utils.StrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 校验身份证号
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */
public class IsIdentityNumberValidator implements ConstraintValidator<IsIdentityNumber, String> {

	Logger logger = LoggerFactory.getLogger(IsIdentityNumberValidator.class);
	
	@Override
	public void initialize(IsIdentityNumber constraintAnnotation) {
		//初始化，得到注解数据
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String result = null;
		try {
			result = IDCardValidateUtil.IDCardValidate(value);
		} catch (Exception e) {
			logger.error("请输入合法的身份证号", e);
		}
		if(StrUtils.isNotBlank(result)){
			return false;
		}
		return true;
	}

}
