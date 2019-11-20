package controller;

import model.Staff;

import service.StaffJDBCServiceImpl;
import service.StaffService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StaffServlet ", urlPatterns = "/staffs")

    public class StaffServlet extends javax.servlet.http.HttpServlet {
        private StaffService staffService = new StaffJDBCServiceImpl();
        protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    createStaff(request,response);
                    break;
                case "edit":
                    updateStaff(request,response);
                    break;
                case "delete":
                    deleteStaff(request,response);
                    break;
                default:
                    listStaff(request,response);
                    break;
            }
        }

        protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    showCreateFormStaff(request,response);
                    break;
                case "edit":
                    showEditFormStaff(request,response);
                    break;
                case "delete":
                    showDeleteFormStaff(request,response);
                    break;
                case "view":
                    viewStaff(request,response);
                    break;
                default:
                    listStaff(request,response);
                    break;
            }
        }
        private void listStaff(HttpServletRequest request, HttpServletResponse response) {
            List<Staff> staffs = this.staffService.findAll();
            request.setAttribute("staffs", staffs);

            RequestDispatcher dispatcher = request.getRequestDispatcher("staff/list.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        private void createStaff(HttpServletRequest request, HttpServletResponse response) {
            String name = request.getParameter("name");
            String userName = request.getParameter("userName");
            int age = Integer.parseInt(request.getParameter("age"));
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phoneNumber");
            String gender =request.getParameter("gender");
            String createBy = request.getParameter("createBy");

            Staff staffs = new Staff(name,userName,age, address, phoneNumber,gender,createBy);
            this.staffService.save(staffs);
            RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
            request.setAttribute("message", "New staff was created");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    private void deleteStaff(HttpServletRequest request, HttpServletResponse response) {
        int idStaff = Integer.parseInt(request.getParameter("idStaff"));
        String deleteBy = request.getParameter("deleteBy");

        Staff staff = this.staffService.findById(idStaff);
        RequestDispatcher dispatcher;
        if(staff == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            staff.setDeleteBy(deleteBy);
            this.staffService.remove(idStaff,staff);
            request.setAttribute("staffInformation", staff);
            request.setAttribute("message", "Staff information was deleted ");
            dispatcher = request.getRequestDispatcher("staff/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
        private void showCreateFormStaff(HttpServletRequest request, HttpServletResponse response) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        private void updateStaff(HttpServletRequest request, HttpServletResponse response) {
            int idStaff = Integer.parseInt(request.getParameter("idStaff"));
            String name = request.getParameter("name");
            String useName = request.getParameter("useName");
            String pass = request.getParameter("pass");
            int age = Integer.parseInt(request.getParameter("age"));
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phoneNumber");
            String gender = request.getParameter("gender");
            String modifyBy = request.getParameter("modifyBy");
            Staff staff = staffService.findById(idStaff);
            RequestDispatcher dispatcher;
            if(staff == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                staff.setName(name);
                staff.setUserName(useName);
                staff.setPass(pass);
                staff.setAge(age);
                staff.setAddress(address);
                staff.setPhoneNumber(phoneNumber);
                staff.setGender(gender);
                staff.setModifyBy(modifyBy);

                this.staffService.update(idStaff, staff);
                request.setAttribute("/staffInformation", staff);
                request.setAttribute("message", "Staff information was updated");
                dispatcher = request.getRequestDispatcher("staff/edit.jsp");
            }
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        private void showEditFormStaff(HttpServletRequest request, HttpServletResponse response) {
            int idStaff = Integer.parseInt(request.getParameter("idStaff"));
            Staff staff= this.staffService.findById(idStaff);
            RequestDispatcher dispatcher;
            if(staff == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("staffInformation", staff);
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
        private void showDeleteFormStaff(HttpServletRequest request, HttpServletResponse response) {
            int idStaff = Integer.parseInt(request.getParameter("idStaff"));
            Staff staff = this.staffService.findById(idStaff);
            RequestDispatcher dispatcher;
            if(staff == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("staffInformation", staff);
                dispatcher = request.getRequestDispatcher("staff/delete.jsp");
            }
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        private void viewStaff(HttpServletRequest request, HttpServletResponse response) {
            int idStaff = Integer.parseInt(request.getParameter("idStaff"));
            Staff staff = this.staffService.findById(idStaff);
            RequestDispatcher dispatcher;
            if(staff == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("staffInformation", staff);
                dispatcher = request.getRequestDispatcher("staff/view.jsp");
            }
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }

    }
