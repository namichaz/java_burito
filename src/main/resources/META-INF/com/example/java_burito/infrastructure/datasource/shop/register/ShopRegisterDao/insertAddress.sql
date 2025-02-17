INSERT INTO stage.address 
(
	shop_id,
	prefecture,
	city,
	street,
	location
	)
VALUES
(
	(SELECT s.shop_id FROM stage.shops s WHERE shop_name = /*shopName*/'shopName'),
	/*prefecture*/'prefecture',
	/*city*/'city',
	/*street*/'street',
	ST_SetSRID(ST_MakePoint(/*longitude*/0, /*latitude*/0), 4326)
)