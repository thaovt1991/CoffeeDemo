<%--
  Created by IntelliJ IDEA.
  User: vothao
  Date: 07/11/2021
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit staff</title>
</head>
<body>
<form method="post">
    <table>
    <tr>
        <td>
            <lable>Full Name</lable>
        </td>
        <td>
            <input name="full_name" id="full_name" type="text" value="${requestScope["staff"].getFullName()}">
        </td>
    </tr>
    <tr>
        <td>
            <lable>Gender</lable>
        </td>
        <td>


                <input type="radio" name="gender" value="Nam" checked = ${requestScope["staff"].getGender() =="Nam"}>
                <lable>Nam</lable>
                <input type="radio" name="gender" value="Nu" checked = ${requestScope["staff"].getGender() =="Nu"}>
                <lable>Nu</lable>

        </td>
    </tr>
    <tr>
        <td>
            <lable>Date Of Birth</lable>
        </td>
        <td>
            <input type="date" name="date_of_birth" id="date_of_birth" value="${requestScope["staff"].getDateOfBirth()}">
        </td>
    </tr>
    <tr>
        <td>
            <lable>ID Card</lable>
        </td>
        <td>
            <input type="text" name="id_card" id="id_card"  value="${requestScope["staff"].getIdCard()}" >
        </td>
    </tr>
    <tr>
        <td>
            <lable>Email</lable>
        </td>
        <td>
            <input type="text" name="email" id="email" value="${requestScope["staff"].getEmail()}">
        </td>
    </tr>
    <tr>
        <td>
            <lable>Phone</lable>
        </td>
        <td>
            <input type="text" name="phone" id="phone" value="${requestScope["staff"].getPhone()}">
        </td>
    </tr>
    <tr>
        <td>
            <lable>Address</lable>
        </td>
        <td>
            <textarea name="address" id="address" cols="30" rows="10" style="resize: none" >
               ${requestScope["staff"].getAddress()}
            </textarea>
        </td>
    </tr>
    <tr>
        <td>
            <lable>Image</lable>
        </td>
        <td>
            <input class="form-control" type='file' accept='image/*' onchange='openFile(event)' name="fileUpdate"
                   data-rule-required=true><br>
            <input type="hidden" value="" id="base64">
            <img id='output' height="150px" width="100px">
            <%--            <input type="link"   class="image" id ="image">--%>
            <%--            <img src="${document.getElementById("image").value}" alt="" style="width: 30px; height: 30px">--%>
        </td>
    </tr>
    <tr>
        <td>
            <lable>Position</lable>
        </td>
        <td>
            <select name="position" id="position" value="${requestScope["staff"].getPosition()}">
                <option value="Staff" >Staff</option>
                <option value="Manage">Manage</option>
                <option value="Bartender">Bartender</option>
                <option value="Accountant">Accountant</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>
            <lable>Pay</lable>
        </td>
        <td>
            <input type="number" name="pay" id="pay" value="${requestScope["staff"].getPay()}">
        </td>
    </tr>
    <td>
        <lable>Status</lable>
    </td>
    <td>
        <c:if test='${requestScope["staff"].isStatus()}'>
        <select name="status" id="status" >
            <option value="1" selected>Active</option>
            <option value="0">Inactivity</option>
        </select>
        </c:if>
        <c:if test='!${requestScope["staff"].isStatus()}'>
            <select name="status" id="status" >
                <option value="1" >Active</option>
                <option value="0" selected>Inactivity</option>
            </select>
        </c:if>
    </td>
    </tr>
    <tr>
        <td>
            <lable>Description</lable>
        </td>
        <td>
            <textarea name="description" id="description" cols="30" rows="10" style="resize: none">
             ${requestScope["staff"].getDescription()}
            </textarea>
        </td>
    </tr>
    <tr>
        <td>
            <button></button>
        </td>
        <td>
            <button type="submit">Edit</button>
        </td>
    </tr>
    </table>
</form>
<div class="row">
    <div id="footer" class="col-sm-12">
        <p style="color: green">
            <c:if test='${requestScope["message"] != null}'>
                <span class="message">${requestScope["message"]}</span>
            </c:if>
        </p>
        <p style="color: red">
            <c:if test='${requestScope["messageFullName"] != null}'>
                <span class="message">${requestScope["messageFullName"]}</span>
            </c:if>
        </p>
        <p style="color: red">
            <c:if test='${requestScope["messageEmail"] != null}'>
                <span class="message">${requestScope["messageEmail"]}</span>
            </c:if>
        </p>
        <p style="color: red">
            <c:if test='${requestScope["update_error"] != null}'>
                <span class="message">${requestScope["update_error"]}</span>
            </c:if>
        </p>
    </div>
</div>
</body>
<script src="/assest/js/input-image.js"></script>
</html>
