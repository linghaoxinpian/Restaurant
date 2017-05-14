package service;

import java.util.List;

import entity.DiningTable;
import entity.TableStatus;
import factory.BeanFactory;
import idao.IDiningTableDao;
import iservice.IDiningTableService;

public class DiningTableService implements IDiningTableService {

	private IDiningTableDao IDiningTableDao=BeanFactory.getInstance(IDiningTableDao.class);
	@Override
	public List<DiningTable> findByStatus(TableStatus status) {

		try {
			return IDiningTableDao.findByStatus(status);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public DiningTable findById(int id) {
		
		try {
			return IDiningTableDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
