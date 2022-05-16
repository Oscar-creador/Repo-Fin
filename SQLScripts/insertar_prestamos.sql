DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_prestamos`(IN p_inv_id INT, IN p_alu_id INT, IN p_fecha_pres DATETIME, IN p_fecha_devu DATETIME, IN p_fecha_debedevolver DATETIME, IN p_disp BIT(1))
BEGIN
	INSERT INTO prestamos(libro_inventario_id, alumno_id, fecha_prestamo, fecha_devuelto, fecha_debe_devolver, disponible)
    VALUES(p_inv_id, p_alu_id, p_fecha_pres, p_fecha_devu, p_fecha_debedevolver, p_disp);
    SELECT last_insert_id() id;
END//
