
<div class="left-side-menu" >

    <div >
        <a href="${pageContext.request.contextPath}/login">
        <img src="/assets/images/logo/logo-coffee-2.png" alt="logo" width="100%">
        </a>
<%--        <div class="float-left">--%>
<%--            <img src="/assets/images/users/avatar-1.jpg" alt="" class="avatar-md rounded-circle">--%>
<%--        </div>--%>
<%--        <div class="user-info">--%>
<%--            <a href="#">Stanley Jones</a>--%>
<%--            <p class="text-muted m-0">Administrator</p>--%>
<%--        </div>--%>
    </div>

    <!--- Sidemenu -->
    <div id="sidebar-menu">

        <ul class="metismenu" id="side-menu">

            <li class="menu-title">Navigation</li>

            <li>
                <a href="${pageContext.request.contextPath}/login">
                    <i class="ti-home"></i>
                    <span> Dashboard </span>
                </a>
            </li>

<%--            <li>--%>
<%--                <a href="ui-elements.html">--%>
<%--                    <i class="ti-paint-bucket"></i>--%>
<%--                    <span> UI Elements </span>--%>
<%--                    <span class="badge badge-primary float-right">11</span>--%>
<%--                </a>--%>
<%--            </li>--%>

            <li>
                <a href="javascript: void(0);">
                    <i class="fas fa-store"></i>
                    <span> Manager Sell </span>
                    <span class="menu-arrow"></span>
                </a>
                <ul class="nav-second-level" aria-expanded="false">
                    <li><a href="#"> Create Oder</a></li>
                    <li><a href="#">All Oder</a></li>
                </ul>
            </li>

            <li>
                <a href="javascript: void(0);">
                    <i class="ti-paint-bucket"></i>
                    <span>  Drinks & Coffee </span>
                    <span class="menu-arrow"></span>
                </a>
                <ul class="nav-second-level" aria-expanded="false">
                    <li><a href="#">Add Drink</a></li>
                    <li><a href="#">All Drinks In Menu</a></li>
                    <li><a href="#">All Drinks Inactive</a></li>
                </ul>
            </li>

            <li>
                <a href="javascript: void(0);">
                    <i class="fas fa-user-friends"></i>
                    <span> Manager Staff </span>
                    <span class="menu-arrow"></span>
                </a>
                <ul class="nav-second-level" aria-expanded="false">
                    <li><a href="${pageContext.request.contextPath}/staffs?action=create">Add New Staff</a></li>
                    <li><a href="${pageContext.request.contextPath}/staffs?action=list">All Staff Active</a></li>
                    <li><a href="${pageContext.request.contextPath}/staffs?action=list_inactive">All Staff Inactive</a></li>
                </ul>
            </li>

            <li>
                <a href="javascript: void(0);">
                    <i class="fas fa-user-plus"></i>
                    <span> Manager Account </span>
                    <span class="menu-arrow"></span>
                </a>
                <ul class="nav-second-level" aria-expanded="false">
                    <li><a href="${pageContext.request.contextPath}/accounts?action=create">Create Account</a></li>
                    <li><a href="${pageContext.request.contextPath}/accounts?action=list">All Account Active</a></li>
                    <li><a href="#">All Account Inactive</a></li>
                </ul>
            </li>

<%--            <li>--%>
<%--                <a href="typography.html">--%>
<%--                    <i class="ti-spray"></i>--%>
<%--                    <span> Typography </span>--%>
<%--                </a>--%>
<%--            </li>--%>
            <li>
                <a href="javascript: void(0);">
                    <i class="ti-pencil-alt"></i>
                    <span> Manager Revenue </span>
                    <span class="menu-arrow"></span>
                </a>
                <ul class="nav-second-level" aria-expanded="false">
                    <li><a href="#">Revenue By Date</a></li>
                    <li><a href="#">Revenue By Option</a></li>
                    <li><a href="#"></a>Revenue By Manager</li>
                </ul>
            </li>

            <li>
                <a href="javascript: void(0);">
                    <i class="fas fa-mail-bulk"></i>
                    <span> Contact  </span>
                    <span class="menu-arrow"></span>
                </a>
                <ul class="nav-second-level" aria-expanded="false">
                    <li><a href="#">New Contact</a></li>
                    <li><a href="#">All Contact</a></li>
                </ul>
            </li>

<%--            <li>--%>
<%--                <a href="javascript: void(0);">--%>
<%--                    <i class="ti-pencil-alt"></i>--%>
<%--                    <span>  Forms  </span>--%>
<%--                    <span class="menu-arrow"></span>--%>
<%--                </a>--%>
<%--                <ul class="nav-second-level" aria-expanded="false">--%>
<%--                    <li><a href="forms-general.html">General Elements</a></li>--%>
<%--                    <li><a href="forms-advanced.html">Advanced Form</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>

