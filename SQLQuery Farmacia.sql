
--CREACION BASE DE DATOS


create database FarmaciaLab4
USE FarmaciaLab4
--CREACION DE TABLAS


Create Table Provincias (
cod_provincia int  NOT NULL IDENTITY,
	nombre_provincia nvarchar (50) NULL ,
	CONSTRAINT PK_provincias PRIMARY KEY (cod_provincia)
)

Create Table Localidades(
cod_localidad int  NOT NULL IDENTITY,
	nombre_localidad nvarchar (50) NULL ,
	cod_provincia int not null,
	CONSTRAINT PK_localidades PRIMARY KEY (cod_localidad),
	Constraint FK_localidades_provincias Foreign key (cod_provincia) 
	references Provincias (cod_provincia)
)

Create Table Barrios (
cod_barrio int  NOT NULL IDENTITY,
	barrio nvarchar (50) NULL ,
	cod_localidad int not null,
	CONSTRAINT PK_barrios PRIMARY KEY (cod_barrio),
	Constraint FK_barrios_localidades Foreign key (cod_localidad) 
	references Localidades (cod_localidad)
)


CREATE table Clientes
(
cod_cli int primary key NOT NULL IDENTITY,
nom_cli varchar(40)not null,
dir_cli varchar(40) null,
cod_barrio int not null,
DNI INT NULL,
Telefono varchar(50) null,
Constraint FK_clientes_barrios Foreign key (cod_barrio) 
	references Barrios (cod_barrio)
)

create table TipoPagos(
cod_tipoPago int primary key NOT NULL IDENTITY,
nom_form_pago nvarchar(50) null,
)

Create table Sucursales
(
cod_sucursal int primary key not null identity,
nom_sucusal nvarchar(50) not null,
direccion nvarchar(50) not null,
telefono nvarchar(50) not null,
cod_barrio int not null,
Constraint FK_sucursales_barrios Foreign key (cod_barrio) 
	references Barrios (cod_barrio)
)

create table Facturas
(
cod_venta int primary key NOT NULL IDENTITY,
fecha date not null,
cod_cli int not null,
cod_emp int not null,
cod_sucursal int not null,
Constraint FK_facturas_fucursales Foreign key (cod_sucursal) 
	references Sucursales (cod_sucursal)
)


create table Marcas
(
cod_marca int primary key NOT NULL IDENTITY,
descripcion nvarchar(40)not null
)

create table Categorias
(
cod_categoria int primary key NOT NULL IDENTITY,
descripcion nvarchar(40)not null
)



create table Productos
(
cod_pro int primary key NOT NULL IDENTITY,
descripcion nvarchar(50)not null,
pre_compra decimal(10,2) not null,
fecha_venc date not null,
cod_marca int not null,
cod_prov int not null,
cod_categoria int not null,
venta_libre bit default 1 ,
stock int not null,
cod_sucursal int not null,
Constraint FK_productos_sucursales Foreign key (cod_sucursal) 
	references Sucursales (cod_sucursal)
)

create table Empleados
(
cod_emp int primary key NOT NULL IDENTITY,
nom_emp varchar(40)not null,
dir_emp varchar(40)null,
cod_barrio int not null,
cargo varchar(40) not null,
edad varchar(2)null,
tel varchar(50) null,
Constraint FK_empleados_barrios Foreign key (cod_barrio) 
	references Barrios (cod_barrio)
)

create table DetalleFacturas
(
cod_detalleVenta int primary key NOT NULL IDENTITY,
cod_venta int not null,
cod_pro int not null,
cantidad decimal(10,2)null,
precio_unitario float,
cod_tipoPago int not null,
importeTotal float
Constraint FK_DetalleFacturas_TipoPagos Foreign key (cod_tipoPago) 
	references TipoPagos (cod_tipoPago),
Constraint FK_DetalleFacturas_Facturas Foreign key (cod_venta) 
	references Facturas (cod_venta)
)


create table Proveedores
(
cod_prov int primary key NOT NULL IDENTITY,
nom_prov varchar(40)not null,
dir_prov varchar(50)null,
cod_barrio int not null,
telefono varchar(50)null,
Constraint FK_proveedores_barrios Foreign key (cod_barrio) 
	references Barrios (cod_barrio)
)



--RESTRICCIONES CLAVES SECUNDARIAS


alter table Productos
add constraint fk_cod_categoria
foreign key(cod_categoria)
references Categorias(cod_categoria)

alter table Productos
add constraint fk_cod_marca
foreign key(cod_marca)
references Marcas(cod_marca)

alter table Facturas
add constraint fk_cod_enpL
foreign key (cod_emp)
references Empleados(cod_emp)

alter table Facturas
add constraint fk_cod_clis
foreign key(cod_cli)
references Clientes(cod_cli)

alter table DetalleFacturas
add constraint fk_cod_pro
foreign key (cod_pro)
references Productos(cod_pro)


alter table Facturas
add constraint fk_cod_empl
foreign key (cod_emp)
references Empleados(cod_emp)

alter table Productos
add constraint fk_cod_prove
foreign key(cod_prov)
references Proveedores(cod_prov)





