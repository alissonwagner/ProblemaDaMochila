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
        <link rel="icon" href="../../favicon.ico">

        <title>Problema da mochila</title>

        <!-- Bootstrap core CSS -->
        <link href="/ProblemaDaMochila/resources/css/bootstrap.css" rel="stylesheet">
        <link href="/ProblemaDaMochila/resources/css/dashboard.css" rel="stylesheet">

        <style type="text/css">
            .form-group{
                padding: 10px;
            }
            
            .mochila {
                width: 400px;
                height: 400px;
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
                    <a class="navbar-brand" href="/">Algoritmos genéticos</a>
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
                                <form:button type="submit" class="btn btn-success btn-lg btn-block">Start!</form:button>>
                            </li>
                        </ul>
                    </div>
                </form:form>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Problema da mochila</h1>

                    <div class="row placeholders">
                        <img src="/ProblemaDaMochila/resources/images/mochila.png" class="mochila"/>
                    </div>

                    <h2 class="sub-header">Section title</h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Header</th>
                                    <th>Header</th>
                                    <th>Header</th>
                                    <th>Header</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1,001</td>
                                    <td>Lorem</td>
                                    <td>ipsum</td>
                                    <td>dolor</td>
                                    <td>sit</td>
                                </tr>
                                <tr>
                                    <td>1,002</td>
                                    <td>amet</td>
                                    <td>consectetur</td>
                                    <td>adipiscing</td>
                                    <td>elit</td>
                                </tr>
                                <tr>
                                    <td>1,003</td>
                                    <td>Integer</td>
                                    <td>nec</td>
                                    <td>odio</td>
                                    <td>Praesent</td>
                                </tr>
                                <tr>
                                    <td>1,003</td>
                                    <td>libero</td>
                                    <td>Sed</td>
                                    <td>cursus</td>
                                    <td>ante</td>
                                </tr>
                                <tr>
                                    <td>1,004</td>
                                    <td>dapibus</td>
                                    <td>diam</td>
                                    <td>Sed</td>
                                    <td>nisi</td>
                                </tr>
                                <tr>
                                    <td>1,005</td>
                                    <td>Nulla</td>
                                    <td>quis</td>
                                    <td>sem</td>
                                    <td>at</td>
                                </tr>
                                <tr>
                                    <td>1,006</td>
                                    <td>nibh</td>
                                    <td>elementum</td>
                                    <td>imperdiet</td>
                                    <td>Duis</td>
                                </tr>
                                <tr>
                                    <td>1,007</td>
                                    <td>sagittis</td>
                                    <td>ipsum</td>
                                    <td>Praesent</td>
                                    <td>mauris</td>
                                </tr>
                                <tr>
                                    <td>1,008</td>
                                    <td>Fusce</td>
                                    <td>nec</td>
                                    <td>tellus</td>
                                    <td>sed</td>
                                </tr>
                                <tr>
                                    <td>1,009</td>
                                    <td>augue</td>
                                    <td>semper</td>
                                    <td>porta</td>
                                    <td>Mauris</td>
                                </tr>
                                <tr>
                                    <td>1,010</td>
                                    <td>massa</td>
                                    <td>Vestibulum</td>
                                    <td>lacinia</td>
                                    <td>arcu</td>
                                </tr>
                                <tr>
                                    <td>1,011</td>
                                    <td>eget</td>
                                    <td>nulla</td>
                                    <td>Class</td>
                                    <td>aptent</td>
                                </tr>
                                <tr>
                                    <td>1,012</td>
                                    <td>taciti</td>
                                    <td>sociosqu</td>
                                    <td>ad</td>
                                    <td>litora</td>
                                </tr>
                                <tr>
                                    <td>1,013</td>
                                    <td>torquent</td>
                                    <td>per</td>
                                    <td>conubia</td>
                                    <td>nostra</td>
                                </tr>
                                <tr>
                                    <td>1,014</td>
                                    <td>per</td>
                                    <td>inceptos</td>
                                    <td>himenaeos</td>
                                    <td>Curabitur</td>
                                </tr>
                                <tr>
                                    <td>1,015</td>
                                    <td>sodales</td>
                                    <td>ligula</td>
                                    <td>in</td>
                                    <td>libero</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <script src="/ProblemaDaMochila/resources/js/jquery.min.js"></script>
        <script src="/ProblemaDaMochila/resources/js/bootstrap.js"></script>
    </body>
</html>
