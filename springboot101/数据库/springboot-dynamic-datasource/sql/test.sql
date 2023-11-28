CREATE TABLE `t_dynamic_datasource_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `source_name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

insert into t_dynamic_datasource_data (source_name) value ('dynamic_datasource_master');

insert into t_dynamic_datasource_data (source_name) value ('dynamic_datasource_slave');
