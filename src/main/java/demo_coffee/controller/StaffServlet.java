package demo_coffee.controller;

import demo_coffee.dao.StaffDAO;
import demo_coffee.model.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StaffServlet", value = "/staffs")
public class StaffServlet extends HttpServlet {

    StaffDAO staffDAO = new StaffDAO();

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
//                showDeleteForm(request, response);
                break;
            case "details":
                // showStaffInformation(request, response);
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
                createStaff(request, response);
                break;
            case "edit":
                break;
            case "create_account":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    private void listStaffs(HttpServletRequest request, HttpServletResponse response) {
        List<Staff> listStaffs = staffDAO.findAll();
        request.setAttribute("listStaffs", listStaffs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/list.jsp");
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


    private void createStaff(HttpServletRequest request, HttpServletResponse response) {
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
        Boolean status = true ;
        int value = Integer.parseInt(request.getParameter("status"));
        if(value !=1){
            status = false ;
        }
        String description = request.getParameter("description");

        if (full_name == "") {
            request.setAttribute("messageFullName", "* Khong duoc de trong ten ");
        }
        if (full_name != "" ) {
            Staff staff = new Staff(full_name, gender,date_of_birth,id_card,email ,phone, address,image,position,pay, status,description);

            boolean isInsert = staffDAO.save(staff);

            if (isInsert) {
                request.setAttribute("sucsess", " **** Them nhan thanh cong ");
            } else
                request.setAttribute("error", " **** Them khach hang khong thanh cong, hay thu lai");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffDAO.findById(id);
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
    };
}
