package controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Constant;
import model.NewsModel;
import paging.PageRequest;
import paging.Pageable;
import service.ICategoryService;
import service.INewsService;
import sort.SortImplement;
import utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {

	/**
	 *  
	 */
	private static final long serialVersionUID = 4851641645113863681L;

	@Inject
	private INewsService newService;
	
	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// NewsModel model= new NewsModel();
// day la phan convert data tu url vao model theo cach cu: 
//		 String pageStr=req.getParameter("page");
//	     String maxItemOnPageStr=req.getParameter("maxItemOnPage");
//		 if (pageStr!=null) {
//			 model.setPage(Integer.parseInt(pageStr));
//		 } else {
//			 model.setPage(1);
//		 }
//		 if (maxItemOnPageStr!=null) {
//			 model.setMaxItemOnPage(Integer.parseInt(maxItemOnPageStr));
//		 }
//		 
		// thay vi the su dung BeanUtils:
		NewsModel model = FormUtil.toModel(NewsModel.class, req);
		/*
		 * /admin-new - hien thi danh sach: type=list - them, sua bai viet: type=edit
		 */
		String view = "";
		if (model.getType().equalsIgnoreCase(Constant.LIST)) {
			view = "/views/admin/new/list.jsp";
			// pageble de giam thieu tham so
			Pageable pageble = new PageRequest(model.getPage(), model.getMaxItemOnPage(),
					new SortImplement(model.getSortName(), model.getSortBy()));

			// model la mat xich trung gian giua controller va view
			model.setListResult(newService.findAll(pageble));
			model.setTotalItem(newService.getTotalItems());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxItemOnPage()));

		} else if (model.getType().equalsIgnoreCase(Constant.EDIT)) {
			view = "/views/admin/new/edit.jsp";
			if (model.getId() != 0L) {
				model = newService.searchbyID(model.getId());
			} else {
				
			}
			req.setAttribute("categories", categoryService.findAll());
		}
		req.setAttribute(Constant.MODEL, model);
		// luu cai model trong request
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated met hod stub
		super.doPost(req, resp);
	}
}
