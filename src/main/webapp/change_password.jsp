<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>Change Password</title>
    <style>

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
                            <h1 class="header-title mb-3">Change Password</h1>
                        </div>
                    </div>
                </div>
            </div>

            <!-- end row -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="card-box">
                        <div class="row">
                            <div class="col-sm-3">
                                <h5 class="mt-0 font-14 mb-3">Change Password Account</h5>
                            </div>
                            <div class="col-sm-6">
                                <p>
                                    <c:if test='${requestScope["sucsess"] != null}'>
                                                <span style="color: green"
                                                      class="message">${requestScope["sucsess"]}</span>
                                    </c:if>
                                    <c:if test='${requestScope["error"] != null}'>
                                        <span style="color: red" class="message">${requestScope["error"]}</span>
                                    </c:if>
                                </p>
                            </div>
                            <div class="col-sm-3"></div>
                        </div>
                        <div class="table">
                            <form method="post">
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Image</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <img id='output' height="150px" width="150px" src="${staff.getImage()}">
                                    </div>
                                    <div class="col-sm-4">
                                    </div>
                                </div>
                                <br>

                                <div class="row">
                                    <div class="col-sm-2">
                                        <label for="full_name">Full Name</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <select name="full_name" id="full_name" disabled>
                                            <option value='${staff.getId()}'>${staff.getId()}
                                                - ${staff.getFullName()}</option>
                                        </select>

                                    </div>
                                    <div class="col-sm-4">

                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Username</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="username" id="username"
                                               value="${account.getUsername()}" disabled>
                                    </div>
                                    <div class="col-sm-4">
                                        <p>
                                            <c:if test='${requestScope["errorUsername"] != null}'>
                                                <span style="color: red"
                                                      class="message">${requestScope["errorUsername"]}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Old Password</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="password" name="old_password"
                                               id="old_password"
                                               placeholder="Enter old password..">
                                    </div>
                                    <div class="col-sm-4">
                                        <p>
                                            <c:if test='${requestScope["errorOldPass"] != null}'>
                                                <span style="color: red"
                                                      class="message">${requestScope["errorOldPass"]}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>New Password</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="password" name="enter_password"
                                               id="enter_password"
                                               placeholder="Enter new password..">
                                    </div>
                                    <div class="col-sm-4">
                                        <p>
                                            <c:if test='${requestScope["errorPass1"] != null}'>
                                                <span style="color: red"
                                                      class="message">${requestScope["errorPass1"]}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Confirm Password</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="password" name="confirm_password"
                                               id="confirm_password"
                                               placeholder="Confirm new password">
                                    </div>
                                    <div class="col-sm-4">
                                        <p>
                                            <c:if test='${requestScope["errorPass2"] != null}'>
                                                <span style="color: red"
                                                      class="message">${requestScope["errorPass2"]}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label></label>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="submit" class="btn btn-outline-warning">
                                            <span>Change</span></button>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="button" class="btn btn-outline-dark"
                                                onclick='window.location.href="${pageContext.request.contextPath}/login?action=home"'>
                                            <i class="fas fa-arrow-left"></i><span>Back Home</span></button>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                            </form>
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

<%--<a href="/staffs">Quay lai</a>--%>

</body>
<script src="/assest/js/input-image.js"></script>

</html>


