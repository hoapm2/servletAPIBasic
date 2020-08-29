package utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormUtil {
	@SuppressWarnings("unchecked")
	public static <T> T toModel (Class <T> classObject, HttpServletRequest request ) { 
		
	    T object=null;
	    try {
			object= (T)classObject.newInstance();
			BeanUtils.populate(object, request.getParameterMap());
			// request.getParameterMap() se dung de lấy data ở request và chuyển thành dạng json
			//BeanUtils.populate(object, request.getParameterMap()): dùng để chuyển data từ json map sang dạng model.
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		} 
		return object;
	}
}
