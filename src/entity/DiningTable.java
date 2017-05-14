package entity;

import java.sql.Date;

public class DiningTable {
	public int id; 				// id int(11) AI PK
	public String tableName;	 // tableName varchar(20)
	public int tableStatus; 	// tableStatus int(11)
	public Date orderData; 		// orderData datetime
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getTableStatus() {
		return tableStatus;
	}
	public void setTableStatus(int tableStatus) {
		this.tableStatus = tableStatus;
	}
	public Date getOrderData() {
		return orderData;
	}
	public void setOrderData(Date orderData) {
		this.orderData = orderData;
	}
	
	
}
