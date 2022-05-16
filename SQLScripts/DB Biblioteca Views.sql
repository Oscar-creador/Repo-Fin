CREATE VIEW alumnos_v AS
SELECT
		 a.id
		,a.nombre
		,a.apellidos
        ,a.carrera_id
        ,c.nombre carrera_nombre
        ,c.activo carrera_activo
        ,a.fecha_ingreso
        ,a.fecha_nacimiento
        ,a.genero
	FROM
		alumnos a
        INNER JOIN carreras c
			ON a.carrera_id = c.id;

CREATE VIEW libros_v AS
SELECT
		 l.id
		,l.titulo
        ,l.tipo_recurso_id
        ,tr.nombre tipo_recurso_nombre
        ,tr.activo tipo_recurso_activo
        ,l.edicion
        ,l.editorial_id
        ,e.nombre editorial_nombre
        ,e.pais editorial_pais
        ,e.email editorial_emial
        ,e.activo editorial_activo
        ,l.autores
        ,l.isbn
        ,l.activo
	FROM
		libros l
        INNER JOIN tipos_recursos tr
			ON l.tipo_recurso_id = tr.id
		LEFT OUTER JOIN editoriales e
			ON l.editorial_id = e.id;
            
CREATE VIEW libros_inventario_v AS
SELECT
         l.*
        ,li.id inventario_id
        ,li.estado
        ,li.disponible
	FROM
		libros_inventario li
        INNER JOIN libros_v l
			ON li.libro_id = l.id;

CREATE VIEW libros_inventario_existencia_v AS
SELECT
		 l.*
		,(SELECT COUNT(0) FROM libros_inventario li WHERE li.libro_id = l.id)
			cantidad_en_inventario
	FROM libros_v l;

CREATE VIEW prestamos_v AS
SELECT
		 p.id
		,p.libro_inventario_id 
        ,li.id libro_id
        ,li.titulo libro_titulo
        ,li.tipo_recurso_nombre libro_tipo_recurso_nombre
        ,li.edicion libro_edicion
        ,li.editorial_nombre libro_editorial_nombre
        ,li.autores libro_autores
        ,li.isbn libro_isbn
        ,li.estado libro_estado
        ,p.alumno_id 
        ,a.nombre alumno_nombre
        ,a.apellidos alumno_apellidos
        ,a.carrera_nombre alumno_carrera_nombre
        ,p.fecha_prestamo
        ,p.fecha_debe_devolver
        ,p.fecha_devuelto
	FROM
		prestamos p
        INNER JOIN libros_inventario_v li
			ON p.libro_inventario_id = li.inventario_id
		INNER JOIN alumnos_v a
			ON p.alumno_id = a.id
