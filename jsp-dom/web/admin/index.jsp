<%--
  Created by IntelliJ IDEA.
  User: ngnice
  Date: 2018/11/10
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<%@ include file="./common/header.jsp" %>
<body>

<!-- Top content -->
<div class="top-content" style="position: relative; z-index: 0; background: none;">
    <!-- Top menu -->
    <div class="inner-bg">
        <div class="container">

            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text wow fadeInUp animated"
                     style="visibility: visible; animation-name: fadeInUp;">
                    <h1>stay hungry, stay foolish</h1>

                    <div class="top-big-link">
                        <div class="clearfix" style="margin-bottom: 20px;">
                            <input type="email" class="col-sm-9" id="exampleInputEmail1" placeholder="input todo item">
                            <a class="btn btn-link-2 col-sm-2">add it</a>
                        </div>

                        <table class="table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Item</th>
                                <th>status</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${todos}" var="todo">
                                <tr>
                                    <th scope="row">${todo.id}</th>
                                    <td>${todo.title}</td>
                                    <td>${todo.statusDesc}</td>
                                    <td></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="backstretch"
         style="left: 0px; top: 0px; overflow: hidden; margin: 0px; padding: 0px; height: 1071px; width: 1280px; z-index: -999998; position: absolute;">
        <img src="./admin/assets/1.jpg"
             style="position: absolute; margin: 0px; padding: 0px; border: none; width: 1581.78px; height: 1071px; max-height: none; max-width: none; z-index: -999999; left: -150.892px; top: 0px;">
    </div>
</div>


<%@include file="common/footer.jsp" %>