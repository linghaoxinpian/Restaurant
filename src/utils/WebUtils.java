package utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtils {
	
	
	/**
	 * 跳转和重定向自适应
	 * @param uri 只能是String和RequestDispatcher
	 */
	public static void Goto(HttpServletRequest request,HttpServletResponse response,Object uri) throws IOException, ServletException{
		if(uri instanceof String){
			//重定向
			response.sendRedirect(request.getContextPath()+uri.toString());
		}
		else if(uri instanceof RequestDispatcher) {
			//跳转到请求页面
			((RequestDispatcher)uri).forward(request, response);
		}
	}
}
