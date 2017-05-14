package servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.BeanFactory;
import iservice.IDiningTableService;
import iservice.IFoodService;
import iservice.IFoodTypeService;
import utils.WebUtils;

public abstract class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected IFoodTypeService ifoodTypeService = BeanFactory.getInstance(IFoodTypeService.class);	
	protected IDiningTableService iDiningTableService=BeanFactory.getInstance(IDiningTableService.class);
	protected IFoodService ifoodService=BeanFactory.getInstance(IFoodService.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;character=UTF-8");
		
		String method = request.getParameter("method");
		if (method == null || method.isEmpty()) {
			method = "listTable";
		}
		// 请求uri
		Object uri;
		try {
			// 获取指定方法
			Method call_method = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,
					HttpServletResponse.class);
			uri = call_method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		WebUtils.Goto(request, response, uri);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
