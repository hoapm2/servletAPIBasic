package controller.web;

import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Constant;
import model.NewsModel;
import model.UserModel;
import service.ICategoryService;
import service.INewsService;
import service.IUserService;
import utils.FormUtil;
import utils.SessionUtil;

@WebServlet(urlPatterns = { "/homepage", "/login","/logout"})
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3500762834657105845L;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message"); 

	@Inject
	private ICategoryService categoryService;
	@Inject
	private INewsService newsService;
	@Inject
	private IUserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long categoryid = 1L;// kieu long phai de them L
		// categoryService.findNewsbyCategoryID(categoryid);

		// req.setAttribute("news", newsService.findAllByCategoryId(categoryid));
		NewsModel md = new NewsModel();
		md.setCategoryId(2);
		md.setContent("Content Tesst");
		md.setTitle("Test");
		// md=newsService.save(md);
		// System.out.println(md);
		Long id = 1L;
//		    newsService.delete(id);
//		    newsService.searchbyID(idNews);

		// req.setAttribute("categories", categoryService.findAll());
		
		String action = req.getParameter("action");
		if (action != null && action.equalsIgnoreCase("login")) {
			String message=req.getParameter("message");
			String alert=req.getParameter("alert");
			if (message!=null && alert!=null) {
				req.setAttribute("message",resourceBundle.getString(message) );
				req.setAttribute("alert", alert);
			}
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equalsIgnoreCase("logout")) {
			SessionUtil.getInstance().removeValue(req, "usermodel");
			resp.sendRedirect(req.getContextPath()+"/homepage");
			// ko su dung request dispatcher vi ban chat cai do tra ve view
			// ban chat la sau khi an logout -> xoa session->   response ve controller trang chu -> sau khi ve controller trang chu roi moi requestDiparcher ve view
		} else {
		
		    UserModel usermodel= (UserModel) SessionUtil.getInstance().getValue(req, "usermodel");
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			  // ban chat cua requestdepartcher  de khi nguoi dung submit vao controller thi biet tra ve view nao
			rd.forward(req, resp);
			
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equalsIgnoreCase("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, req);
			
			model = userService.findByUsernameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
			if (model != null) {
				SessionUtil.getInstance().putValue(req, "usermodel", model);
				if (model.getRole().getCode().equalsIgnoreCase(Constant.USER_CODE)) {
					resp.sendRedirect(req.getContextPath() + "/homepage");
				} else if (model.getRole().getCode().equalsIgnoreCase(Constant.ADMIN_CODE)) {
					resp.sendRedirect(req.getContextPath() + "/adminhomepage");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/login?action=login&message=username_password_invalid&alert=danger");
				// dung sendRedirect de direct den 1 controller khac
			}
		}
		

	}
}
