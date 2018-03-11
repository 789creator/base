/**
 * @author zhubingbing
 * @date   2017年4月5日 下午5:25:36   
 */  
package com.base.api.common.validator;


import com.base.api.common.ConfigUtil;
import com.base.api.common.utils.LegalNickNameUtil;
import com.base.api.common.utils.StrUtils;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * The type Validator util.
 *
 * @author zhubingbing
 * @date 2017年4月5日 下午5:25:36
 */
public class ValidatorUtil {

	/**
	 * Check login password boolean.
	 *
	 * @param LoginPassword the login password
	 * @return the boolean
	 */
	public static boolean checkLoginPassword(String LoginPassword){
		if(StrUtils.isBlank(LoginPassword)){
			return false;
		}
		String patternStr = "^([A-Z]|[a-z]|[0-9]){6,16}$";
		return Pattern.matches(patternStr, LoginPassword);
	}

	/**
	 * Check pay password boolean.
	 *
	 * @param payPassword the pay password
	 * @return the boolean
	 */
	public static boolean checkPayPassword(String payPassword){
		if(StrUtils.isBlank(payPassword)){
			return false;
		}
		return Pattern.matches("^\\d{6}$", payPassword);
	}

	/**
	 * Check true name boolean.
	 *
	 * @param trueName the true name
	 * @return the boolean
	 */
	public static boolean checkTrueName(String trueName){
		if(StrUtils.isBlank(trueName) || trueName.length() > 20){
			return false;
		}
		String pattern = "^([\\u4e00-\\u9fa5]{1,20}|[a-zA-Z\\.\\s]{1,20})$";
		return Pattern.matches(pattern,trueName);
	}

	/**
	 * Check mobile code boolean.
	 *
	 * @param mobileCode the mobile code
	 * @return the boolean
	 */
	public static boolean checkMobileCode(String mobileCode){
		if(StrUtils.isBlank(mobileCode)){
			return false;
		}
		String patternStr = "^\\d{6}$";
		return Pattern.matches(patternStr, mobileCode);
	}

	/**
	 * Check bank card boolean.
	 *
	 * @param bankCard the bank card
	 * @return the boolean
	 */
	public static boolean checkBankCard(String bankCard){
		if(StrUtils.isBlank(bankCard)){
			return false;
		}
		String patternStr = "^\\d{15,30}$";
		return Pattern.matches(patternStr, bankCard);
	}

	/**
	 * Check address boolean.
	 *
	 * @param address the address
	 * @return the boolean
	 */
	public static boolean checkAddress(String address){
		if(StrUtils.isBlank(address) || address.length() > 200){
			return false;
		}
		return true;
	}

	public static boolean checkMoney(String amount){

		boolean isNo = Pattern.matches ("[0-9]+(.[0-9]{2})?$", amount);
		boolean isNor = Pattern.matches ("[0-9]+(.[0-9]{1})?$", amount);
		boolean isInt = Pattern.matches ("^\\+?[1-9][0-9]*$", amount);
		if (isNo == false && isInt == false && isNor == false) {
			return false;
		}
		return true;
	}
	/**
	 * Check nick name boolean.
	 *
	 * @param nickName the nick name
	 * @return the boolean
	 */
	public static boolean checkNickName(String nickName){
		/*String nickNameStr = ConfigUtil.getInstance().getMemberNickNameSensitive();
		if (StrUtils.isNotBlank(nickNameStr)) {
			String[] nickNames = nickNameStr.split(",");
			for (String s : nickNames) {
				if (nickName.indexOf(s) != -1) {
					return false;				
					}
			}
		}*/
		Boolean isSensitive = LegalNickNameUtil.nickNameFilter(nickName);
		if (isSensitive) {
			return false;
		}
		return true;
	}
	
}
