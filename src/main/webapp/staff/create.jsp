<%--
  Created by IntelliJ IDEA.
  User: vothao
  Date: 06/11/2021
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new staff</title>
</head>
<body>
<h1>Create new staff</h1>
<a href="/staffs">Quay lai</a>
<form method="post">
<table border="1">
    <tr>
        <td>
            <lable>Full Name</lable>
        </td>
        <td>
            <input name="full_name" id="full_name" type="text" placeholder="Full name">
        </td>
    </tr>
    <tr>
        <td>
            <lable>Gender</lable>
        </td>
        <td>
            <input type="radio" name="gender" value="Nam" checked>
            <lable>Nam</lable>
            <input type="radio" name="gender" value="Nu" >
            <lable>Nu</lable>
        </td>
    </tr>
    <tr>
        <td>
            <lable>Date Of Birth</lable>
        </td>
        <td>
            <input  type="date" name="date_of_birth" id="date_of_birth">
        </td>
    </tr>
    <tr>
        <td>
            <lable>ID Card</lable>
        </td>
        <td>
            <input type="text" name ="id_card" id ="id_card" placeholder="Id card">
        </td>
    </tr>
    <tr>
        <td>
            <lable>Email</lable>
        </td>
        <td>
            <input type="text" name ="email" id="email" placeholder="Email">
        </td>
    </tr>
    <tr>
        <td>
            <lable>Phone</lable>
        </td>
        <td>
            <input type="text" name="phone" id ="phone" placeholder="Phone">
        </td>
    </tr>
    <tr>
        <td>
            <lable>Address</lable>
        </td>
        <td>
            <textarea name="address" id="address" cols="30" rows="10" style="resize: none"></textarea>
        </td>
    </tr>
    <tr>
        <td>
            <lable>Image</lable>
        </td>
        <td>
            <input class="form-control" type='file' accept='image/*' onchange='openFile(event)' name="fileUpdate"
                   data-rule-required=true><br>
            <input type="hidden" value="" id="base64" name="image">
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
            <select name="position" id="position">
                <option value="Staff" selected>Staff</option>
                <option value="Manage">Manage</option>
                <option value="Bartender">Bartender</option>
                <option value="Accountant">Accountant</option>
            </select>
        </td>
    </tr>
   <tr>
       <td><lable>Pay</lable></td>
       <td>
           <input type="number" name ="pay" id="pay">
       </td>
   </tr>
    <td>
        <lable>Status</lable>
    </td>
    <td>
        <select name="status" id="status">
            <option value="1" selected>Active</option>
            <option value="0">Inactivity</option>
        </select>
    </td>
    </tr>
    <tr>
        <td>
            <lable>Description</lable>
        </td>
        <td>
            <textarea name="description" id="description" cols="30" rows="10" style="resize: none"></textarea>
        </td>
    </tr>
    <tr>
        <td>
            <button></button>
        </td>
        <td>
            <button type="submit">Create</button>
        </td>
    </tr>
</table>
</form>
<div class="row">
    <div id="footer" class="col-md-12">
        <p style="color: green">
            <c:if test='${requestScope["sucsess"] != null}'>
                <span class="message">${requestScope["sucsess"]}</span>
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
            <c:if test='${requestScope["error"] != null}'>
                <span class="message">${requestScope["error"]}</span>
            </c:if>
        </p>
    </div>
</div>

</body>
<script src="/assest/js/input-image.js">

    // function openFile(event) {
    //     var input = event.target;
    //
    //     var reader = new FileReader();
    //     reader.onload = function () {
    //         var dataURL = reader.result;
    //         var output = document.getElementById('output');
    //         output.src = dataURL;
    //         document.getElementById("base64").value = dataURL;
    //     }
    //     reader.readAsDataURL(input.files[0]);
    // };
</script>
</html>
