DELIMITER //
CREATE PROCEDURE `insert_libro`(
	 IN p_titulo varchar(512)
	,IN p_tipo_recurso_id int
    ,IN p_edicion varchar(128)
    ,IN p_editorial_id int
    ,IN p_autores varchar(1024)
    ,IN p_isbn varchar(256)
    ,IN p_activo bit(1)
)
BEGIN
	INSERT INTO libros 
			(titulo, tipo_recurso_id, edicion, editorial_id, autores, isbn, activo)
		VALUES 
			(p_titulo, p_tipo_recurso_id, p_edicion, p_editorial_id, p_autores, p_isbn, p_activo);
	SELECT last_insert_id() id;
END //