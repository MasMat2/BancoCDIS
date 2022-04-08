ALTER TABLE Clientes ALTER COLUMN Cuenta BIGINT NULL;

INSERT INTO Clientes(id, nombre, apellido, email, numero_telefonico) VALUES(1, 'John', 'Doe', 'johndoe@mail.com', '8118977915');
INSERT INTO Clientes(id, nombre, apellido, email, numero_telefonico) VALUES(2, 'Jane', 'Smith', 'janesmith@mail.com', '7218977915');
INSERT INTO Clientes(id, nombre, apellido, email, numero_telefonico) VALUES(3, 'Jack', 'Bayrde', 'jackbyrde@mail.com', '6318977915');


INSERT INTO Cuentas(id, dia_creacion, saldo_actual, cliente) VALUES(1, '2022-01-04', 100, 1);
INSERT INTO Cuentas(id, dia_creacion, saldo_actual, cliente) VALUES(2, '2022-02-04', 200, 2);
INSERT INTO Cuentas(id, dia_creacion, saldo_actual, cliente) VALUES(3, '2022-01-04', 300, 3);

INSERT INTO Bancos(id, nombre, ubicacion) VALUES(1, 'Santander', 'Spain');
INSERT INTO Bancos(id, nombre, ubicacion) VALUES(2, 'BBVA', 'Mexico');
INSERT INTO Bancos(id, nombre, ubicacion) VALUES(3, 'Bank of America', 'EU');


INSERT INTO Tarjetas(id, icv, numero_tarjeta, tipo_tarjeta, cuenta) VALUES(1, '345', '1111222233334444', 'deposito', 1);
INSERT INTO Tarjetas(id, icv, numero_tarjeta, tipo_tarjeta, cuenta) VALUES(2, '345', '2222333344445555', 'credito', 2);
INSERT INTO Tarjetas(id, icv, numero_tarjeta, tipo_tarjeta, cuenta) VALUES(3, '345', '3333444455556666', 'deposito', 3);


INSERT INTO Empleados(id, nombre, apellido, puesto, dia_ingreso, banco) VALUES(1, 'Jim', 'Halpert', 'contador', '2021-05-05', 1);
INSERT INTO Empleados(id, nombre, apellido, puesto, dia_ingreso, banco) VALUES(2, 'Pam', 'Beesly', 'recepcionista', '2021-06-05', 2);
INSERT INTO Empleados(id, nombre, apellido, puesto, dia_ingreso, banco) VALUES(3, 'Michale', 'Scott', 'gerente', '2021-07-05', 3);

UPDATE Clientes SET cuenta=1 WHERE id=1;
UPDATE Clientes SET cuenta=2 WHERE id=2;
UPDATE Clientes SET cuenta=3 WHERE id=3;