INSERT INTO stage.shops_menu
(shop_id,menu_id,show_flg)
VALUES
((SELECT s.shop_id FROM stage.shops s WHERE shop_name = /*shopName*/'shopName'),/*menuId*/0,/*showFlg*/'showFlg');
