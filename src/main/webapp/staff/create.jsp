<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>Create New Staff</title>
    <style>
        label {
            color: #006cfa;
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
                            <h2 class="header-title mb-3">Create staff</h2>
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
                                <h5 class="mt-0 font-14 mb-3">Create New Staff</h5>
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
                                        <label for="full_name">Full Name</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" name="full_name" id="full_name" type="text"
                                               placeholder="Full name">
                                    </div>
                                    <div class="col-sm-4">
                                        <p>
                                            <c:if test='${requestScope["messageFullName"] != null}'>
                                                <span style="color: red"
                                                      class="message">${requestScope["messageFullName"]}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Gender</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="radio" name="gender" value="Nam" checked="check">
                                        <label>Nam</label>
                                        <input type="radio" name="gender" value="Nu">
                                        <label>Nu</label>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Date Of Birth</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="date" name="date_of_birth" id="date_of_birth">
                                    </div>
                                    <div class="col-sm-4">
                                        <p>
                                            <c:if test='${requestScope["messageDateOfBirth"] != null}'>
                                                <span style="color: red"
                                                      class="message">${requestScope["messageDateOfBirth"]}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>ID Card</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="id_card" id="id_card"
                                               placeholder="Id card">
                                    </div>
                                    <div class="col-sm-4">
                                        <p>
                                            <c:if test='${requestScope["messageIdCard"] != null}'>
                                                <span style="color: red"
                                                      class="message">${requestScope["messageIdCard"]}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Email</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="email" id="email"
                                               placeholder="Email">
                                    </div>

                                    <div class="col-sm-4">
                                        <p>
                                            <c:if test='${requestScope["messageEmail"] != null}'>
                                                <span style="color: red"
                                                      class="message">${requestScope["messageEmail"]}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Phone</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="phone" id="phone"
                                               placeholder="Phone">
                                    </div>
                                    <div class="col-sm-4">
                                        <p>
                                            <c:if test='${requestScope["messagePhone"] != null}'>
                                                <span style="color: red"
                                                      class="message">${requestScope["messagePhone"]}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Address</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <textarea class="form-control" name="address" id="address" cols="40" rows="5"
                                                  style="resize: none"
                                                  placeholder="Address"></textarea>
                                        </textarea>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Image</label>
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
                                        <label>Position</label>
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
                                        <label>Pay</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="number" name="pay" id="pay" value="0">
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
                                        <label>Description</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <textarea class="form-control" name="description" id="description" rows="5"
                                                  style="resize: none ; width: 100%" placeholder="Description">
                                        </textarea>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label></label>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="submit" class="btn btn-outline-success">
                                            <i class="fad fa-user-plus"></i>
                                            <span>Create</span></button>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="button" class="btn btn-outline-dark"
                                                onclick='window.location.href="${pageContext.request.contextPath}/staffs?action=list"'>
                                            <i class="fas fa-arrow-left"></i> <span>Back</span></button>
                                    </div>
                                    <div class="col-sm-4">
                                    </div>
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
