SELECT shop_id, shop_name, 
       ST_X(location) AS longitude, 
       ST_Y(location) AS latitude
FROM test.shops;