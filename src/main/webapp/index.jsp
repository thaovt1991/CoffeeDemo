<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>List of Customer</title>
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
                            <h2 class="header-title mb-3">Edit staff</h2>
                        </div>
                    </div>
                </div>
            </div>

            <!-- end row -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="card-box">
                        <h5 class="mt-0 font-14 mb-3">Edit Information</h5>
                        <div class="table-responsive">
                            <form method="post">
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Full Name</lable>
                                    </div>
                                    <div class="col-sm-6"><input name="full_name" id="full_name" type="text"
                                                                 value="${requestScope["staff"].getFullName()}">
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Gender</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="gender" type="radio" name="gender" id="male" value="Nam"
                                               <c:if test='${staff.getGender()=="Nam"}'>checked="true"</c:if> >
                                        <lable>Nam</lable>
                                        <input class="gender" type="radio" name="gender" id="female" value="Nu" <c:if test='${staff.getGender()=="Nu"}'>checked="true"</c:if>>
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
                                        <input type="date" name="date_of_birth" id="date_of_birth"
                                        value="${requestScope["staff"].getDateOfBirth()}">
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>ID Card</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" name="id_card" id="id_card"
                                               value="${requestScope["staff"].getIdCard()}">
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Email</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" name="email" id="email"
                                               value="${requestScope["staff"].getEmail()}">
                                    </div>

                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Phone</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" name="phone" id="phone"
                                               value="${requestScope["staff"].getPhone()}">
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Address</lable>
                                    </div>
                                    <div class="col-sm-6">
                                       <textarea name="address" id="address" cols="40" rows="5" style="resize: none">
                                           ${requestScope["staff"].getAddress()}
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
                                        <input  type='file' accept='image/*'
                                               onchange='openFile(event)'
                                               name="fileUpdate"
                                               data-rule-required=true><br>
                                        <input type="hidden" value="" id="base64" name="image">
                                        <img id='output' height="150px" width="150px" src="${staff.getImage()}">
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
                                            <option value="Staff"
                                                    <c:if test='${staff.getPosition()=="Staff"}'>selected="true"</c:if> >
                                                Staff
                                            </option>
                                            <option value="Manage"
                                                    <c:if test='${staff.getPosition()=="Manage"}'>selected="true"</c:if>>
                                                Manage
                                            </option>
                                            <option value="Bartender"
                                                    <c:if test='${staff.getPosition()=="Bartender"}'>selected="true"</c:if>>
                                                Bartender
                                            </option>
                                            <option value="Accountant"
                                                    <c:if test='${staff.getPosition()=="Accountant"}'>selected="true"</c:if>>
                                                Accountant
                                            </option>
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
                                        <input type="number" name="pay" id="pay"
                                               value="${requestScope["staff"].getPay()}">
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
                                            <option value="1" <c:if test='${staff.isStatus()}'>selected="true"</c:if>>
                                                Active
                                            </option>
                                            <option value="0" <c:if test='${!staff.isStatus()}'>selected="true"</c:if>>
                                                Inactivity
                                            </option>
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
                                         <textarea name="description" id="description" cols="40" rows="10"
                                           style="resize: none">${requestScope["staff"].getDescription()}</textarea>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable></lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <button type="submit">Edit</button>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                            </form>
                            <br>
<%--                            <div class="row">--%>
<%--                                <div id="footer" class="col-sm-12">--%>
<%--                                    <p style="color: green">--%>
<%--                                        <c:if test='${requestScope["message"] != null}'>--%>
<%--                                            <span class="message">${requestScope["message"]}</span>--%>
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
<%--                                        <c:if test='${requestScope["update_error"] != null}'>--%>
<%--                                            <span class="message">${requestScope["update_error"]}</span>--%>
<%--                                        </c:if>--%>
<%--                                    </p>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
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

</html>

<%--    <a href="staffs?action=create">Create new Staff</a>--%>
<%--    <form method="post" action="/staffs?action=search">--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td><input type="text" name="name" id="name" placeholder="Staff name search"></td>--%>
<%--                <td>--%>
<%--                    <button type="submit">Search</button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form>--%>