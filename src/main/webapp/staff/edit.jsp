<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>Edit Staff</title>
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
                        <div class="row">
                            <div class="col-sm-3">
                                <h5 class="mt-0 font-14 mb-3">Edit Information</h5>
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
                                        <lable>Full Name</lable>
                                    </div>
                                    <div class="col-sm-6"><input class="form-control" name="full_name" id="full_name" type="text"
                                                                 value="${requestScope["staff"].getFullName()}">
                                    </div>
                                    <div class="col-sm-4">
                                        <p >
                                            <c:if test='${requestScope["messageFullName"] != null}'>
                                                <span style="color: red" class="message">${requestScope["messageFullName"]}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>Gender</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input  class="gender" type="radio" name="gender" id="male" value="Nam"
                                               <c:if test='${staff.getGender()=="Nam"}'>checked="true"</c:if> >
                                        <lable>Nam</lable>
                                        <input  class="gender" type="radio" name="gender" id="female" value="Nu"
                                               <c:if test='${staff.getGender()=="Nu"}'>checked="true"</c:if>>
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
                                        <input class="form-control" type="date" name="date_of_birth" id="date_of_birth"
                                               value="${requestScope["staff"].getDateOfBirth()}">
                                    </div>
                                    <div class="col-sm-4">
                                        <p >
                                            <c:if test='${requestScope["messageDateOfBirth"] != null}'>
                                                <span style="color: red" class="message">${requestScope["messageDateOfBirth"]}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable>ID Card</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="id_card" id="id_card"
                                               value="${requestScope["staff"].getIdCard()}">
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
                                        <lable>Email</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="email" id="email"
                                               value="${requestScope["staff"].getEmail()}">
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
                                        <lable>Phone</lable>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="phone" id="phone"
                                               value="${requestScope["staff"].getPhone()}">
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
                                        <label for="address">Address</label>
                                    </div>
                                    <div class="col-sm-6">
                                       <textarea class="form-control" name="address" id="address"  style="resize: none; text-align: left;font-family: Arial">
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
                                        <input class="form-control" type="number" name="pay" id="pay"
                                               value="${requestScope["staff"].getPay()}">
                                    </div>
                                    <div class="col-sm-4">
                                        <p>
                                            <c:if test='${requestScope["messagePay"] != null}'>
                                                <span style="color: red"
                                                      class="message">${requestScope["messagePay"]}</span>
                                            </c:if>
                                        </p>
                                    </div>
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
                                        <label>Description</label>
                                    </div>
                                    <div class="col-sm-6">
                                         <textarea class="form-control" name="description" id="description"
                                                   style="resize: none; text-align: left;">
                                             ${staff.getDescription()}
                                         </textarea>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <lable></lable>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="submit" class="btn btn-outline-primary"
                                                data-toggle="tooltip" data-placement="top" title="Edit"><i class="far fa-edit"></i>Edit</button>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="button" class="btn btn-outline-dark"
                                                onclick='window.location.href="${pageContext.request.contextPath}/staffs?action=list"' >
                                            <i class="fas fa-arrow-left"></i> <span>Back</span></button>
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
</body>

</html>