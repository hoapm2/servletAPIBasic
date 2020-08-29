package utils;

import javax.servlet.http.HttpServletRequest;

// util la noi cai dat nhung ham chung cho tung doi tuong
// sessionUtil : quan ly data : put, get, remove thong tin nguoi dung o moi session
public class SessionUtil {
	
	private static SessionUtil sessionUtil=null;
	public static SessionUtil getInstance() {
		if (sessionUtil==null) {
			sessionUtil= new SessionUtil();
		}
		return sessionUtil;
	}
	public void putValue(HttpServletRequest req, String key, Object value ) {
		req.getSession().setAttribute(key, value);
		// session dc tao ra tu request, sau do dung setAttribute de bind data tuong ung, can request de tao ra session
		
	}
	public Object getValue(HttpServletRequest req, String key) {
		//do ko biet datatype data dc lay ra nhu nao nen de la object, sau do ep kieu
		Object object=req.getSession().getAttribute(key);
		return req.getSession().getAttribute(key);
	}
	public void removeValue(HttpServletRequest req, String key) {
		req.getSession().removeAttribute(key);
	}
}
