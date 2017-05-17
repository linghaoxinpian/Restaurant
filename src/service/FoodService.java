package service;

import entity.Food;
import factory.BeanFactory;
import idao.IFoodDao;
import iservice.IFoodService;
import utils.PageBean;

public class FoodService implements IFoodService {
	private IFoodDao ifoodDao=BeanFactory.getInstance(IFoodDao.class);
	@Override
	public Food findById(int id) {
		return ifoodDao.findById(id);
	}

	@Override
	public void getAll(PageBean<Food> pb) {
		ifoodDao.getAll(pb);
	}

}
