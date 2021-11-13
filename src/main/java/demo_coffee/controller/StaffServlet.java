package demo_coffee.controller;

import demo_coffee.model.Account;
import demo_coffee.service.AccountService;
import demo_coffee.service.StaffService;
import demo_coffee.model.Staff;
import demo_coffee.units.Regex;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StaffServlet", value = "/staffs")
public class StaffServlet extends HttpServlet {

    StaffService staffService = new StaffService();
    AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "restore":
                showRestoreForm(request, response);
                break;
            case "details":
                showStaffInformation(request, response);
                break;
            case "search":
                showSearch(request, response);
                break;
            case "list_inactive":
                listStaffsInactive(request, response);
                break;
            case "search_inactive":
                showSearchInactive(request, response);
                break;
            case "remove":
                showRemove(request, response);
                break;
            case "create_account":
                showCreateAccount(request, response);
                break;
            default:
                listStaffs(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createStaff(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateStaff(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                deleteStaff(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "restore":
                restoreStaff(request, response);
                break;
            case "search_inactive":
                searchInactive(request, response);
                break;
            case "remove":
                remove(request, response);
                break;
            case "create_account":
                try {
                    createAccount(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    private void listStaffs(HttpServletRequest request, HttpServletResponse response) {
        List<Staff> listStaffs = staffService.findAllActive();
        request.setAttribute("listStaffs", listStaffs);
//        List<Staff> staffListHaveNotHaveAcount = staffService.listStaffNotHaveAccount();
//        request.setAttribute("staffListHaveNotHaveAcount", staffListHaveNotHaveAcount);

        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listStaffsInactive(HttpServletRequest request, HttpServletResponse response) {
        List<Staff> listStaffs = staffService.findAllInactive();
        request.setAttribute("listStaffs", listStaffs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/list_inactive.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String full_name = request.getParameter("full_name");
        String gender = request.getParameter("gender");
        String date_of_birth = request.getParameter("date_of_birth");
        String id_card = request.getParameter("id_card");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String image = request.getParameter("image");
        String position = request.getParameter("position");
        String stPay = request.getParameter("pay");
        if (stPay.equals("")) {
            stPay = "0";
        }
        Long pay = Long.parseLong(stPay);
        Boolean status = true;
        int value = Integer.parseInt(request.getParameter("status"));
        if (value != 1) {
            status = false;
        }
        String description = request.getParameter("description");

        boolean isTrueAll = false;
        boolean isName = false;
        if (full_name.equals("")) {
            request.setAttribute("messageFullName", "* Name cannot be left blank ");
        } else if (!Regex.isFullNameValidator(full_name)) {
            request.setAttribute("messageFullName", "* Can not name format ");
        } else {
            isName = true;
            request.setAttribute("full_name", full_name);
        }

        boolean isDay = false;
        if (date_of_birth.equals("")) {
            request.setAttribute("messageDateOfBirth", "* Date of birth cannot be left blank ");
        } else isDay = true;

        boolean isIdCard = false;
        if (id_card.equals("")) {
            request.setAttribute("messageIdCard", "* Id Card cannot be left blank ");
        } else if (!Regex.isIdCardValidator(id_card)) {
            request.setAttribute("messageIdCard", "* Id Card must have 9-11 digits");
        } else isIdCard = true;

        boolean isEmail = false;
        if (!email.equals("")) {
            if (!Regex.isEmailValidator(email)) {
                request.setAttribute("messageEmail", "* Email not validate ");
            } else isEmail = true;
        } else isEmail = true;

        boolean isPhoneNumber = false;
        if (!phone.equals("")) {
            if (!Regex.isPhoneNumber(phone)) {
                request.setAttribute("messagePhone", "* Phone not validate ");
            } else isPhoneNumber = true;
        } else isPhoneNumber = true;


        isTrueAll = isName && isDay && isIdCard && isEmail && isPhoneNumber;

        if (isTrueAll) {
            Staff staff = new Staff(full_name, gender, date_of_birth, id_card, email, phone, address, image, position, pay, status, description);

            boolean isInsert = staffService.save(staff);

            if (isInsert) {
                request.setAttribute("sucsess", " **** Add Success ! ****");
            } else
                request.setAttribute("error", " **** Add Fail ! Please check again ! ****");
        } else
            request.setAttribute("error", " **** Add Fail ! Please check again ! ****");

        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.findById(id);


        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("staff", staff);
            dispatcher = request.getRequestDispatcher("staff/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;

    private void updateStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int id = Integer.parseInt(request.getParameter("id"));
        String full_name = request.getParameter("full_name");
        String gender = request.getParameter("gender");
        String date_of_birth = request.getParameter("date_of_birth");
        String id_card = request.getParameter("id_card");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String image = request.getParameter("image");
        String position = request.getParameter("position");
        Long pay = Long.parseLong(request.getParameter("pay"));
        Boolean status = true;
        int value = Integer.parseInt(request.getParameter("status"));
        if (value != 1) {
            status = false;
        }
        String description = request.getParameter("description");

        Staff staff = staffService.findById(id);
        if (image == "") {
            image = staff.getImage();
        }

        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {

            boolean isTrueAll = false;
            boolean isName = false;
            if (full_name.equals("")) {
                request.setAttribute("messageFullName", "* Name cannot be left blank ");
            } else if (!Regex.isFullNameValidator(full_name)) {
                request.setAttribute("messageFullName", "* Can not name format ");
            } else isName = true;

            boolean isDay = false;
            if (date_of_birth.equals("")) {
                request.setAttribute("messageDateOfBirth", "* Date of birth cannot be left blank ");
            } else isDay = true;

            boolean isIdCard = false;
            if (id_card.equals("")) {
                request.setAttribute("messageIdCard", "* Id Card cannot be left blank ");
            } else if (!Regex.isIdCardValidator(id_card)) {
                request.setAttribute("messageIdCard", "* Id Card must have 9-11 digits");
            } else isIdCard = true;

            boolean isEmail = false;
            if (!email.equals("")) {
                if (!Regex.isEmailValidator(email)) {
                    request.setAttribute("messageEmail", "* Email not validate ");
                } else isEmail = true;
            } else isEmail = true;

            boolean isPhoneNumber = false;
            if (!phone.equals("")) {
                if (!Regex.isPhoneNumber(phone)) {
                    request.setAttribute("messagePhone", "* Phone not validate ");
                } else isPhoneNumber = true;
            } else isPhoneNumber = true;


            isTrueAll = isName && isDay && isIdCard && isEmail && isPhoneNumber;

            if (isTrueAll) {
                staff.setFullName(full_name);
                staff.setGender(gender);
                staff.setDateOfBirth(date_of_birth);
                staff.setIdCard(id_card);
                staff.setEmail(email);
                staff.setPhone(phone);
                staff.setAddress(address);
                staff.setImage(image);
                staff.setPosition(position);
                staff.setPay(pay);
                staff.setStatus(status);
                staff.setDescription(description);
                boolean isUpdate = staffService.update(staff);
                if (isUpdate) {
                    request.setAttribute("sucsess", " **** Edit Success ! ****");
                } else
                    request.setAttribute("error", " **** Edit Fail ! Please check again ! ****");

            } else {
                request.setAttribute("error", " **** Edit Fail ! Please check again ! ****");
            }
            request.setAttribute("staff", staff);
        }
        dispatcher = request.getRequestDispatcher("staff/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showStaffInformation(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.findById(id);
        request.setAttribute("staff", staff);

        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/details.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.findById(id);
        request.setAttribute("staff", staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteStaff(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        staffService.delete(id);
        try {
            response.sendRedirect("/staffs");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showRestoreForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.findById(id);
        request.setAttribute("staff", staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/restore.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void restoreStaff(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        staffService.restore(id);
        try {
            response.sendRedirect("/staffs?action=list_inactive");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        String properties = request.getParameter("properties");
        request.setAttribute("search", search);
        request.setAttribute("propertiesSelect", properties);

        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void search(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        String properties = request.getParameter("properties");

        List<Staff> listSearch = staffService.search(properties, search);
        request.setAttribute("listSearch", listSearch);
        request.setAttribute("search", search);
        request.setAttribute("propertiesSelect", properties);

        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showSearchInactive(HttpServletRequest request, HttpServletResponse response) {

        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/search_inactive.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void searchInactive(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        String properties = request.getParameter("properties");

        List<Staff> listSearch = staffService.searchStaffInactive(properties, search);
        request.setAttribute("listSearch", listSearch);
        request.setAttribute("search", search);
        request.setAttribute("propertiesSelect", properties);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/search_inactive.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showRemove(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.findById(id);
        request.setAttribute("staff", staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/remove.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        staffService.removeData(id);
        try {
            response.sendRedirect("/staffs?action=list_inactive");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateAccount(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.findById(id);
        request.setAttribute("staff", staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create_account.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.findById(id);
        request.setAttribute("staff", staff);


        boolean checkAll = false;
        int idUser = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String pass1 = request.getParameter("enter_password");
        String pass2 = request.getParameter("confirm_password");
        String permission = request.getParameter("permission");
        Boolean status = true;
        int value = Integer.parseInt(request.getParameter("status"));
        if (value != 1) {
            status = false;
        }

        boolean isUsername = false;
        if (username.equals("")) {
            request.setAttribute("errorUsername", "Username cannot be left blank");
        } else if (!Regex.isUserNameValidator(username)) {
            request.setAttribute("errorUsername", "Username has 6-16 characters, starting with lowercase letters");
        } else isUsername = true;

        boolean isPass1 = false;
        if (pass1.equals("")) {
            request.setAttribute("errorPass1", "Password cannot be left blank");
        } else if (!Regex.isPasswordHardValidator(pass1)) {
            request.setAttribute("errorPass1s", "Minimum 8 characters, at least one letter, one number and one special character");
        } else isPass1 = true;

        boolean isPass2 = false;
        if (pass2.equals("")) {
            request.setAttribute("errorPass2", "Password cannot be left blank");
        } else if (!Regex.isPasswordHardValidator(pass2)) {
            request.setAttribute("errorPass2", "Minimum 8 characters, at least one letter, one number and one special character");
        } else if(!pass1.equals(pass2)){
            request.setAttribute("errorPass2", "Passwords are not the same");
        }
        else isPass2 = true;

        checkAll = isUsername && isPass1 && isPass2 ;

        if (checkAll) {
            Account account = new Account(idUser, username, pass1, permission, status);
            boolean isInsert = accountService.save(account);
            if (isInsert) {
                request.setAttribute("sucsess", " ***** Create account success ***** ");
            } else
                request.setAttribute("error", " **** Create account fail ****");
        }else{
            request.setAttribute("error", " **** Create account fail ****");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create_account.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}