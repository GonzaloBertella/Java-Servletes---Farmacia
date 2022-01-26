<%-- 
    Document   : ListadoDetallesFacturas
    Created on : 31/10/2021, 20:47:13
    Author     : gonza
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link  rel="stylesheet" href="CSS/cssGeneral.css" type="text/css">
        <link  rel="stylesheet" href="CSS/cssFormulario.css" type="text/css">
        <style>
            body{
                background: url("https://statics-diariomedico.uecdn.es/cms/2019/01/gasto_medicamentos_1601.jpg") no-repeat fixed center;
            }
        </style>
        <title>Listado de Detalles por Facturas</title>
    </head>

    <body>

        <!-- Navegador -->
        <section>
            <nav id="menu" class="navbar navbar-expand-lg navbar-light fixed-top bg-prima ">
                <a class="navbar-brand" href="#">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9SQaG6pRpgaXM3GCHZPc_ihNFVRpei0Iy_g&usqp=CAU"
                         width="70" height="50" alt="Logo">
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link " href="Home.jsp" style="text-shadow: 1px 1px 1px black;">Inicio <span
                                    class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false" style="text-shadow: 1px 1px 1px black;">
                                Registros
                            </a>
                            <div class="dropdown-menu bg-prima" aria-labelledby="navbarDropdown" style="background-color: ">
                                <!-- Referencia FORMULARIO -->
                                <a class="dropdown-item" href="Alta_Factura"  >Alta de Factura</a>
                                <a class="dropdown-item" href="Alta_Producto"  >Alta de Producto </a>
                                <a class="dropdown-item" href="Alta_Proveedor"  >Alta de Proveedor</a>
                                <a class="dropdown-item" href="Alta_Empleado"  >Alta de Empleado</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false" style="text-shadow: 1px 1px 1px black;">
                                Listados
                            </a>
                            <div class="dropdown-menu bg-prima" aria-labelledby="navbarDropdown">
                                <!-- Referencia FORMULARIO -->
                                <a class="dropdown-item" href="ListadoClientes"  >Listado de Clientes</a>
                                <a class="dropdown-item" href="ListadoEmpleados"  >Listado de Empleados</a>
                                <a class="dropdown-item" href="ListadoFacturas"  >Listado de Facturas (Reporte 4)</a>
                                <a class="dropdown-item" href="ListadoProductos"  >Listado de Productos</a>
                                <a class="dropdown-item" href="ListadoProveedores"  >Listado de Proveedores</a>

                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false" style="text-shadow: 1px 1px 1px black;">
                                Reportes
                            </a>
                            <div class="dropdown-menu bg-prima" aria-labelledby="navbarDropdown">
                                <!-- Referencia FORMULARIO -->
                                <a class="dropdown-item" href="ListadoReporte1.jsp"  >Reporte 1</a>
                                <a class="dropdown-item" href="ListadoReporte2"  >Reporte 2</a>
                                <a class="dropdown-item" href="ListadoReporte3.jsp"  >Reporte 3</a>
                                <a class="dropdown-item" href="ListadoFacturas"  >Reporte 4</a>
                                <a class="dropdown-item" href="ListadoReporte5"  >Reporte 5</a>
                                <a class="dropdown-item" href="ListadoReporte6"  >Reporte 6</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </section>


        <div class="container-fluid col-sm-12  ">
            <h1>Listado de Detalles por Factura</h1>
        </div>

        <form class="container pt-4" id="formulario" style ="margin-bottom:100px  ; text-align: center " > 
            <table class="table table-hover">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Codigo Detalle</th>
                            <th>Producto</th>
                            <th>Cantidad</th>
                            <th>Precio Unitario</th>
                            <th>Tipo de Pago</th>
                            <th>Importe Total</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.lst}" var="c">
                            <tr>
                                <td>${c.cod_detalleVenta}</td>
                                <td>${c.producto}</td>
                                <td>${c.cantidad}</td>
                                <td>${c.precio_unitario}</td>
                                <td>${c.tipoPago}</td>
                                <td>${c.importeTotal}</td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
        </form>


        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="./js/js/validaciones.js"></script>


    </body>
</html>
