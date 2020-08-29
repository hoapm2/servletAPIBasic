package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Constant;
import model.UserModel;
import utils.SessionUtil;

public class AuthorizationFilter  implements Filter{

	
	// xu ly ko chi moi admin
	
	
	private ServletContext context;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context=filterConfig.getServletContext();
		// goi filter len
	}

	@Override
	public void doFilter(ServletRequest servletReqest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) servletReqest;
		HttpServletResponse response= (HttpServletResponse) servletResponse;
		String url=request.getRequestURI(); //lay url
		if (url.contains("admin")) {
			UserModel usermodel= (UserModel) SessionUtil.getInstance().getValue(request, "usermodel");
			if (usermodel!=null) {
				if (usermodel.getRole().getCode().equalsIgnoreCase(Constant.USER_CODE)) {
					response.sendRedirect(request.getContextPath()+"/login?action=login&message=not_permission&alert=danger");
				} else if (usermodel.getRole().getCode().equalsIgnoreCase(Constant.ADMIN_CODE)) {
					filterChain.doFilter(servletReqest, servletResponse);// day vao trang admin
				}
			} else {
				response.sendRedirect(request.getContextPath()+"/login?action=login&message=not_login&alert=danger");
			}
		}  else {
			UserModel usermodel= (UserModel) SessionUtil.getInstance().getValue(request, "usermodel");
			if (usermodel!=null) {
				if (usermodel.getRole().getCode().equalsIgnoreCase(Constant.ADMIN_CODE) && (!url.contains("admin"))) {
					SessionUtil.getInstance().removeValue(request, "usermodel" );
				}
			}
			filterChain.doFilter(servletReqest, servletResponse); // day ve trang user.
			
		}
	}	

	@Override
	public void destroy() {
		
		
	}
   
}
