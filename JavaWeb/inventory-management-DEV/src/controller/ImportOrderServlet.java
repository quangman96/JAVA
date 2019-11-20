package controller;

import model.*;
import service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ImportOrderServlet", urlPatterns = "/importOrders")
public class ImportOrderServlet extends HttpServlet {
    private ImportOrderService importOrderService = new ImportOrderJDBCServiceImpl();
    private StaffService staffServive = new StaffJDBCServiceImpl();
    private StockService stockService = new StockJDBCServiceImpl();
    private PhoneService PhoneService = new PhoneJDBCServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createImportOrder(request, response);
                break;
            case "edit":
                editImportOrder(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }
    }

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
            case "view":

                break;
            default:
                ListImportOrder(request, response);
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int idImportOrder = Integer.parseInt(request.getParameter("id"));
        ImportOrder importOrder = this.importOrderService.findById_for_del(idImportOrder);
        RequestDispatcher dispatcher;
        if (importOrder == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("deleteImportOrder", importOrder);
            dispatcher = request.getRequestDispatcher("importOrder/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idImportOrder = Integer.parseInt(request.getParameter("id"));
        try {
            this.importOrderService.remove(idImportOrder);
            response.sendRedirect("/importOrders");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void editImportOrder(HttpServletRequest request, HttpServletResponse response) {
        int idImportOrder = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String modifyBy = request.getParameter("modifyBy");
        RequestDispatcher dispatcher;
        ImportOrder importOrder = this.importOrderService.findById(idImportOrder);
        if (importOrder == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            importOrder.setName(name);
            importOrder.setModifyBy(modifyBy);
            this.importOrderService.update(idImportOrder, importOrder);
            request.setAttribute("importOrder", importOrder);
            request.setAttribute("message", "Product information was updated");
            dispatcher = request.getRequestDispatcher("importOrder/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
            int idImportOrder = Integer.parseInt(request.getParameter("id"));
            ImportOrder importOrder = this.importOrderService.findById(idImportOrder);
            RequestDispatcher dispatcher;
            if (importOrder == null) {
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("showEditImportOrder", importOrder);
                dispatcher = request.getRequestDispatcher("importOrder/edit.jsp");
            }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void ListImportOrder(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<ImportOrder> importOrders = this.importOrderService.findAll();
            request.setAttribute("importOrderList", importOrders);
            RequestDispatcher dispatcher = request.getRequestDispatcher("importOrder/list.jsp");
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Staff> staff = this.staffServive.findAll();
        List<Stock> stock = this.stockService.findAll();
        List<Phone> phones = this.PhoneService.findAll();
        request.setAttribute("staff", staff);
        request.setAttribute("stock", stock);
        request.setAttribute("phoneList",phones);
        RequestDispatcher dispatcher = request.getRequestDispatcher("importOrder/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createImportOrder(HttpServletRequest request, HttpServletResponse response) {
        int idImportOrder = (int) (Math.random() * 10000);
        int idStaff = Integer.parseInt(request.getParameter("idStaff"));
        int idStock = Integer.parseInt(request.getParameter("idStock"));
        int idPhone = Integer.parseInt(request.getParameter("idPhone2"));
        int amountPhone = Integer.parseInt(request.getParameter("AmountPhone"));
        String name = request.getParameter("name");
        String createBy = request.getParameter("createBy");
        RequestDispatcher dispatcher;
        Phone phone = this.PhoneService.findById(idPhone);
        if (phone == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            phone.setAmount(phone.getAmount()+amountPhone);
            this.PhoneService.update(idPhone,phone);
            request.setAttribute("phone", phone);
        }
        ImportOrder importOrder = new ImportOrder(idImportOrder, name, idStaff, idStock, createBy);
        this.importOrderService.save(importOrder);
        dispatcher = request.getRequestDispatcher("importOrder/create.jsp");
        request.setAttribute("message", "New importOrder was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}


