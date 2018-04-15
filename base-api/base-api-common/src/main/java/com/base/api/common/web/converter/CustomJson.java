package com.base.api.common.web.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.*;

/**
 * 自定义对象转JSON
 * @author: 
 * @date:   2017年3月9日 上午11:20:55   
 *
 */
public class CustomJson extends JSON {

	/**
	 * 重写fastJson方法
	 * @param object
	 * @param filter
	 * @param features
	 * @return
	 */
	public static final String toJSONStringWithCustom(Object object, SerializeFilter filter,
			SerializerFeature... features) {
		SerializeWriter out = new SerializeWriter();
		try {
			JSONSerializer serializer = new JSONSerializer(out);
			for (SerializerFeature feature : features) {
				serializer.config(feature, true);
			}
			if (filter != null) {
				if (filter instanceof PropertyPreFilter) {
					serializer.getPropertyPreFilters().add((PropertyPreFilter) filter);
				}

				if (filter instanceof NameFilter) {
					serializer.getNameFilters().add((NameFilter) filter);
				}

				if (filter instanceof ValueFilter) {
					serializer.getValueFilters().add((ValueFilter) filter);
				}

				if (filter instanceof PropertyFilter) {
					serializer.getPropertyFilters().add((PropertyFilter) filter);
				}

				if (filter instanceof BeforeFilter) {
					serializer.getBeforeFilters().add((BeforeFilter) filter);
				}

				if (filter instanceof AfterFilter) {
					serializer.getAfterFilters().add((AfterFilter) filter);
				}
			}
			serializer.write(object);
			return out.toString();
		} finally {
			out.close();
		}
	}
}
