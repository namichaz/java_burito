SELECT                         
    s.shop_id,
    s.shop_name,
    a.prefecture,
    a.city,
    a.street,
    ST_X(a.location) AS longitude,
    ST_Y(a.location) AS latitude,
    STRING_AGG(m.menu_name, ',') AS menu_list
FROM stage.shops s
INNER JOIN stage.address a ON s.shop_id = a.shop_id
INNER JOIN stage.shops_menu sm ON s.shop_id = sm.shop_id
INNER JOIN stage.mst_menu m ON sm.menu_id = m.menu_id
WHERE sm.show_flg IS TRUE
GROUP BY s.shop_id, s.shop_name, a.prefecture, a.city, a.street, a.location
ORDER BY s.shop_name ASC;
