package iservice;

import java.util.List;

import entity.DiningTable;
import entity.TableStatus;

public interface IDiningTableService {

	/**
	 * 根据餐桌状态查询
	 * @param status
	 * @return
	 */
	List<DiningTable> findByStatus(TableStatus status);
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	DiningTable findById(int id);
}
