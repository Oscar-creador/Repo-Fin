DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_libInventario`(IN p_id INT, IN p_libro_id INT, IN p_estado VARCHAR(45), IN p_disp BIT(1))
BEGIN
	UPDATE libros_inventario
    SET libro_id = p_libro_id, estado = p_estado, disponible = p_disp
    WHERE id = p_id;
END //