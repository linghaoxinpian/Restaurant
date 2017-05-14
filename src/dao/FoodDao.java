package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import entity.Food;
import idao.IFoodDao;
import utils.JdbcUtils;
import utils.PageBean;

public class FoodDao<T> implements IFoodDao {

	@Override
	public void getAll(PageBean<Food> pb) {
		StringBuffer str_buffer=new StringBuffer();
		List<Object> param=new ArrayList<Object>();
//		SELECT food.id,
//	    foodName,
//	    foodType_id,
//	    price,
//	    mprice,
//	    remark,
//	    img
//	from food inner join foodtype
//	on foodType_id=foodtype.id
//	AND foodtype.id=3
//	AND foodName like '%全%'
//	LIMIT 0,1		
		
		str_buffer.append("SELECT food.id,");
		str_buffer.append("foodName,");
		str_buffer.append("foodType_id,");
		str_buffer.append("price,");
		str_buffer.append("mprice,");
		str_buffer.append("remark,");
		str_buffer.append("img ");
		str_buffer.append("from food inner join foodtype ");
		str_buffer.append("on foodType_id=foodtype.id ");
		
		if(pb.condition.food_type!=null&&pb.condition.food_type.trim().length()>0){			
			str_buffer.append("AND foodType_id=? ");	//添加条件
			param.add(pb.condition.food_type);		//添加参数			
		}
		if(pb.condition.foodName!=null&&pb.condition.foodName.trim().length()>0){			
			str_buffer.append("AND foodName like ? ");	//添加条件
			param.add("%"+pb.condition.foodName+"%");	//添加参数
		}
		//校验当前页码
		int total=getTotalCount(pb);
		if(Math.ceil(total/pb.condition.page_size)<pb.condition.current_page){
			//越界
			pb.condition.current_page=(int)Math.ceil(total/pb.condition.page_size);	//设置为尾页不动
		}
		 if(pb.condition.current_page<1){
			//越界
			pb.condition.current_page=1;	//设置为首页
		}
		
		//分页查询
		str_buffer.append("LIMIT ?,?");
		int index=(pb.condition.current_page-1)*pb.condition.page_size;
		param.add(index);
		param.add(pb.condition.page_size);
		System.out.println("sql:"+str_buffer.toString());
		try {
			pb.list= JdbcUtils.getQueryRunner().query(str_buffer.toString(), new BeanListHandler<Food>(Food.class),param.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalCount(PageBean<Food> pb) {
		StringBuffer str_buffer=new StringBuffer();
		List<Object> param=new ArrayList<Object>();
		str_buffer.append("SELECT COUNT(food.id) ");
		str_buffer.append("FROM food inner join foodtype ");
		str_buffer.append("on foodType_id=foodtype.id ");
		
		if(pb.condition.food_type!=null&&pb.condition.food_type.trim().length()>0){			
			str_buffer.append("AND foodType_id=? ");	//添加条件
			param.add(pb.condition.food_type);		//添加参数			
		}
		if(pb.condition.foodName!=null&&pb.condition.foodName.trim().length()>0){			
			str_buffer.append("AND foodName like ? ");	//添加条件
			param.add("%"+pb.condition.foodName+"%");	//添加参数
		}
		try {
			System.out.println("sql:"+str_buffer.toString());
			return JdbcUtils.getQueryRunner().query(str_buffer.toString(), new ScalarHandler<Long>(),param.toArray()).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Food findById(int id) {
		String sql="SELECT id,foodName,foodType_id,price,mprice,remark,img FROM food WHERE id=?";		
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<Food>(Food.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
