DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_libInventario`(IN p_libro_id INT, IN p_estatus VARCHAR(45), IN p_disp BIT(1))
BEGIN
	INSERT INTO libros_inventario (libro_id, estado, disponible)
    VALUES(p_libro_id, p_estatus, p_disp);
    
    SELECT last_insert_id() id;
END //