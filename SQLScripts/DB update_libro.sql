DELIMITER //
CREATE PROCEDURE `update_libro`(
	 IN p_id int
    ,IN p_titulo varchar(512)
	,IN p_tipo_recurso_id int
    ,IN p_edicion varchar(128)
    ,IN p_editorial_id int
    ,IN p_autores varchar(1024)
    ,IN p_isbn varchar(256)
    ,IN p_activo bit(1))
BEGIN
	UPDATE libros
		SET
			 titulo = p_titulo
			,tipo_recurso_id = p_tipo_recurso_id
			,edicion = p_edicion
			,editorial_id = p_editorial_id
			,autores = p_autores
			,isbn = p_isbn
			,activo = p_activo
		WHERE id = p_id;

END //
