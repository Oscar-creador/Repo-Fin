DELIMITER //
CREATE PROCEDURE `update_alumno`(
	 IN p_matricula int
    ,IN p_nombre  varchar(256)
    ,IN p_apellidos varchar(256)
    ,IN p_genero varchar(8)
    ,IN p_carrera_id int
    ,IN p_fecha_ingreso date
    ,IN p_fecha_nacimiento date
)
BEGIN
	UPDATE alumnos 
		SET
			 nombre = p_nombre
            ,apellidos = p_apellidos
            ,genero = p_genero
            ,carrera_id = p_carrera_id
            ,fecha_ingreso = p_fecha_ingreso
            ,fecha_nacimiento = p_fecha_nacimiento
		WHERE matricula = p_matricula;
END //