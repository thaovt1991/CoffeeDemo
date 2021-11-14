package demo_coffee.controller;

import demo_coffee.model.Staff;
import demo_coffee.service.AccountService;
import demo_coffee.model.Account;
import demo_coffee.service.StaffService;
import demo_coffee.units.Regex;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AccountServlet", value = "/accounts")
public class AccountServlet extends HttpServlet {

    AccountService accountService = new AccountService();
    StaffService staffService = new StaffService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (LoginServlet.accountLogin == null || LoginServlet.staffOfAccount == null) {
            request.setAttribute("messageLoginError", "Login error !");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("staffOfAccount", LoginServlet.staffOfAccount);
            request.setAttribute("accountLogin", LoginServlet.accountLogin);
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    showCreate(request, response);
                    break;
                case "edit":
                    showEditAccount(request, response);
                    break;

                case "restore":

                    break;
                case "details":

                    break;
                case "search":

                    break;
                case "list_inactive":

                    break;
                case "search_inactive":

                    break;
                case "remove":

                    break;
                default:
                    listAccountActive(request, response);
                    break;
            }
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
                    saveAccount(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateAccount(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "create_account":
                break;
            case "delete":

                break;
            case "search":

                break;
            case "restore":

                break;
            case "search_inactive":

                break;
            case "remove":

                break;
            default:
                break;
        }
    }

    private void listAccountActive(HttpServletRequest request, HttpServletResponse response) {
        List<Account> listAccountActive = accountService.findAllActive();
        request.setAttribute("listAcount", listAccountActive);


        List<Staff> staffList = staffService.findAll();
        List<Staff> staffListHaveAccount = new ArrayList<>();
        for (Account account : listAccountActive) {
            for (Staff staff : staffList) {
                if (account.getIdUser() == staff.getId()) {
                    staffListHaveAccount.add(staff);
                }
            }
        }

        request.setAttribute("staffListHaveAccount", staffListHaveAccount);


        RequestDispatcher dispatcher = request.getRequestDispatcher("account/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Staff> staffList = staffService.listStaffNotHaveAccount();
        request.setAttribute("listStaffActive", staffList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("account/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int idUser = Integer.parseInt(request.getParameter("full_name"));
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
        } else if (!pass1.equals(pass2)) {
            request.setAttribute("errorPass2", "Passwords are not the same");
        } else isPass2 = true;
        boolean checkAll = false;

        checkAll = isUsername && isPass1 && isPass2;

        if (checkAll) {
            Account account = new Account(idUser, username, pass1, permission, status);
            boolean isInsert = accountService.save(account);
            if (isInsert) {
                request.setAttribute("sucsess", " ***** Create account success ***** ");
                staffService.updateStatusAccount(idUser);
            } else
                request.setAttribute("error", " **** Create account fail ****");
        } else {
            request.setAttribute("error", " **** Create account fail ****");
        }
        showCreate(request, response);

    }

    private void showEditAccount(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Account account = accountService.findById(id);

        Staff staff = staffService.findById(id);

        RequestDispatcher dispatcher;
        if (account == null || staff == null) {
            request.setAttribute("message", "Not account exist");
            dispatcher = request.getRequestDispatcher("error.jsp");
        } else {
            request.setAttribute("staff", staff);
            request.setAttribute("account", account);
            dispatcher = request.getRequestDispatcher("account/edit.jsp");
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Account account = accountService.findById(id);
        String pass1 = request.getParameter("enter_password");
        String pass2 = request.getParameter("confirm_password");
        String permission = request.getParameter("permission");
        Boolean status = true;
        int value = Integer.parseInt(request.getParameter("status"));
        if (value != 1) {
            status = false;
        }

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
        } else if (!pass1.equals(pass2)) {
            request.setAttribute("errorPass2", "Passwords are not the same");
        } else isPass2 = true;
        boolean checkAll = false;

        checkAll = isPass1 && isPass2;

        if (checkAll) {
            account.setPassword(pass1);
            account.setPermission(permission);
            account.setStatus(status);
            boolean isUpdate = accountService.update(account);
            if (isUpdate) {
                request.setAttribute("sucsess", " ***** Update account success ***** ");
            } else
                request.setAttribute("error", " **** Update account fail  ****");
        } else {
            request.setAttribute("error", " **** Update account fail  ****");
        }
        showEditAccount(request, response);
    }
}
