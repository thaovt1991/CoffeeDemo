<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>Restore Staff</title>
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
                            <h2 class="header-title mb-3">Restore staff</h2>
                        </div>
                    </div>
                </div>
            </div>

            <!-- end row -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="card-box">
                        <h5 class="mt-0 font-14 mb-3">Details Information Staff </h5>
                        <div class="table">
                            <form id="form-restore">
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Full Name</label>
                                    </div>
                                    <div class="col-sm-6"><input class="form-control" name="full_name" id="full_name" type="text"
                                                                 value="${requestScope["staff"].getFullName()}"
                                                                 disabled>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Gender</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="gender" type="radio" name="gender" id="male" value="Nam"
                                               <c:if test='${staff.getGender()=="Nam"}'>checked="true"</c:if> disabled>
                                        <label>Nam</label>
                                        <input class="gender" type="radio" name="gender" id="female" value="Nu"
                                               <c:if test='${staff.getGender()=="Nu"}'>checked="true" </c:if>disabled>
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
                                        <input class="form-control" type="date" name="date_of_birth" id="date_of_birth"
                                               value="${requestScope["staff"].getDateOfBirth()}" disabled>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>ID Card</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="id_card" id="id_card"
                                               value="${requestScope["staff"].getIdCard()}" disabled>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Email</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="email" id="email"
                                               value="${requestScope["staff"].getEmail()}" disabled>
                                    </div>

                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Phone</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="phone" id="phone"
                                               value="${requestScope["staff"].getPhone()}" disabled>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label for="address">Address</label>
                                    </div>
                                    <div class="col-sm-6">
                                       <textarea class="form-control" name="address" id="address"
                                                 style="resize: none; text-align: left;" disabled>
                                           ${requestScope["staff"].getAddress()}
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
                                        <img id='output' height="150px" width="150px" src="${staff.getImage()}"
                                             disabled>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>

                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Position</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <select name="position" id="position" disabled>
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
                                        <label>Pay</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="number" name="pay" id="pay"
                                               value="${requestScope["staff"].getPay()}" disabled>
                                    </div>
                                    <div class="col-sm-4"></div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Status</label>
                                    </div>
                                    <div class="col-sm-6">
                                        <select name="status" id="status" disabled>
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
                                                   aria-hidden="true"
                                                   style="resize: none; text-align: left;" disabled>
                                             ${requestScope["staff"].getDescription()}
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
                                        <button type="submit" class="btn btn-outline-warning" onclick="isRestore()" ><i
                                                class="fas fa-trash-restore-alt"></i> <span>Restore</span></button>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="button" class="btn btn-outline-dark" onclick='window.location.href="${pageContext.request.contextPath}/staffs?action=list_inactive"' >
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
<script>
    function isRestore() {
        let name = document.getElementById("full_name").value;
        if (confirm("Are you sure restore " + name + " !")) {
            alert("Restore success !");
            document.getElementById("form-restore").method = "post";
        }
        ;
    }
</script>
</html>

