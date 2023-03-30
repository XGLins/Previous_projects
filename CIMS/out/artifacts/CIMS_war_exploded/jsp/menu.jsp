<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/8/27
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 中间主体 -->
        <div class="col-md-2">
            <div class="collapse navbar-collapse" style="padding: 0;" id="bs-example">
                <ul class="nav nav-pills nav-stacked" id="nav">
                    <li>
                        <a href="LoginServlet.do?action=index">操作首页<span
                                class="glyphicon glyphicon-folder-open pull-right"></span></a>
                    </li>
                    <li>
                        <a href="DepartmentServlet.do?action=show">部门管理<span class="glyphicon glyphicon-equalizer pull-right"></span></a>
                    </li>
                    <li>
                        <a href="UserServlet.do?action=show">成员管理<span class="glyphicon glyphicon-user pull-right"></span></a>
                    </li>
                    <li>
                        <a href="UserServlet.do?action=statistics">成员统计<span
                                class="glyphicon glyphicon-pencil pull-right"></span></a>
                    </li>
                    <li>
                        <a href="EquipmentServlet.do?action=show">设备管理<span
                                class="glyphicon glyphicon-log-out pull-right"></span></a>
                    </li>
                    <li>
                        <a href="LoginServlet.do?action=exit">退出系统<span
                                class="glyphicon glyphicon-log-out pull-right"></span></a>
                    </li>
                </ul>
            </div>
        </div>
