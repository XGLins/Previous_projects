<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/8/27
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 顶栏 -->
<div class="container" id="top">
    <div class="row">
        <div class="col-md-12">
            <!--加入导航条标题-->
            <div class="navbar navbar-default" role="navigation">
                　<div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example" aria-expanded="true">
                    <span class="sr-only"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                　 <a href="LoginServlet.do?action=index" class="navbar-brand">社团成员信息管理系统</a>
                　</div>
                <form action="#" class="navbar-form navbar-right" role="search">
                    <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1"
                                data-toggle="dropdown" style="margin-right: 20px; ">
                            <span class="glyphicon glyphicon-user">${currentUser.uname}</span>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                            <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="javascript:void(0)">
                                    <span class="glyphicon glyphicon-cog pull-right"></span> 修改个人信息
                                </a>
                            </li>
                            <li role="presentation" class="divider"></li>
                            <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="javascript:void(0)">
                                    <span class="glyphicon glyphicon-off pull-right"></span>注销
                                </a>
                            </li>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