<%--            <li>--%>
<%--                <a href="javascript: void(0);">--%>
<%--                    <i class="ti-menu-alt"></i>--%>
<%--                    <span>  Tables </span>--%>
<%--                    <span class="menu-arrow"></span>--%>
<%--                </a>--%>
<%--                <ul class="nav-second-level" aria-expanded="false">--%>
<%--                    <li><a href="tables-basic.html">Basic Tables</a></li>--%>
<%--                    <li><a href="tables-advanced.html">Advanced Tables</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>

<%--            <li>--%>
<%--                <a href="charts.html">--%>
<%--                    <i class="ti-pie-chart"></i>--%>
<%--                    <span>  Charts  </span>--%>
<%--                    <span class="badge badge-primary float-right">5</span>--%>
<%--                </a>--%>
<%--            </li>--%>

            <li>
                <a href="maps.html">
                    <i class="ti-location-pin"></i>
                    <span> Maps </span>
                </a>
            </li>

<%--            <li>--%>
<%--                <a href="javascript: void(0);">--%>
<%--                    <i class="ti-files"></i>--%>
<%--                    <span> Pages </span>--%>
<%--                    <span class="menu-arrow"></span>--%>
<%--                </a>--%>
<%--                <ul class="nav-second-level" aria-expanded="false">--%>
<%--                    <li><a href="pages-login.html">Login</a></li>--%>
<%--                    <li><a href="pages-register.html">Register</a></li>--%>
<%--                    <li><a href="pages-forget-password.html">Forget Password</a></li>--%>
<%--                    <li><a href="pages-lock-screen.html">Lock-screen</a></li>--%>
<%--                    <li><a href="pages-blank.html">Blank page</a></li>--%>
<%--                    <li><a href="pages-404.html">Error 404</a></li>--%>
<%--                    <li><a href="pages-confirm-mail.html">Confirm Mail</a></li>--%>
<%--                    <li><a href="pages-session-expired.html">Session Expired</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>

<%--            <li>--%>
<%--                <a href="javascript: void(0);">--%>
<%--                    <i class="ti-widget"></i>--%>
<%--                    <span> Extra Pages </span>--%>
<%--                    <span class="menu-arrow"></span>--%>
<%--                </a>--%>
<%--                <ul class="nav-second-level" aria-expanded="false">--%>

<%--                    <li><a href="extras-timeline.html">Timeline</a></li>--%>
<%--                    <li><a href="extras-invoice.html">Invoice</a></li>--%>
<%--                    <li><a href="extras-profile.html">Profile</a></li>--%>
<%--                    <li><a href="extras-calendar.html">Calendar</a></li>--%>
<%--                    <li><a href="extras-faqs.html">FAQs</a></li>--%>
<%--                    <li><a href="extras-pricing.html">Pricing</a></li>--%>
<%--                    <li><a href="extras-contacts.html">Contacts</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>

<%--            <li>--%>
<%--                <a href="javascript: void(0);">--%>
<%--                    <i class="ti-layout"></i>--%>
<%--                    <span> Layouts </span>--%>
<%--                    <span class="badge badge-danger badge-pill float-right">New</span>--%>
<%--                </a>--%>
<%--                <ul class="nav-second-level" aria-expanded="false">--%>
<%--                    <li><a href="layouts-horizontal.html">Horizontal</a></li>--%>
<%--                    <li><a href="layouts-dark-sidebar.html">Dark Sidebar</a></li>--%>
<%--                    <li><a href="layouts-small-sidebar.html">Small Sidebar</a></li>--%>
<%--                    <li><a href="layouts-sidebar-collapsed.html">Sidebar Collapsed</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>

<%--            <li>--%>
<%--                <a href="javascript: void(0);">--%>
<%--                    <i class="ti-share"></i>--%>
<%--                    <span>  Multi Level  </span>--%>
<%--                    <span class="menu-arrow"></span>--%>
<%--                </a>--%>
<%--                <ul class="nav-second-level nav" aria-expanded="false">--%>
<%--                    <li>--%>
<%--                        <a href="javascript: void(0);">Level 1.1</a>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <a href="javascript: void(0);" aria-expanded="false">Level 1.2--%>
<%--                            <span class="menu-arrow"></span>--%>
<%--                        </a>--%>
<%--                        <ul class="nav-third-level nav" aria-expanded="false">--%>
<%--                            <li>--%>
<%--                                <a href="javascript: void(0);">Level 2.1</a>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a href="javascript: void(0);">Level 2.2</a>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--            </li>--%>
        </ul>

    </div>
    <!-- End Sidebar -->

    <div class="clearfix"></div>


</div>