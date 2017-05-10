package dao;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.FoodType;
import idao.IFoodTypeDao;
import utils.JdbcUtils;

public class FoodTypeDao implements IFoodTypeDao {

	@Override
	public void save(FoodType foodType) {
		String sql="insert into foodType(typeName) value(?)";
		try {
			JdbcUtils.getQueryRunner().insert(sql, new BeanHandler<FoodType>(FoodType.class),foodType.typeName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(FoodType foodType) {
		String sql="update foodType set typeName=? where id=?";
		try {
			
			JdbcUtils.getQueryRunner().update(sql, foodType.typeName,foodType.id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		String sql="delete from foodType where id=?";
		try {
			 JdbcUtils.getQueryRunner().update(sql,id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public FoodType findById(int id){
		String sql="select * from foodType where id=?";
		try {
			return JdbcUtils.getQueryRunner().query(sql,new BeanHandler<FoodType>(FoodType.class),id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public List<FoodType> getAll() {
		String sql="select * from foodType";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<FoodType>(FoodType.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll(String typeName) {
		String sql="select * from foodType where typeName like ?";
		try {			
			List<FoodType> list= JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<FoodType>(FoodType.class),"%"+typeName+"%");
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}

}
