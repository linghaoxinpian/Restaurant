CREATE DATABASE restaurant CHARACTER SET UTF8;
use restaurant;
-- 1.餐桌表
CREATE TABLE diningTable(
	id INT PRIMARY KEY AUTO_INCREMENT,
	tableName VARCHAR(20),	-- 餐桌名
	tableStatus INT DEFAULT 0,	-- 0，空闲；1，预定
	orderData DATETIME	-- 预定时间
);

-- 2.菜类别表
CREATE TABLE foodType(
	id INT PRIMARY KEY AUTO_INCREMENT,
	typeName VARCHAR(20)	-- 菜类别名称
);

-- 3.菜品表
CREATE TABLE food(
	id INT PRIMARY KEY AUTO_INCREMENT,
	foodName VARCHAR(20),	-- 菜名称
	foodType_id INT	-- 所属菜系（外键）
);

-- 4.订单表
CREATE TABLE orders(
	id INT PRIMARY KEY AUTO_INCREMENT,
	table_id INT,	-- 餐桌编号（外键）
	orderDate DATETIME,	-- 下单时间
	totalPrice DOUBLE,	-- 订单总金额
	orderStatus INT DEFAULT 0	-- 订单状态：0，未结账；1，已结账
);

-- 5.订单明细表
CREATE TABLE ordersDetail(
	id INT PRIMARY KEY AUTO_INCREMENT,
	orders_id INT,	-- 订单表主键（外键）
	food_id INT,	-- 菜品种表主键（外键）
	foodCount INT 	-- 菜数量
);

-- 菜品与菜类别的关系约束
ALTER TABLE food ADD CONSTRAINT fk_food_foodTypeId FOREIGN KEY(foodType_id) REFERENCES foodType(id);

-- 订单表与餐桌表的关系
ALTER TABLE orders ADD CONSTRAINT fk_orders_tableId FOREIGN KEY(table_id) REFERENCES diningTable(id);

-- 订单明细表与订单表的关系
ALTER TABLE ordersDetail ADD CONSTRAINT fk_ordersDetail_ordersId FOREIGN KEY(orders_id) REFERENCES orders(id);

-- 订单明细与菜信息表的关系
ALTER TABLE ordersDetail ADD CONSTRAINT fk_ordersDetail_foodId FOREIGN KEY(food_id) REFERENCES food(id);