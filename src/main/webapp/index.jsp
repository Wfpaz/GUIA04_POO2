<%-- 
    Document   : index
    Created on : 08-26-2017, 10:24:22 AM
    Author     : walte
--%>

<%@page import="com.sv.udb.controladores.CtrlTipos"%>
<%@page import="com.sv.udb.modelos.Tipos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <h4>Guía 04 - POO2</h4>
                    <form method="POST" action="TiposServ">
                        <input type="hidden" id="codi" name="codi" value="${codi}"/>
                        <div class="form-group">
                            <label for="nomb" class="contro-label">Nombre:</label>
                            <div class="input-group">
                                <span class="input-group-addon"> 1 </span>
                                <input class="form-control" id="nomb" name="nomb" value="${nomb}"/>
                            </div>
                        </div>
                        <input type="submit" name="TipoBton" value="Guardar" class="btn btn-sm btn-success" />
                        <input type="submit" name="TipoBton" value="Modificar" class="btn btn-sm btn-info" />
                    </form>
                    <br/>
                    <form action="TiposServ" method="POST" name="Demo">
                        <table border="1" class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Tipo</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%
                                    for (Tipos temp : new CtrlTipos().cons()) {
                                %>

                                <tr>
                                    <td><input type="radio" name="codi" value="<%=temp.getCodiTipo()%>"></td>
                                    <td><%=temp.getNombTipo()%></td>
                                </tr>
                                <% } %>
                            </tbody>
                        </table>
                        <br/>
                        <input type="submit" name="TipoBton" value="Consultar" class="btn btn-sm btn-info" />
                        <input type="submit" name="TipoBton" value="Eliminar" class="btn btn-sm btn-danger" />
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>