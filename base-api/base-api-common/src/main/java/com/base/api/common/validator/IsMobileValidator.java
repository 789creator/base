/**
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */  
package com.base.api.common.validator;



import com.base.api.common.utils.StrUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 手机号校验器
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

	
	@Override
	public void initialize(IsMobile constraintAnnotation) {
		//初始化，得到注解数据
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(!StrUtils.isMobile(value)) {
	       return false;
	    }
		return true;
	}

}
