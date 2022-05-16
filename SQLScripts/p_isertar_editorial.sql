CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_editorial`(IN p_nombre VARCHAR(256), IN p_pais VARCHAR(45), IN p_email VARCHAR(45), IN p_activo BIT(1))
BEGIN
	INSERT INTO editoriales (nombre, pais, email, activo)
    VALUES (p_nombre, p_pais, p_email, p_activo);
END