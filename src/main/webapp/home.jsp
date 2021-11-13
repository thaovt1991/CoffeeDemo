<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>Coffee Demo</title>
    <%@include file="/layout/head.jsp" %>
</head>

<body>

<!-- Begin page -->
<div id="wrapper" >


    <!-- Topbar Start -->
    <%@include file="/layout/navbar.jsp" %>
    <!-- end Topbar --> <!-- ========== Left Sidebar Start ========== -->
    <%@include file="/layout/left-side-menu.jsp" %>
    <!-- Left Sidebar End -->

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page" style="background-image: url(/assets/images/background/bg_pic.jpg)">
        <img src="/assets/images/background/bg_pic.jpg" alt="">
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