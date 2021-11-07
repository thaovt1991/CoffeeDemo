<%--
  Created by IntelliJ IDEA.
  User: vothao
  Date: 06/11/2021
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Staffs</title>
</head>
<body>
<a href="staffs?action=create">Create new Staff</a>
 <from>
     <input type="text" placeholder="Input name staff">
     <input type="submit" value="Search">
 </from>

  <table border="1">
      <tr id = "head-table">
          <th>#</th>
          <th>Image</th>
          <th>Full Name</th>
          <th>Gender</th>
          <th>Email</th>
          <th>Phone</th>
          <th>Position</th>
          <th>Pay</th>
          <th class="action" colspan="4">Action</th>
      </tr>
      <c:forEach items='${requestScope["listStaffs"]}' var="staff">
          <tr>
              <td >${staff.getId()}</td>
              <td><img src="${staff.getImage()}" alt="image_staff" style="width: 50px;height:50px"></td>
              <td>${staff.getFullName()}</td>
              <td >${staff.getGender()}</td>
              <td >${staff.getEmail()}</td>
              <td >${staff.getPhone()}</td>
              <td>${staff.getPosition()}</td>
              <td >
                  <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${staff.getPay()}"></fmt:formatNumber>
              </td>
              <td>
                  <button type="button" class="btn btn-outline-secondary"  data-toggle="tooltip" data-placement="top" title="Edit" onclick="window.location.href ='/staffs?action=edit&id=${staff.getId()}'">
                      <i class="far fa-edit"></i>
                  </button>
              </td>
              <td>
                  <button type="button" class="btn btn-outline-success"  data-toggle="tooltip" data-placement="top" title="Details" onclick="window.location.href ='/staffs?action=details&id=${staff.getId()}'">
                      <i class="far fa-plus-square"></i>
                  </button>
              </td>
              <td>
                  <button type="button" class="btn btn-outline-success"  data-toggle="tooltip" data-placement="top" title="Create Account" onclick="window.location.href ='/staffs?action=details&id=${staff.getId()}'">
                      <i class="far fa-plus-square"></i>
                  </button>
              </td>
              <td>
                  <button type="button" class="btn btn-outline-danger"data-toggle="tooltip" data-placement="top" title="Delete" onclick="window.location.href ='/customers?action=delete&id=${staff.getId()}'">
                      <i class="fas fa-ban"></i>
                  </button>
              </td>
          </tr>
      </c:forEach>
  </table>
</body>
</html>
