DELIMITER //
CREATE PROCEDURE `insert_alumno`(
	 IN p_nombre  varchar(256)
    ,IN p_apellidos varchar(256)
    ,IN p_genero varchar(8)
    ,IN p_carrera_id int
    ,IN p_fecha_ingreso date
    ,IN p_fecha_nacimiento date
)
BEGIN
	INSERT INTO alumnos (
			 nombre
            ,apellidos
            ,genero
            ,carrera_id
            ,fecha_ingreso
            ,fecha_nacimiento)
		VALUES (
			p_nombre
            ,p_apellidos
            ,p_genero
            ,p_carrera_id
            ,p_fecha_ingreso
            ,p_fecha_nacimiento);
	SELECT last_insert_id() id;
END //
