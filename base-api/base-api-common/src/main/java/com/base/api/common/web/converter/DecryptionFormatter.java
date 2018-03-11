package com.base.api.common.web.converter;

import com.base.api.common.encrypt.DESUtil;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;


/**
 * 解密
 * @author xiaohaizi
 * @date 2017年3月9日 上午11:23:06   
 *
 */
public class DecryptionFormatter implements Formatter<String> {

	@Override
	public String parse(String text, Locale locale) throws ParseException {
		return DESUtil.decryptAftorURLDecoder(text);
	}

	@Override
	public String print(String object, Locale locale) {
		return DESUtil.decryptAftorURLDecoder(object);
	}
}
