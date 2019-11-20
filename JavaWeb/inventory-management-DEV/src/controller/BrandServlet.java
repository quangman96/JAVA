package controller;

import model.Brand;
import service.BrandJDBCServiceImpl;
import service.BrandService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BrandServlet", urlPatterns = "/brands")
public class BrandServlet extends HttpServlet {
    private BrandService brandServlet = new BrandJDBCServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createBrand(request,response);
                break;
            case "edit":
                editBrand(request,response);
                break;
            case "delete":
                deleteBrand(request,response);
                break;
            default:
                break;
        }
    }

    private void deleteBrand(HttpServletRequest request, HttpServletResponse response) {
        int idBrand = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String deleteBy = request.getParameter("deleteBy");

        Brand brand = this.brandServlet.findById(idBrand);
        RequestDispatcher dispatcher;
        if(brand == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            brand.setName(name);
            brand.setDeleteBy(deleteBy);
            this.brandServlet.remove(idBrand,brand);
            request.setAttribute("brand", brand);
            request.setAttribute("message", "Brand information was deleted ");
            dispatcher = request.getRequestDispatcher("brand/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editBrand(HttpServletRequest request, HttpServletResponse response) {
        int idBrand = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String modifyBy = request.getParameter("modifyBy");

        Brand brand = this.brandServlet.findById(idBrand);
        RequestDispatcher dispatcher;
        if(brand == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            brand.setName(name);
            brand.setModifyBy(modifyBy);
            this.brandServlet.update(idBrand,brand);
            request.setAttribute("brand", brand);
            request.setAttribute("message", "Brand information was updated");
            dispatcher = request.getRequestDispatcher("brand/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createBrand(HttpServletRequest request, HttpServletResponse response) {
        int idBrand = 0;
        String name = request.getParameter("name");
        String createBy = request.getParameter("createBy");

        Brand brand = new Brand(idBrand,name, null, null, null, null,createBy, null);
        this.brandServlet.save(brand);
        RequestDispatcher dispatcher = request.getRequestDispatcher("brand/create.jsp");
        request.setAttribute("message","New brand was created");
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
            default:
                listBrand(request,response);
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int idBrand = Integer.parseInt(request.getParameter("id"));
        Brand brand = this.brandServlet.findById(idBrand);
        RequestDispatcher dispatcher;
        if(brand == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            request.setAttribute("brand",brand);
            dispatcher = request.getRequestDispatcher("brand/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int idBrand = Integer.parseInt(request.getParameter("id"));
        Brand brand = this.brandServlet.findById(idBrand);
        RequestDispatcher dispatcher;
        if(brand == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            request.setAttribute("brand",brand);
            dispatcher = request.getRequestDispatcher("brand/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("brand/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void listBrand(HttpServletRequest request, HttpServletResponse response) {
        List<Brand> brands = this.brandServlet.findAll();
        request.setAttribute("brandList", brands);
        RequestDispatcher dispatcher =request.getRequestDispatcher("brand/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
