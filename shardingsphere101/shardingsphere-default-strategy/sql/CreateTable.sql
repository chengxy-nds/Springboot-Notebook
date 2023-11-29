CREATE TABLE t_city_dict (
  id BIGINT, -- 城市ID
  city_name VARCHAR(255) NOT NULL, -- 城市名称
  province_name VARCHAR(255) NOT NULL, -- 省份名称
  country_name VARCHAR(255) NOT NULL, -- 国家名称
  population INT, -- 城市人口数量
  area FLOAT, -- 城市面积
  timezone VARCHAR(255), -- 所属时区
  postal_code VARCHAR(10), -- 邮政编码
  created_date datetime DEFAULT CURRENT_TIMESTAMP,
  updated_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ;


CREATE TABLE t_order_0 (
  order_id INT PRIMARY KEY,
  order_number VARCHAR(20),
  customer_id INT,
  order_date DATE,
  total_amount DECIMAL(10, 2)
);


CREATE TABLE t_order_1 (
  order_id INT PRIMARY KEY,
  order_number VARCHAR(20),
  customer_id INT,
  order_date DATE,
  total_amount DECIMAL(10, 2)
);

CREATE TABLE t_order_2 (
  order_id INT PRIMARY KEY,
  order_number VARCHAR(20),
  customer_id INT,
  order_date DATE,
  total_amount DECIMAL(10, 2)
);

-- 创建 t_order_item 表
CREATE TABLE t_order_item_0 (
  item_id INT PRIMARY KEY,
  order_id INT,
  product_id INT,
  quantity INT,
  unit_price DECIMAL(8, 2)
);

CREATE TABLE t_order_item_1 (
  item_id INT PRIMARY KEY,
  order_id INT,
  product_id INT,
  quantity INT,
  unit_price DECIMAL(8, 2)
);

CREATE TABLE t_order_item_2 (
  item_id INT PRIMARY KEY,
  order_id INT,
  product_id INT,
  quantity INT,
  unit_price DECIMAL(8, 2)
);


