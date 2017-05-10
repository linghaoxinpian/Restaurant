package service;

import java.util.List;


import entity.FoodType;
import factory.BeanFactory;
import idao.IFoodTypeDao;

/**
 * 
 * @author linghaoxinpian
 *
 */
public class FoodTypeService implements IFoodTypeDao {
	
	private IFoodTypeDao foodTypeDao=BeanFactory.getInstance(IFoodTypeDao.class);
	@Override
	public void save(FoodType foodType) {
		foodTypeDao.save(foodType);
	}

	@Override
	public void update(FoodType foodType) {
		foodTypeDao.update(foodType);
	}

	@Override
	public void delete(int id) {
		foodTypeDao.delete(id);
	}

	@Override
	public FoodType findById(int id) {
		
		return foodTypeDao.findById(id);
	}

	@Override
	public List<FoodType> getAll() {
		
		return foodTypeDao.getAll();
	}

	@Override
	public List<FoodType> getAll(String typeName) {
		
		return foodTypeDao.getAll(typeName);
	}

}
