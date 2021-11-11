package demo_coffee.controller;

import demo_coffee.model.Staff;
import demo_coffee.service.AccountService;
import demo_coffee.model.Account;
import demo_coffee.service.StaffService;

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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request,response);
                break;
            case "edit":
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    saveAccount(request,response) ;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":

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

    private void showCreate(HttpServletRequest request, HttpServletResponse response){
        List<Staff> staffList = staffService.listStaffNotHaveAccount();
        request.setAttribute("listStaffActive",staffList);
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
        List<Staff> staffList = staffService.findAllActive();
        request.setAttribute("listStaffActive",staffList);

        int idUser = Integer.parseInt(request.getParameter("full_name"));
        String username = request.getParameter("username") ;
        String pass1= request.getParameter("enter_password") ;
        String pass2= request.getParameter("confirm_password") ;
        String permission = request.getParameter("permission");
        Boolean status = true;
        int value = Integer.parseInt(request.getParameter("status"));
        if (value != 1) {
            status = false;
        }

        boolean check_pass = pass1.equals(pass2) ;

        boolean checkAll = true ;

        if(checkAll){
            Account account = new Account(idUser,username,pass1,permission,status);
            boolean isInsert = accountService.save(account);
            if (isInsert) {
                request.setAttribute("sucsess", " **** Them nhan thanh cong ");
            } else
                request.setAttribute("error", " **** Them khach hang khong thanh cong, hay thu lai");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("account/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
