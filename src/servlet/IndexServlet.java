package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.DiningTable;
import entity.TableStatus;

public class IndexServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public Object listTable(HttpServletRequest request, HttpServletResponse response){
		List<DiningTable> list = iDiningTableService.findByStatus(TableStatus.Free);
		request.setAttribute("list", list);
		return request.getRequestDispatcher("/app/index.jsp");
	}
}
