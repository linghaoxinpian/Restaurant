package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.FoodType;
import factory.BeanFactory;
import iservice.IFoodTypeService;

@SuppressWarnings("unused")
public class FoodTypeServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	

	/**
	 * 添加菜系
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public Object addFoodType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			FoodType foodType = new FoodType();
			foodType.typeName = request.getParameter("foodTypeName");
			System.out.println(foodType.typeName);
			if(foodType==null|foodType.typeName.isEmpty()){
				response.getWriter().append("名称不能为空");
				return null;
			}
			// 保存
			ifoodTypeService.save(foodType);

			// 跳转
			return request.getRequestDispatcher("/FoodType?method=list");
	}
	
	/**
	 * 菜系列表
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public Object list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		List<FoodType> list = ifoodTypeService.getAll();
		//保存
		request.setAttribute("list", list);
		
		return 	request.getRequestDispatcher("/sys/type/list_foodtype.jsp");
	}

	public Object viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String id=request.getParameter("id");
		 FoodType model = ifoodTypeService.findById(Integer.parseInt(id));
		 //保存
		 request.setAttribute("model", model);

		 return request.getRequestDispatcher("/sys/type/update_foodtype.jsp");
	}
	
	public Object update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			FoodType model=new FoodType();
			model.setId(Integer.parseInt(request.getParameter("id")));
			model.setTypeName(request.getParameter("foodTypeName"));
			ifoodTypeService.update(model);
			return "/FoodType?method=list";	
	}
	
	public Object delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
			ifoodTypeService.delete(Integer.parseInt(request.getParameter("id")));
			return "/FoodType?method=list";		
	}
}











