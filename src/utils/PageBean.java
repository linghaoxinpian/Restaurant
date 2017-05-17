package utils;

import java.util.List;

public class PageBean<T> {
	public Condition condition;
	public List<T> list;
	/**
	 * 总记录数
	 */
	public int totalCount;
	
	/**
	 * 总页数
	 */
	@SuppressWarnings("unused")
	private int totalPage;
	
	public PageBean(){}
	public PageBean(Condition condition){
		this.condition=condition;
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

		//封装字段
		public String getFood_type() {
			return food_type;
		}

		public void setFood_type(String food_type) {
			this.food_type = food_type;
		}

		public int getCurrent_page() {
			return current_page;
		}

		public void setCurrent_page(int current_page) {
			this.current_page = current_page;
		}

		public int getPage_size() {
			return page_size;
		}

		public void setPage_size(int page_size) {
			this.page_size = page_size;
		}

		public String getFoodName() {
			return foodName;
		}

		public void setFoodName(String foodName) {
			this.foodName = foodName;
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
	public int getTotalPage() {
		return (int) Math.ceil((float)totalCount / condition.page_size);
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
