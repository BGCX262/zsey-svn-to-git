ALTER TABLE `ducrm`.`base_linkman` DROP COLUMN `postcode`,
 DROP COLUMN `sex`,
 DROP COLUMN `address`,
 DROP COLUMN `fk_city_id`,
 DROP COLUMN `fk_province_id`
, DROP INDEX `FK2FC487B2D1CC81EA`
, DROP INDEX `FK2FC487B2C4FCD8CF`,
 DROP FOREIGN KEY `FK2FC487B2C4FCD8CF`,
 DROP FOREIGN KEY `FK2FC487B2D1CC81EA`;
 
 drop table `ducrm`.`xm_buy_price_list`;
drop table `ducrm`.`xm_buy_price`;
drop table `ducrm`.`xm_buy_order_list`;
drop table `ducrm`.`xm_buy_order`;