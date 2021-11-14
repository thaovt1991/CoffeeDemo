<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>Create New Account</title>
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
                            <h1 class="header-title mb-3">Create account</h1>
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
                                <h5 class="mt-0 font-14 mb-3">Create New Account</h5>
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
                                               placeholder="Username">
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
                                        <label>Enter Password</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="password" name="enter_password"
                                               id="enter_password"
                                               placeholder="Enter password..">
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
                                               placeholder="Confirm Password">
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
                                        <label>Permission</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <select name="permission" id="permission">
                                            <option value="Admin" selected>Admin</option>
                                            <option value="Guest">Guest</option>
                                        </select>
                                        </select>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Status</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <select name="status" id="status">
                                            <option value="1" selected>Active</option>
                                            <option value="0">Inactivity</option>
                                        </select>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label></label>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="submit" class="btn btn-outline-success"
                                                <c:if test='${sucsess != null}'>
                                                    disabled ="true" ;
                                                </c:if>
                                        >
                                            <span>Create</span></button>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="button" class="btn btn-outline-dark"
                                                onclick='window.location.href="${pageContext.request.contextPath}/staffs?action=list"'>
                                            <i class="fas fa-arrow-left"></i><span>Back</span></button>
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
<%--<script>--%>
<%--    function displayImage() {--%>
<%--        <c:forEach items='${"listStaffActive"}' var ="staff">--%>
<%--        <c:if test='${staff.getId()== parseInt(document.getElementById("full_name").value)}'>--%>
<%--        document.getElementById("output").src = "${staff.getImage()}"--%>
<%--        </c:if>--%>
<%--        </c:forEach>--%>
<%--    }--%>
<%--</script>--%>
</html>
