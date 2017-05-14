package utils;

import java.util.List;

public class PageBean<T> {
	public Condition condition;
	public List<T> list;
	
	public PageBean(){}
	public PageBean(Condition condition){
		this.condition=condition;
	}

	/**
	 * @return 总页数
	 */
	public int getTotalPage() {
		return (int) Math.ceil(list.size() / condition.page_size);
	}

	/**
	 * @return 总数据条数
	 */
	public int getTotalCount(){
		return list.size();
	}
	
	/**
	 * 封装查询条件
	 * 
	 * @author linghaoxinpian
	 *
	 */
	public class Condition {
		public String food_type;// =request.getParameter("foodType"); //需要展示的菜系
		public int current_page;// =request.getParameter("current_page"); //当前分页页码
		public int page_size;// =9; //每页显示数据量
		public String foodName;	//菜名
		public Condition() {
		}

		/**
		 * 
		 * @param food_type
		 *            需要展示的菜系
		 * @param current_page
		 *            当前分页页码
		 * @param page_size
		 *            每页显示数据量
		 */
		public Condition(String food_type, int current_page, int page_size ,String foodName) {
			this.food_type = food_type;
			this.current_page = current_page;
			this.page_size = page_size;
			
		}
	}

	
	
	
	
//	封装
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

	


}
