package entity;

public class FoodType {
	/**
	 * 主键
	 */
	public int id;
	
	/**
	 * 类别名
	 */
	public String typeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
