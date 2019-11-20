package controller;

import model.Brand;
import model.Phone;
import service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhoneServlet", urlPatterns = "/phones")
public class PhoneServlet extends HttpServlet {
    private PhoneService phoneServlet = new PhoneJDBCServiceImpl();
    private BrandService brandServlet = new BrandJDBCServiceImpl();
    private DetailStockService detailStockService = new DetailStockJDBCServiceImpl();
    private DetailStoreService detailStoreService = new DetailStoreJBDCServiceImpl.DetailStoreJDBCServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createPhone(request,response);
                break;
            case "edit":
                editPhone(request,response);
                break;
            case "delete":
                deletePhone(request,response);
                break;
            default:
                break;
        }
    }

    private void searchPhone(HttpServletRequest request, HttpServletResponse response) {
        String inputValue = request.getParameter("inputValue");
        List<Phone> phones = this.phoneServlet.findByName(inputValue);
        request.setAttribute("phonesList", phones);
        RequestDispatcher dispatcher = request.getRequestDispatcher("phone/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void createPhone(HttpServletRequest request, HttpServletResponse response) {
        int idPhone = 0;
        String name = request.getParameter("name");
        int idBrand = Integer.parseInt(request.getParameter("idBrand"));
        String information = request.getParameter("information");
        String image = request.getParameter("image");
        String createBy = request.getParameter("createBy");

        Phone phone = new Phone(idPhone,name,0,information,image,idBrand,null,null,null,null,createBy,null);
        this.phoneServlet.save(phone);
        RequestDispatcher dispatcher = request.getRequestDispatcher("phone/create.jsp");
        request.setAttribute("message","New phone was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editPhone(HttpServletRequest request, HttpServletResponse response) {
        int idPhone  = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String information = request.getParameter("information");
        String image = request.getParameter("image");
        String modifyBy = request.getParameter("modifyBy");
        RequestDispatcher dispatcher;
        Phone phone = this.phoneServlet.findById(idPhone);
        if (phone == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            phone.setName(name);
            phone.setInformation(information);
            phone.setImage(image);
            phone.setModifyBy(modifyBy);
            this.phoneServlet.update(idPhone,phone);
            request.setAttribute("phone", phone);
            request.setAttribute("message", "Phone information was update ");
            dispatcher = request.getRequestDispatcher("phone/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deletePhone(HttpServletRequest request, HttpServletResponse response) {
        int idPhone  = Integer.parseInt(request.getParameter("id"));
        String deleteBy = request.getParameter("deleteBy");
        RequestDispatcher dispatcher;
        Phone phone = this.phoneServlet.findById(idPhone);
        if (phone == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            phone.setDeleteBy(deleteBy);
            this.phoneServlet.remove(idPhone,phone);
            request.setAttribute("phone", phone);
            request.setAttribute("message", "Phone information was deleted ");
            dispatcher = request.getRequestDispatcher("phone/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "viewList":
                listPhoneByBrand(request,response);
                break;
            case "view":
                viewPhone(request,response);
                break;
            case "search":
                searchPhone(request,response);
                break;
            default:
                listPhone(request,response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Brand> brands = this.brandServlet.findAll();
        request.setAttribute("brandList",brands);
        RequestDispatcher dispatcher = request.getRequestDispatcher("phone/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int idPhone = Integer.parseInt(request.getParameter("id"));
        Phone phone = this.phoneServlet.findById(idPhone);
        RequestDispatcher dispatcher;
        if(phone == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            request.setAttribute("phone", phone);
            dispatcher = request.getRequestDispatcher("phone/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int idPhone = Integer.parseInt(request.getParameter("id"));
        Phone phone = this.phoneServlet.findById(idPhone);
        RequestDispatcher dispatcher;
        if(phone == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            request.setAttribute("phone", phone);
            dispatcher = request.getRequestDispatcher("phone/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewPhone(HttpServletRequest request, HttpServletResponse response) {
        int idPhone = Integer.parseInt(request.getParameter("id"));
        Phone phone = this.phoneServlet.findById(idPhone);
        RequestDispatcher dispatcher;
        if(phone == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else {
            request.setAttribute("phone", phone);
            dispatcher = request.getRequestDispatcher("phone/view.jsp");
        }try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listPhoneByBrand(HttpServletRequest request, HttpServletResponse response) {
        int idBrand = Integer.parseInt(request.getParameter("id"));
        List<Phone> phones = this.phoneServlet.findAllByIdBrand(idBrand);
        request.setAttribute("phonesList", phones);
        RequestDispatcher dispatcher = request.getRequestDispatcher("phone/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void listPhone(HttpServletRequest request, HttpServletResponse response) {
        List<Phone> phones = this.phoneServlet.findAll();
        request.setAttribute("phonesList", phones);
        RequestDispatcher dispatcher = request.getRequestDispatcher("phone/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
