package demo_coffee.controller;

import demo_coffee.model.Account;
import demo_coffee.model.Staff;
import demo_coffee.service.AccountService;
import demo_coffee.service.StaffService;
import demo_coffee.units.Regex;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    static Staff staffOfAccount = null;
    static Account accountLogin = null;
    AccountService accountService = new AccountService();
    StaffService staffService = new StaffService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (accountLogin == null || staffOfAccount == null) {
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
            request.setAttribute("staffOfAccount", staffOfAccount);
            request.setAttribute("accountLogin", accountLogin);
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "home":
                    showHome(request, response);
                    break;
                case "change_password":
                    showChangePassword(request, response);
                    break;
                default:
                    showLogin(request, response);
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
            case "home":
                loginAccount(request, response);
                break;
            case "change_password":
                try {
                    changePassword(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            default:


        }

    }


    public void loginAccount(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher dispatcher = null;
        List<Account> accountList = accountService.findAllActive();
        for (Account account : accountList) {
            if (account.getUsername().equals(username)) {
                if (account.getPassword().equals(password)) {
                    accountLogin = account;
                    break;
                }
            }
        }

        if (accountLogin == null) {
            String error1 = "<script>\n" +
                    "    alert(\"Username or password does not exist\");\n" +
                    "</script>";
            request.setAttribute("message", error1);
            dispatcher = request.getRequestDispatcher("index.jsp");
        } else if (accountLogin.isStatus()) {
            List<Staff> staffList = staffService.findAllActive();

            for (Staff st : staffList) {
                if (st.getId() == accountLogin.getIdUser()) {
                    staffOfAccount = st;
                    break;
                }
            }
            if (staffOfAccount != null) {
                String login_success = "<script>\n" +
                        "    alert(\"Login Success !\");\n" +
                        "</script>";
                request.setAttribute("login_success", login_success);
                request.setAttribute("staffOfAccount", staffOfAccount);
                request.setAttribute("accountLogin", accountLogin);
                dispatcher = request.getRequestDispatcher("home.jsp");
            } else {
                String error2 = "<script>\n" +
                        "    alert(\"Staff has been locked , account don't login\");\n" +
                        "</script>";
                request.setAttribute("message", error2);
                dispatcher = request.getRequestDispatcher("index.jsp");
            }
        } else {
            String error3 = "<script>\n" +
                    "    alert(\"Account has been locked\");\n" +
                    "</script>";
            request.setAttribute("message", error3);
            dispatcher = request.getRequestDispatcher("index.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) {
        staffOfAccount = null;
        accountLogin = null;
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showChangePassword(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("staff", staffOfAccount);
        request.setAttribute("account", accountLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("change_password.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String passOld =request.getParameter("old_password");
        String pass1 = request.getParameter("enter_password");
        String pass2 = request.getParameter("confirm_password");

        Account account = accountLogin ;

        boolean isOldPass = false ;
        if(!account.getPassword().equals(passOld)) {
            request.setAttribute("errorOldPass", "Old password not true !");
        }else isOldPass = true ;

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

        checkAll = isPass1 && isPass2 && isOldPass;

        if (checkAll) {
            account.setPassword(pass1);
            boolean isUpdate = accountService.update(account);
            if (isUpdate) {
                request.setAttribute("sucsess", " ***** Change password success ***** ");
            } else
                request.setAttribute("error", " **** Change password  fail  ****");
        } else {
            request.setAttribute("error", " **** Change password  fail  ****");
        }
        showChangePassword(request, response);
    }

}

