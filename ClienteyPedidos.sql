INSERT INTO clientes(nombre,direccion,telefono) VALUES
("Alexis","pasaje Via Lactea","9034518"),
("pedro","Los lagos","90209518"),
("Juan","Los conquistadores","20203418"),
("Diego","concecpcion calle 200","40209312"),
("Joselito","Guadalajara","80409538");

INSERT INTO pedidos(cliente_id,fecha,total) VALUES 
(1, '2023-01-15', 15000),
(1, '2023-01-20', 20000),
(2, '2023-01-18', 9000),
(3, '2023-01-22', 120000),
(4, '2023-01-17', 180000),
(5, '2023-01-19', 60000),
(1, '2023-01-25', 8000),
(2, '2023-01-24', 7000),
(3, '2023-01-23', 10000),
(4, '2023-01-26', 50000);


SELEcT * FROM clientes;
SELEcT * FROM pedidos WHERE cliente_id = 1;

SELEcT clientes.id AS clientes_id, clientes.nombre , SUM(pedidos.total) AS total_pedidos
FROM clientes
LEFT JOIN pedidos ON clientes.id = pedidos.cliente_id
GROUp BY clientes.id, clientes.nombre;


DELETE FROM clientes WHERE id = 1;
DELETE FROM pedidos WHERE cliente_id = 1;

SELEcT clientes.id AS cliente_id , cliente.nombre, COUNT(pedidos.id) AS numero_pedidos FROM clientes
LEFT JOIN pedidos ON clientes.id = pedidos.cliente_id
GROUp BY clientes.id, clientes.nombre
ORDER BY numero_pedidos DESc
LIMIT 3;

