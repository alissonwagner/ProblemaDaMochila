<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" href="<c:url value="/resources/images/icone.png"/>">
        <title>Problema da mochila</title>

        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/dashboard.css"/>" rel="stylesheet">

        <style type="text/css">
            .form-group{
                padding: 10px;
            }

            .mochila {
                width: 400px;
                height: 400px;
            }
            
            .mochilaIdeal{
                cursor: pointer;
            }
        </style>

    </head>

    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<c:url value="/"/>">Algoritmos genéticos</a>
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <spring:url var="urlForm" value="/busca"/>
                <form:form action="${urlForm}" method="POST" modelAttribute="form">
                    <div class="col-sm-3 col-md-2 sidebar">
                        <ul class="nav nav-sidebar form-group">
                            <h4>Geral</h4>
                            <li>
                                <label for="populacao">População</label>
                                <form:input type="number" path="populacao" class="form-control" id="populacao" placeholder="População"/>
                            </li>
                            <li>
                                <label for="iteracoes">Iterações</label>
                                <form:input type="number" path="iteracoes" class="form-control" id="iteracoes" placeholder="Iterações"/>
                            </li>
                            <li>
                                <label for="intGer">Int. de geração</label>
                                <form:input type="number" path="intGer" class="form-control" id="intGer" placeholder="Intervalo de geração"/>
                            </li>
                            <li>
                                <label for="txMutacao">Tx. de mutação (%)</label>
                                <form:input type="number" path="txMutacao" class="form-control" id="txMutacao" placeholder="Taxa de mutação (%)"/>
                            </li>
                        </ul>
                        <ul class="nav nav-sidebar form-group">
                            <li>
                                <h4>Mochila</h4>
                            </li>
                            <li>
                                <label for="txAceitacao">Tx. de aceitação (%)</label>
                                <form:input type="number" path="txAceitacao" class="form-control" id="txAceitacao" placeholder="Taxa de aceitação (%)"/>
                            </li>
                            <li>
                                <label for="vlIdeal">Valor ideal</label>
                                <form:input type="number" path="vlIdeal" class="form-control" id="vlIdeal" placeholder="Valor ideal"/>
                            </li>
                            <li>
                                <label for="pesoMaxMochila">Peso máximo</label>
                                <form:input type="number" path="pesoMaxMochila" class="form-control" id="pesoMaxMochila" placeholder="Peso Máximo"/>
                            </li>
                        </ul>
                        <ul class="nav nav-sidebar form-group">
                            <li>
                                <h4>Objetos</h4>
                            </li>
                            <li>
                                <label for="pesoMaxObj">Peso máximo</label>
                                <form:input type="number" path="pesoMaxObj" class="form-control" id="pesoMaxObj" placeholder="Peso máximo"/>
                            </li>
                            <li>
                                <label for="pesoMinObj">Peso mínimo</label>
                                <form:input type="number" path="pesoMinObj" class="form-control" id="pesoMinObj" placeholder="Peso mínimo"/>
                            </li>
                            <li>
                                <label for="vlMaxObj">Valor máximo</label>
                                <form:input type="number" path="vlMaxObj" class="form-control" id="vlMaxObj" placeholder="Valor máximo"/>
                            </li>
                            <li>
                                <label for="vlMinObj">Valor mínimo</label>
                                <form:input type="number" path="vlMinObj" class="form-control" id="vlMinObj" placeholder="Valor mínimo"/>
                            </li>
                        </ul>
                        <ul class="nav nav-sidebar form-group">
                            <li>
                                <form:button type="submit" class="btn btn-success btn-lg btn-block">Start!</form:button>
                                </li>
                            </ul>
                        </div>
                </form:form>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Problema da mochila</h1>

                    <c:if test="${empty resultado}">
                        <div class="row placeholders">
                            <img src="<c:url value="/resources/images/mochila.png"/>" class="mochila"/>
                        </div>
                    </c:if>

                    <c:if test="${not empty resultado}">
                        <h2 class="sub-header">Resultado</h2>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Iteração</th>
                                        <th>Valor</th>
                                        <th>Peso</th>
                                        <th>Fitness</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${resultado}" var="result" varStatus="status">
                                        <tr class="${status.index eq 0 ? 'mochilaIdeal' : ''}">
                                            <td>${result.iteracao}</td>
                                            <td>${result.valor}</td>
                                            <td>${result.peso}</td>
                                            <td>${result.fitness}</td>
                                        </tr>
                                        <c:if test="${status.index eq 0 and not empty result.itens}">
                                            <c:forEach items="${result.itens}" var="item" varStatus="status">
                                                <tr class="itemMochila">
                                                    <td><span class="glyphicon glyphicon-star"></span></td>
                                                    <td>Item:  <b>${status.index + 1}</b></td>
                                                    <td>Valor:  <b>${item.valor}</b></td>
                                                    <td>Peso:  <b>${item.peso}</b></td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>

        <script type="text/javascript">
            $(".mochilaIdeal").on('click', function (){
                var itens = $(".itemMochila");
                
                itens.each(function (i, it){
                   var hasHide = $(it).hasClass('hide');
                   
                   if(hasHide){
                       $(it).removeClass('hide');
                   } else {
                       $(it).addClass('hide');
                   }
                });
            });
        </script>
    </body>
</html>
