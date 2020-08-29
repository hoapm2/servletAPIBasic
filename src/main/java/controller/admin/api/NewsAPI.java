package controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.NewsModel;
import model.UserModel;
import service.INewsService;
import utils.HttpUtils;
import utils.SessionUtil;

@WebServlet(urlPatterns = { "/api-adminhomepage-news" })
public class NewsAPI extends HttpServlet {

	/**
	 * //API cho bai viet luu y: khi viet api chi dung ham dung doPost ,doPut,
	 * doDelete vi o trong servlet, post co nhiem vu them , sua, xoa doGet co nhiem
	 * vu query data, nhung da viet o trong MVC, API ko query
	 */

	@Inject
	private INewsService newService;

	private static final long serialVersionUID = 7436242764788454166L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");// go tieng viet
		resp.setContentType("application/json");// mac dinh kieu tra ve cho client -> giong voi postman
		NewsModel newModel = HttpUtils.of(req.getReader()).toModel(NewsModel.class); // chuyen data tu json vao model
		UserModel userModel=(UserModel) SessionUtil.getInstance().getValue(req, "usermodel");
		newModel.setCreateBy(((UserModel) SessionUtil.getInstance().getValue(req, "usermodel")).getUserName());// lay createBy tu session
		newModel = newService.save(newModel);
		System.out.println(newModel);
		mapper.writeValue(resp.getOutputStream(), newModel);// chuyen tu model ve json ne
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel updateNews = HttpUtils.of(req.getReader()).toModel(NewsModel.class);
		updateNews.setModifiedBy( ((UserModel) SessionUtil.getInstance().getValue(req, "usermodel")).getUserName());// lay createBy tu session
		updateNews = newService.update(updateNews);
		mapper.writeValue(resp.getOutputStream(), updateNews);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper= new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel newModel = HttpUtils.of(req.getReader()).toModel(NewsModel.class); 
		newService.delete(newModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}

}
