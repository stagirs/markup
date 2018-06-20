<%-- 
    Document   : main
    Created on : 06.11.2017, 19:54:19
    Author     : Dmitriy Malakhov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="app">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="static/style.css">
        <script src="https://code.angularjs.org/1.5.8/angular.min.js"></script>
        <script src="https://code.angularjs.org/1.5.8/angular-animate.min.js"></script>
        <script src="https://code.angularjs.org/1.5.8/angular-aria.min.js"></script>
        <script src="https://code.angularjs.org/1.5.8/angular-loader.min.js"></script>
        <script>
            angular.module('app', []).controller('MainCtrl', 
                function($scope, $http, $interval) {
                    
                }
             );
        </script>
    </head>
    <body ng-controller="MainCtrl">
        <div class="header">
            STAGIRS MARKUP: РАЗМЕТКА ТЕКСТОВ (Морфологическая, Семантическая)
        </div>
        
    </body>
</html>
