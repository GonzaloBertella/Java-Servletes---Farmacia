use FarmaciaLab4

insert into Provincias values ('Cordoba')
insert into Provincias values ('Buenos Aires')
insert into Provincias values ('Chubut')
insert into Provincias values ('Santa Fe')
insert into Provincias values ('Tucuman')

insert into Localidades values ('Capital',1)
insert into Localidades values ('Rio Cuarto',1)
insert into Localidades values ('San Francisco',1)
insert into Localidades values ('Lujan',2)
insert into Localidades values ('La Plata',2)
insert into Localidades values ('Tandil',2)
insert into Localidades values ('Esquel',3)
insert into Localidades values ('Trevelin',3)
insert into Localidades values ('Puerto Madryn',3)
insert into Localidades values ('Rosario',4)
insert into Localidades values ('Rafaela',4)
insert into Localidades values ('Quimily',4)
insert into Localidades values ('Yerba Buena',5)
insert into Localidades values ('Tafi del Valle',5)

insert into Barrios values ('Nueva Cordoba', 1)
insert into Barrios values ('Centro', 2)
insert into Barrios values ('America' ,3)
insert into Barrios values ('Abasto' ,4)
insert into Barrios values ('Calchaqui' ,5)

insert into Clientes values ('Carlos', 'Chacabuco 100', 1 , 3534537 ,351231515)
insert into Clientes values ('Maria', 'San Juan 1300', 1 , 34624725 ,35134535)
insert into Clientes values ('Pedro', 'San Martin 500', 2 , 34323725 ,35435535)
insert into Clientes values ('Juana', 'San Fermin 1400', 2 , 33424725 ,354334535)
insert into Clientes values ('Horacio', 'Nuñez 1300', 3 , 32324725 ,3543434535)
insert into Clientes values ('Martin', 'Bs As 1350', 3 , 334234525 ,35756535)
insert into Clientes values ('Ruperto', 'Idependecia 760', 4 , 33624725 ,36734535)
insert into Clientes values ('Juan', 'Rondeau 950', 4 , 23624725 ,327346535)
insert into Clientes values ('Roberto', 'Bv illia 250', 5 , 27694555 ,377776535)

insert into Categorias values ('medicamentos')
insert into Categorias values ('articulo limpieza')
insert into Categorias values ('higiene personal')
insert into Categorias values ('estetica')

insert into Sucursales values ('Norte' , 'Bv.illia 300' ,3512342352 ,1)
insert into Sucursales values ('Sur' , 'Bv. Chacabuco 1200' ,35345235 ,2)
insert into Sucursales values ('Este' , 'Av. Hipolito Yrigoyen 560' ,35456352, 3)
insert into Sucursales values ('Oeste' , 'Av Sabattini 300' ,35445735, 4)
insert into Sucursales values ('Centro' , 'Rondeau 500' ,35445735 , 5)

insert into Empleados values ('Joaquin' , 'bv. peron 50', 1, 'vendedor', 23,35122352)
insert into Empleados values ('Carlos' , 'bv. san juan 150', 1, 'gerente', 33,35133332)
insert into Empleados values ('Hernan' , 'bv. illia 540', 2, 'vendedor', 26,3532422352)
insert into Empleados values ('Juliana' , 'Rondeau 650', 2, 'vendedor', 24,353242756)
insert into Empleados values ('Martina' , 'Bs As 390', 3, 'gerente', 36,35678872)
insert into Empleados values ('Pedro' , 'Parana 360', 3, 'vendedor', 23,356253352)
insert into Empleados values ('Josefina' , 'bv. Ochoa 3150', 4, 'vendedor', 21,35383552)
insert into Empleados values ('Gregorio' , 'Sabatini 150', 5, 'vendedor', 25 ,352366552)


insert into Marcas values ('Bayer')
insert into Marcas values ('Pfizer')
insert into Marcas values ('Roche')
insert into Marcas values ('Avon')
insert into Marcas values ('GSK')
insert into Marcas values ('Rexona')
insert into Marcas values ('Cif')
insert into Marcas values ('Pritt')
insert into Marcas values ('P&G')
insert into Marcas values ('Pampers')


insert into Proveedores values ('Pampers' , 'centro', 1, 351412414)
insert into Proveedores values ('Johnson & Johnson' , 'centro', 2, 3524123333)
insert into Proveedores values ('Medifarma' , 'centro', 3, 353444555)
insert into Proveedores values ('Transfarmaco S.A' , 'centro', 4, 351634636)
insert into Proveedores values ('Disprofarma S.A' , 'centro', 5, 351412414)

set dateformat dmy

insert into Productos values('Bayaspirina' , 100, '10/10/2027' , 1 , 1 , 1 , 1 , 1000 , 1)
insert into Productos values('Ibuprofeno' , 150, '10/10/2027' , 2 , 2 , 1 , 0 ,1000, 1)
insert into Productos values('Alical' , 200, '10/06/2027' , 3 , 3 , 1 , 1 ,1000 , 2)
insert into Productos values('Protector Solar' , 500, '11/07/2030', 4 , 4 , 4 , 1 ,1000 , 2)
insert into Productos values('Sensodyne' , 700, '03/05/2035', 5 , 5, 3 , 0 ,1000 , 3)
insert into Productos values('Desodorante' , 1000, '10/10/2027' , 6 , 1, 3 , 0 ,1000 , 3)
insert into Productos values('Limpiavidrios' , 500, '12/04/2023' , 7 , 5, 2 , 1 ,1000 , 4)
insert into Productos values('Raid' , 1500, '12/11/2023', 8 , 2, 2 , 1 ,1000 , 4)
insert into Productos values('Crema Hidratante' , 800, '10/10/2027', 9 , 2, 3 , 0 ,1000 , 5)
insert into Productos values('Pañales' , 500, '03/05/2035', 10 , 2, 3 , 1 ,1000 , 5)
DBCC CHECKIDENT (Productos, RESEED, 0)
select * from Productos


insert into TipoPagos values ('Tarjeta Credito')
insert into TipoPagos values ('Efectivo')

set dateformat dmy
insert into Facturas values ('03/05/2020' , 1 , 1 , 1 )
insert into Facturas values ('23/09/2021' , 2 , 2 , 2)

insert into DetalleFacturas values (2, 1, 2 , 30 , 2 , 54.54)
insert into DetalleFacturas values (2, 2, 5 , 50 , 2 , 227.27)
insert into DetalleFacturas values (1, 4, 3 , 150 , 1 , 562.5)

select * from DetalleFacturas





