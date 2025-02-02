INSERT INTO estudiantes (nombre, edad) VALUES
('Pablo', 20),
('María', 22),
('Carlos', 21),
('Ana', 19),
('Luis', 24);

INSERT INTO cursos(nombre, duracion) VALUES
('Matemáticas', 30),
('Lenguaje', 20),
('Programación', 40),
('Historia', 25);

INSERT INTO inscripciones (id_estudiante, id_curso) VALUES
(1, 1),
(1, 3),
(2, 2),
(2, 4),
(3, 1),
(3, 4),
(4, 3),
(4, 2);

SELECT estudiantes.nombre AS Estudiante , cursos.nombre AS Curso
FROM estudiantes
JOIN inscripciones ON estudiantes.id = inscripciones.id_estudiante
JOIN cursos ON inscripciones.id_curso = cursos.id
ORDER BY estudiantes.id;

SELECT estudiantes.nombre AS Estudiante
FROM estudiantes
JOIN inscripciones ON estudiantes.id = inscripciones.id_estudiante
JOIN cursos ON inscripciones.id_curso = cursos.id
WHERE cursos.nombre = 'Programación';

SELECT cursos.nombre AS Cursos
FROM cursos
JOIN inscripciones ON cursos.id = inscripciones.id_curso
JOIN estudiantes ON inscripciones.id_estudiante = estudiantes.id
WHERE estudiantes.nombre = "Pablo";

SELECT cursos.nombre AS Curso, COUNT(inscripciones.id_estudiante) AS Cantidad_de_estudiantes
FROM cursos
LEFT JOIN inscripciones ON cursos.id = inscripciones.id_curso
GROUP BY cursos.nombre;

SELECT estudiantes.nombre AS Estudiante
FROM estudiantes
LEFT JOIN inscripciones ON estudiantes.id = inscripciones.id_estudiante
WHERE inscripciones.id_curso IS NULL;

