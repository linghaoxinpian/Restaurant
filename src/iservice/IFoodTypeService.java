package iservice;

import java.util.List;

import entity.FoodType;

public interface IFoodTypeService {
	/**
	 * 添加
	 */
	void save(FoodType foodType);
	
	/**
	 * 更新
	 * @param foodType
	 */
	void update(FoodType foodType);
	
	/**
	 * 删除
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	FoodType findById(int id);
	
	/**
	 * 查询全部
	 * @return
	 */
	List<FoodType> getAll();
	
	/**
	 * 根据菜名查询
	 * @param typeName
	 * @return
	 */
	List<FoodType> getAll(String typeName);
}
