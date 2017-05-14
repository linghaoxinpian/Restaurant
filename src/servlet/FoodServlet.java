package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Food;
import utils.PageBean;
public class FoodServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public Object foodDetails(HttpServletRequest request, HttpServletResponse response){
		//第一次访问，保存餐桌信息
		HttpSession session=request.getSession();
		if(session.getAttribute("diningTable")==null){
			//从数据库获取餐桌信息并保存到session中
			session.setAttribute("diningTable", iDiningTableService.findById(Integer.parseInt(request.getParameter("tableId"))));
		}
		
		//获取查询参数
		String food_type=request.getParameter("foodType");	//需要展示的菜系
		int current_page=request.getParameter("current_page")==null?1:Integer.parseInt(request.getParameter("current_page"));	//当前分页页码
		int page_size=9;									//每页显示数据量
		String foodName=request.getParameter("foodName");	//模糊查询的菜名
		
		//注意实例化：泛型类的内部类
		PageBean<Food> pageBean=new PageBean<Food>();
		PageBean<Food>.Condition condition=pageBean.new Condition(food_type,current_page,page_size,foodName);
		pageBean.condition=condition;
		
		//获取数据
		ifoodService.getAll(pageBean);
		request.setAttribute("allFoodType",ifoodTypeService.getAll());
		request.setAttribute("pageBean", pageBean);
		return request.getRequestDispatcher("/app/caidan.jsp");
	}
}
