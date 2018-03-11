package com.base.api.common.web.converter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.base.api.common.constants.Constants;
import org.springframework.http.MediaType;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import com.alibaba.fastjson.serializer.SerializerFeature;


/**
 *
 */
public class JSONHttpMessageConverter extends FastJsonHttpMessageConverter4 {

	public final static Charset charset = Charset.forName(Constants.CHARSET_UTF8);

	public JSONHttpMessageConverter(){
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		this.setSupportedMediaTypes(fastMediaTypes);
	}

	@Override
	protected void writeInternal(Object obj, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		String json =  CustomJson.toJSONStringWithCustom(obj, new CustomPropertyPreFilter(), serializerFeatureArray());
		OutputStream out = outputMessage.getBody();
		byte[] bytes = json.getBytes(charset);
		out.write(bytes);
	}

	/**
	 * 自定义输入转换格式
	 * @return
	 */
	private SerializerFeature[] serializerFeatureArray(){
		return new SerializerFeature[]{
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.QuoteFieldNames,
				SerializerFeature.WriteNullNumberAsZero,
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullBooleanAsFalse
		};
	}

}
