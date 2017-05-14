package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.DiningTable;
import entity.TableStatus;
import idao.IDiningTableDao;
import utils.JdbcUtils;

public class DiningTableDao implements IDiningTableDao {

	@Override
	public List<DiningTable> findByStatus(TableStatus status) {
		String sql="select * from diningtable where tableStatus =?";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<DiningTable>(DiningTable.class),status.ordinal());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public DiningTable findById(int id) {
		
		String sql="select * from diningtable where id=?";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<DiningTable>(DiningTable.class),id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
