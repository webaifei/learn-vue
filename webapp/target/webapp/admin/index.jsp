<%--
  Created by IntelliJ IDEA.
  User: ngnice
  Date: 2018/11/10
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false" %>
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
                            <input
                                    id="todo-title"
                                    name="title"
                                    type="text" class="col-sm-9" id="exampleInputEmail1" placeholder="input todo item">
                            <a class="btn btn-link-2 col-sm-2" id="btn">add it</a>
                        </div>

                        <table class="table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Item</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${todos}" var="todo" varStatus="idx">
                                <tr>
                                    <th scope="row">${idx.index}</th>
                                    <td>${todo.title}</td>
                                    <td>
                                        <button type="button" class="btn btn-default">完成</button>
                                    </td>
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
<script src="./admin/assets/jquery-1.11.1.min.js"></script>
<script>
    window.addEventListener("load", function () {
        var $btn = $('#btn');
        var $todoTitle = $('#todo-title');
        var $tbody = $('.table tbody');

        // 添加todo
        $btn.on("click", function () {
            var title = $todoTitle.val();
            if (title && title.replace(/^\s+|\s+$/, '').length > 0) {
                $.ajax({
                    url: "/addTodo",
                    type: "post",
                    // contentType: "application/json",
                    data: {
                        title: title,
                    },
                    success: function (res) {
                        var data = res.data || {};
                        var index = $tbody.find("tr").length+1;
                        if (res.code === 1) {
                            var row = '<tr>' +
                                '<th scope="row">'+index+'</th>' +
                                '<td>'+data.title+'</td>' +
                                '<td><button type="button" class="btn btn-default">完成</button></td>' +
                                '</tr>';

                        }
                        $tbody.append(row);
                    },
                    error: function (err) {
                        console.log(err);
                    }
                })
            }
        });
        /*完成当前项  从列表中删除*/
        $tbody.on('click', '.btn', function (e) {
            var tr = $(this).parents('tr');
            var trIndex = tr.index();
            var title = tr.find('td').eq(0).text();
            $.ajax({
                url: "/removeTodo",
                type: "post",
                // contentType: "application/json",
                data: {
                    title: title,
                },
                success: function (res) {
                    var data = res.data || {};
                    if (res.code === 1) {
                        tr.remove();
                        $tbody.find('tr').each(function (i,tr) {
                            console.log(tr);
                            $(tr).find('th').eq(0).text(i);
                        })
                    }
                },
                error: function (err) {
                    console.log(err);
                }
            })
        })


    });
</script>


<%@include file="common/footer.jsp" %>