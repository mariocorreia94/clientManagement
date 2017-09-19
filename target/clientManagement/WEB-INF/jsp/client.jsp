<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Gestão de Clientes</title>
    <link rel="stylesheet" type="text/css" href="resources/main.css"/>
    <link rel="shortcut icon" type="image/png" href="resources/images/favicon.png"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<td class="text-center">
<div class="container">
    <form:form modelAttribute="createClient" action="create">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-bordered table-hover" id="tab_logic">
                    <thead>
                    <tr>
                        <th class="text-center">
                            Name
                        </th>
                        <th class="text-center">
                            NIF
                        </th>
                        <th class="text-center">
                            Morada
                        </th>
                        <th class="text-center">
                            Telefone
                        </th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr id='addr0'>
                        <td>
                            <form:input type="text" path="name" class="form-control" placeholder="Nome"/>
                            <form:errors path="name" style="color:red"/>
                        </td>
                        <td>

                            <c:if test="${createClient.name != null}">
                                <form:input type="text" path="nif" class="form-control" placeholder="${createClient.nif}" disabled="true"/>
                            </c:if>
                            <c:if test="${createClient.name == null}">
                                <form:input type="text" path="nif" class="form-control" placeholder="NIF"/>
                            </c:if>
                            <form:errors path="nif" style="color:red"/>
                        </td>
                        <td>
                            <form:input type="text" path="adress" class="form-control" placeholder="Morada"/>
                            <form:errors path="adress" style="color:red"/>
                        </td>
                        <td>
                            <form:input type="text" path="phone" class="form-control" placeholder="Telefone"/>
                            <form:errors path="phone" style="color:red"/>
                        </td>
                    </tr>
                    <tr id='addr1'></tr>
                    </tbody>
                </table>
            </div>
        </div>
        <c:if test="${createClient.name != null}">
            <form:button type="submit" method="PUT" formaction="updateClient/${createClient.nif}" class="btn btn-default pull-left">Editar Cliente</form:button></c:if>
        <c:if test="${createClient.name == null}">
            <form:button type="submit" method="POST" formaction="create" class="btn btn-default pull-left">Adicionar Cliente</form:button></c:if>
    <div style="color:red">${error}</div>
    </form:form>
</div>

<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
        <table class="table table-striped custab">
            <thead>
            <tr>
                <th>Nome</th>
                <th>NIF</th>
                <th>Morada</th>
                <th>Telefone</th>
                <th class="text-center">Editar</th>
                <th class="text-center">Remover</th>
            </tr>
            </thead>
            <c:if test="${not empty clients}">
                <c:forEach var="client" items="${clients}">
                    <tr>
                        <td>${client.name}</td>
                        <td>${client.nif}</td>
                        <td>${client.adress}</td>
                        <td>${client.phone}</td>
                        <td class="text-center">
                            <a href="getClient/${client.nif}" class="btn btn-primary btn-xs"><span
                                    class="glyphicon glyphicon-edit"></span> Editar</a></td>
                        <td class="text-center">
                            <a href="remove/${client.nif}" class="btn btn-danger btn-xs"><span
                                    class="glyphicon glyphicon-remove"></span> Apagar</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>
</div>
</body>
</html>