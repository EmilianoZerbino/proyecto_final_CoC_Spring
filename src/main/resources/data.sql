INSERT INTO  `aerolineas` (`nombre`)
                VALUES
                          ('Aerolineas Argentinas'),
                          ('Iberia Airlines'),
                          ('FlyBondi'),
                          ('Latam Airlines'),
                          ('Jetsmart');


INSERT INTO  `vuelos` (`numero_vuelo`,`lugar_partida`,`lugar_llegada`,`horario_partida`,`horario_llegada`,`conexion`,`aerolinea_id`)
                VALUES
                        ('ARG001','Aeroparque','Cordoba','2025-12-12T12:00:00','2025-12-12T12:00:00',1,1),
                        ('ARG002','Aeroparque','Bariloche','2025-12-12T12:00:00','2025-12-12T12:00:00',3,1),
                        ('ARG003','Aeroparque','Mendoza','2025-12-12T12:00:00','2025-12-12T12:00:00',null,1),
                        ('ARG004','Ezeiza','Santiago de Chile','2025-12-12T12:00:00','2025-12-12T12:00:00',5,1),
                        ('ARG005','Ezeiza','Mexico DF','2025-12-12T12:00:00','2025-12-12T12:00:00',null,1);



INSERT INTO  `ASIENTO` (`numero_asiento`,`categoria`,`es_ventanilla`,`precio`,`esta_disponible`,`vuelo_id`)
                VALUES
                        (1,'Comun',true,123.0,true,1),
                        (1,'Comun',true,123.0,true,1),
                        (1,'Comun',true,123.0,true,1),
                        (1,'Comun',true,123.0,true,1),
                        (1,'Comun',true,123.0,true,1);

INSERT INTO  `CLIENTE` (`nombre`,`apellido`,`dni`,`fech_nac`,`direccion`,`telefono`,`email`)
                VALUES
                        ('Juan','Suarez','11111111','2000-12-12','Av. Libertador 123','111541234567','juansuarez@gmail.com'),
                        ('Jose','Perez','22222222','2000-12-12','Av. Libertador 123','111541234567','joseperez@gmail.com'),
                        ('Mario','Hernandez','33333333','2000-12-12','Av. Libertador 123','111541234567','mariohernandez@gmail.com'),
                        ('Maria','Pia','44444444','2000-12-12','Av. Libertador 123','111541234567','mariapia@gmail.com'),
                        ('Luisa','Lein','55555555','2000-12-12','Av. Libertador 123','111541234567','luisalein@gmail.com');

INSERT INTO  `reserva` (`fecha_venta`,`forma_pago`,`estado`,`asiento_id`,`cliente_id`)
                VALUES
                        ('2025-12-12','efectivo','Espera',1,1),
                        ('2025-12-12','efectivo','Espera',2,1),
                        ('2025-12-12','efectivo','Espera',3,1),
                        ('2025-12-12','efectivo','Espera',4,1),
                        ('2025-12-12','efectivo','Espera',5,1);

