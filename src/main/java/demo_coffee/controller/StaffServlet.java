package demo_coffee.controller;

import demo_coffee.service.StaffService;
import demo_coffee.model.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StaffServlet", value = "/staffs")
public class StaffServlet extends HttpServlet {

    StaffService staffService = new StaffService();

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
            case "details":
                showStaffInformation(request, response);
                break;
            case "search":
                showSearch(request, response);
                break;
            case "list_inactive":
                listStaffsInactive(request,response);
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
            case "create_account":
                break;
            case "delete":
                deleteStaff(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "list_inactive":
                restoreStaff(request,response);
                break;
            default:
                break;
        }
    }

    private void listStaffs(HttpServletRequest request, HttpServletResponse response) {
        List<Staff> listStaffs = staffService.findAll();
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
        Long pay = Long.parseLong(request.getParameter("pay"));
        Boolean status = true;
        int value = Integer.parseInt(request.getParameter("status"));
        if (value != 1) {
            status = false;
        }
        String description = request.getParameter("description");

        if (full_name == "") {
            request.setAttribute("messageFullName", "* Khong duoc de trong ten ");
        }
        if (full_name != "") {
            Staff staff = new Staff(full_name, gender, date_of_birth, id_card, email, phone, address, image, position, pay, status, description);

            boolean isInsert = staffService.save(staff);

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
        if (full_name == null) {
            request.setAttribute("messageFullName", "* Khong duoc de trong ten ");
        }
        if (email == null) {
            request.setAttribute("messageEmail", "* Khong duoc de trong email ");
        }
        if (full_name != "" && email != "") {
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
                request.setAttribute("message", " **** Update thanh cong ");
            } else {
                request.setAttribute("update_error", " **** Update khong thanh cong ");
            }
            request.setAttribute("staff", staff);
            dispatcher = request.getRequestDispatcher("staff/edit.jsp");
        } else
            dispatcher = request.getRequestDispatcher("error-404.jsp");
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
    private void restoreStaff(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        staffService.restore(id);
//        try {
//            response.sendRedirect("/staffs");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/staff/list_inactive.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void showSearch(HttpServletRequest request, HttpServletResponse response) {

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
        String nameSearch = request.getParameter("name");

        List<Staff> listSearch = staffService.search(nameSearch);

        request.setAttribute("listSearch", listSearch);
        request.setAttribute("nameSearch", nameSearch);

        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}