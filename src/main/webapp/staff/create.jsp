<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>Create New Staff</title>
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
                            <h2 class="header-title mb-3">Create staff</h2>
                        </div>
                    </div>
                </div>
            </div>

            <!-- end row -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="card-box">
                        <h5 class="mt-0 font-14 mb-3">Create New Staff</h5>
                        <div class="table">
                            <form method="post">
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Full Name</lable>
                                    </div>
                                    <div class="col-sm-6">
                                    <input name="full_name" id="full_name" type="text" placeholder="Full name">
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Gender</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="radio" name="gender" value="Nam" checked = "check">
                                        <lable>Nam</lable>
                                        <input type="radio" name="gender" value="Nu" >
                                        <lable>Nu</lable>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Date Of Birth</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input  type="date" name="date_of_birth" id="date_of_birth">
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>ID Card</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" name ="id_card" id ="id_card" placeholder="Id card">
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Email</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" name ="email" id="email" placeholder="Email">
                                    </div>

                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Phone</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" name="phone" id ="phone" placeholder="Phone">
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Address</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <textarea name="address" id="address" cols="40" rows="5" style="resize: none" placeholder="Address"></textarea>
                                       </textarea>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Image</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type='file' accept='image/*' onchange='openFile(event)' name="fileUpdate"
                                               data-rule-required=true><br>
                                        <input type="hidden" value="" id="base64" name="image">
                                        <img id='output' height="150px" width="150px">
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>

                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Position</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <select name="position" id="position">
                                            <option value="Staff" selected>Staff</option>
                                            <option value="Manage">Manage</option>
                                            <option value="Bartender">Bartender</option>
                                            <option value="Accountant">Accountant</option>
                                        </select>
                                        </select>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Pay</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="number" name ="pay" id="pay">
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Status</lable>
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
                                        <lable>Description</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <textarea name="description" id="description" cols="40" rows="10" style="resize: none" placeholder="Description">
                                        </textarea>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable></lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <button type="submit" class="btn btn-outline-success">Create</button>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                            </form>
                            <br>
<%--                            <div class="row">--%>
<%--                                <div id="footer" class="col-md-12">--%>
<%--                                    <p style="color: green">--%>
<%--                                        <c:if test='${requestScope["sucsess"] != null}'>--%>
<%--                                            <span class="message">${requestScope["sucsess"]}</span>--%>
<%--                                        </c:if>--%>
<%--                                    </p>--%>
<%--                                    <p style="color: red">--%>
<%--                                        <c:if test='${requestScope["messageFullName"] != null}'>--%>
<%--                                            <span class="message">${requestScope["messageFullName"]}</span>--%>
<%--                                        </c:if>--%>
<%--                                    </p>--%>
<%--                                    <p style="color: red">--%>
<%--                                        <c:if test='${requestScope["messageEmail"] != null}'>--%>
<%--                                            <span class="message">${requestScope["messageEmail"]}</span>--%>
<%--                                        </c:if>--%>
<%--                                    </p>--%>
<%--                                    <p style="color: red">--%>
<%--                                        <c:if test='${requestScope["error"] != null}'>--%>
<%--                                            <span class="message">${requestScope["error"]}</span>--%>
<%--                                        </c:if>--%>
<%--                                    </p>--%>
<%--                                </div>--%>
<%--                            </div>--%>
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
