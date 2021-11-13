<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>List Staffs Search</title>
    <style>
        .id {
            width: 5%;
        }

        .image {
            width: 15%;
        }

        .name {
            width: 20%;
        }

        .gender {
            width: 10%;
        }

        .position {
            width: 10%;
        }

        .action {
            width: 35%;
            text-align: center;
        }

        th {
            background-color: #3db9dc;
            color: #16181b;
            font-weight: bolder;
        }

    </style>
    <%@include file="/layout/head.jsp" %>
</head>

<body>

<!-- Begin page -->
<div id="wrapper">


    <!-- Topbar Start -->
    <%@include file="/layout/navbar.jsp" %>
    <!-- end Topbar --> <!-- ========== Left Sidebar Start ========== -->
    <%@include file="/layout/left-side-menu.jsp" %>
    <!-- Left Sidebar End -->

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page">
        <div class="content">

            <!-- Start container-fluid -->
            <div class="container-fluid">

                <div class="row">
                    <div class="col-12">
                        <div>
                            <h1 class="header-title mb-3">List staffs !</h1>
                        </div>
                    </div>
                </div>
                <!-- end row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card-box row">
                            <div class="col-sm-4"></div>
                            <div class="col-sm-8">
                                <li class="d-none d-sm-block">
                                    <form class="app-search" method="post"
                                          action="${pageContext.request.contextPath}/staffs?action=search">
                                        <div class="app-search-box">
                                            <div class="input-group">
                                                <div class="form-control">
                                                    <label for="properties" style="font-size: 16px">Properties</label>
                                                    <select name="properties" id="properties" style="width: 120px">
                                                        <option value="Name"  <c:if test='${requestScope["propertiesSelect"]=="Name"}'>selected="true"</c:if> >Name</option>
                                                        <option value="Gender"  <c:if test='${requestScope["propertiesSelect"]=="Gender"}'>selected="true"</c:if>>Gender</option>
                                                        <option value="Position"  <c:if test='${requestScope["propertiesSelect"]=="Position"}'>selected="true"</c:if>>Position</option>
                                                    </select>
                                                </div>
                                                <input type="text" class="form-control" name="search" id="search"
                                                       value="${requestScope["search"]}">
                                                <div class="input-group-append">
                                                    <button class="btn btn-outline-primary " type="submit">
                                                        <i class="fas fa-search"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </li>
                            </div>
                        </div>

                        </div>
                        <br>
                        <div class="table-responsive">
                            <table class="table table-hover mails m-0 table table-actions-bar table-centered">
                                <thead>
                                <tr id="head-table">
                                    <th class="id">#</th>
                                    <th class="image">Image</th>
                                    <th class="name">Full Name</th>
                                    <th class="gender">Gender</th>
                                    <th class="position">Position</th>
                                    <th class="action" colspan="4">Action</th>
                                </tr>
                                </thead>


                                <tbody>
                                <c:forEach items='${requestScope["listSearch"]}' var="staff">
                                    <tr>
                                        <td>${staff.getId()}</td>
                                        <td><img src="${staff.getImage()}" alt="image_staff"
                                                 style="width: 50px;height:50px"></td>
                                        <td>${staff.getFullName()}</td>
                                        <td>${staff.getGender()}</td>

                                        <td>${staff.getPosition()}</td>
                                        <td>
                                            <button type="button" class="btn btn-outline-secondary"
                                                    data-toggle="tooltip" data-placement="top" title="Edit"
                                                    onclick="window.location.href ='${pageContext.request.contextPath}/staffs?action=edit&id=${staff.getId()}'">
                                                <i class="far fa-edit"></i>
                                            </button>
                                        </td>
                                        <td>
                                            <button type="button" class="btn btn-outline-info"
                                                    data-toggle="tooltip"
                                                    data-placement="top" title="Details"
                                                    onclick="window.location.href ='${pageContext.request.contextPath}/staffs?action=details&id=${staff.getId()}'">
                                                <i class="fas fa-search-plus"></i>
                                            </button>
                                        </td>
                                        <td>
                                            <c:if test='${!staff.isStatusAccount()}'>
                                                <button
                                                        type="button" class="btn btn-outline-success"
                                                        data-toggle="tooltip"
                                                        data-placement="top" title="Create Account"
                                                        onclick="window.location.href ='${pageContext.request.contextPath}/staffs?action=create_account&id=${staff.getId()}'">
                                                    <i class="fas fa-user-plus"></i>
                                                </button>
                                            </c:if>
                                            <c:if test='${staff.isStatusAccount()}'>
                                                <button type="button" class="btn btn-outline-warning"
                                                        data-toggle="tooltip"
                                                        data-placement="top" title="Edit Account" >
                                                    <i class="fas fa-user-cog"></i>
                                                </button>
                                            </c:if>
                                        </td>
                                        <td>
                                            <button type="button" class="btn btn-outline-danger"
                                                    data-toggle="tooltip"
                                                    data-placement="top" title="Delete"
                                                    onclick="window.location.href ='${pageContext.request.contextPath}/staffs?action=delete&id=${staff.getId()}'">
                                                <i class="fas fa-ban"></i>
                                            </button>
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
        <!-- end container-fluid -->


        <!-- Footer Start -->
        <%@include file="/layout/footer.jsp" %>
        <!-- end Footer -->

    </div>
    <!-- end content -->

</div>
<!-- END content-page -->

</div>
<!-- END wrapper -->


<!-- Right Sidebar -->
<%@include file="/layout/right-bar.jsp" %>
<!-- /Right-bar -->

<!-- Right bar overlay-->
<div class="rightbar-overlay"></div>

<a href="javascript:void(0);" class="right-bar-toggle demos-show-btn">
    <i class="mdi mdi-settings-outline mdi-spin"></i> &nbsp;Choose Demos
</a>

<!-- Vendor js -->

<%@include file="/layout/script.jsp" %>
</body>
<%--<script src="/assets/js/input-image.js"></script>--%>
</html>