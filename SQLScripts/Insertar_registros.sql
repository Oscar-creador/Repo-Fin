
INSERT INTO editoriales VALUES(1, 'pingüino', 'México', 'pingüino@gmail.com', 1);
INSERT INTO editoriales VALUES(2, 'zorro', 'México', 'zorro@gmail.com', 1);
SELECT * FROM editoriales;

INSERT INTO tipos_recursos VALUES(1, 'Revista', TRUE);
INSERT INTO tipos_recursos VALUES(2, 'Enciclopedia', TRUE);
SELECT * FROM tipos_recursos;

INSERT INTO libros VALUES(1, 'Como programar en Java', 1, '2009', 1, 'D&D', 'isbn', TRUE);
INSERT INTO libros VALUES(2, 'LINUX enciclopedia', 2, '2010', 2, 'Ocean editorial', 'isbn', TRUE);
SELECT * FROM libros;

INSERT INTO carreras VALUES(2, 'Ingeniería en Manufactura', 1);
SELECT * FROM carreras;

CALL insert_alumno (1930672, 'Oscar', 'Clemente', 'M', 1, SYSDATE(), SYSDATE());
CALL insert_alumno (1930673,'Oscar', 'Gomez', 'M', 1, SYSDATE(), SYSDATE());
SELECT * FROM alumnos;

CALL sp_insertar_libInventario (1, 'D', TRUE);
CALL sp_insertar_libInventario (2, 'D', TRUE);
SELECT * FROM libros_inventario;

CALL insert_prestamos (1, 1930672, SYSDATE(), SYSDATE(), SYSDATE(), TRUE);
CALL insert_prestamos (2, 1930673, SYSDATE(), NULL, SYSDATE(), TRUE);
SELECT * FROM prestamos;


