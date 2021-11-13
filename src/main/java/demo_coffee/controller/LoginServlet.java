package demo_coffee.controller;

import demo_coffee.model.Account;
import demo_coffee.model.Staff;
import demo_coffee.service.AccountService;
import demo_coffee.service.StaffService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    AccountService accountService = new AccountService();
    StaffService staffService = new StaffService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        RequestDispatcher dispatcher = null;
        Account accountLogin = null;
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
            String error ="<script>\n" +
                    "    alert(\"Username or password does not exist\");\n" +
                    "</script>";
            request.setAttribute("error", error);
            dispatcher = request.getRequestDispatcher("index.jsp");
        } else if (accountLogin.isStatus()) {
            List<Staff> staffList = staffService.findAllActive();
            Staff staffOfAccount = new Staff();
            for (Staff st : staffList) {
                if (st.getId() == accountLogin.getIdUser()) {
                    staffOfAccount = st;
                    break;
                }
            }
            if (staffOfAccount != null) {
                request.setAttribute("staff", staffOfAccount);
                dispatcher = request.getRequestDispatcher("home.jsp");
            } else {
                request.setAttribute("error", "Staff has been locked , account don't login");
                dispatcher = request.getRequestDispatcher("index.jsp");
            }
        } else {
            request.setAttribute("error", "Account has been locked");
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
}

