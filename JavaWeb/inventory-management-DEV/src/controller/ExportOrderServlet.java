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
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "ExportOrderServlet",urlPatterns = "/exportOrder")
public class ExportOrderServlet extends HttpServlet {
    private StaffService staffService = new StaffJDBCServiceImpl();
    private ExportService exportService = new ExportOrderJDBCServiceImpl();
    private StockService stockService = new StockJDBCServiceImpl();
    private StoreService storeService = new StoreJBDCServiceImpl();
    private PhoneService PhoneService = new PhoneJDBCServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createExportOrder(request,response);
                break;
            case "edit":
                updateExportOrder(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
                break;
        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
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
                viewDetail(request, response);
                break;
            default:
                listExportOrder(request, response);
                break;
        }
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) {
        int idExportOrder = Integer.parseInt(request.getParameter("idExportOrder"));
        ExportOrder exportOrder = this.exportService.findById(idExportOrder);
        RequestDispatcher dispatcher;
        if(exportOrder == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("exportOrder", exportOrder);
            dispatcher = request.getRequestDispatcher("exportOrder/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int idExportOrder = Integer.parseInt(request.getParameter("id"));
        ExportOrder exportOrder = this.exportService.findById(idExportOrder);
        RequestDispatcher dispatcher;
        if(exportOrder == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("exportOrder", exportOrder);
            dispatcher = request.getRequestDispatcher("exportOrder/delete.jsp");
        }
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
        ExportOrder exportOrder = this.exportService.findById(id);
        RequestDispatcher dispatcher;
        if(exportOrder == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("exportOrder", exportOrder);
            dispatcher = request.getRequestDispatcher("exportOrder/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Staff> staffs = this.staffService.findAll();
        List<Stock> stocks = this.stockService.findAll();
        List<Store> stores = this.storeService.findallStore();
        List<Phone> phones = this.PhoneService.findAll();
        request.setAttribute("staffList",staffs);
        request.setAttribute("storeList",stores);
        request.setAttribute("stockList",stocks);
        request.setAttribute("phoneList",phones);

        RequestDispatcher dispatcher = request.getRequestDispatcher("exportOrder/create.jsp");
        try {
            dispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listExportOrder(HttpServletRequest request, HttpServletResponse response) {
        List<ExportOrder> exportOrders = this.exportService.findAll();
        request.setAttribute("exportOrders", exportOrders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("exportOrder/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idExportOrder = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String deleteBy = request.getParameter("deleteBy");
        ExportOrder exportOrder = this.exportService.findById(idExportOrder);
        RequestDispatcher dispatcher;
        if(exportOrder == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            exportOrder.setName(name);
            exportOrder.setDeleteBy(deleteBy);
            this.exportService.remove(idExportOrder,exportOrder);
            request.setAttribute("exportOrder",exportOrder);
            request.setAttribute("message","Export Order was deleted");
            dispatcher = request.getRequestDispatcher("exportOrder/delete.jsp");
            try {
                response.sendRedirect("/exportOrder");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateExportOrder(HttpServletRequest request, HttpServletResponse response) {
        int idExportOrder = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
//        String createBy = request.getParameter("createBy");
        String modifyBy = request.getParameter("modifyBy");

        ExportOrder exportOrder = this.exportService.findById(idExportOrder);
        RequestDispatcher dispatcher;
        if(exportOrder == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            exportOrder.setName(name);
            exportOrder.setModifyBy(modifyBy);

            this.exportService.update(idExportOrder, exportOrder);
            request.setAttribute("exportOrder", exportOrder);
            request.setAttribute("message", "Customer information was updated");
            dispatcher = request.getRequestDispatcher("exportOrder/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createExportOrder(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int idStaff = Integer.parseInt(request.getParameter("idStaff"));
        int idStore = Integer.parseInt(request.getParameter("idStore"));
        int idStock = Integer.parseInt(request.getParameter("idStock"));
        String createBy = request.getParameter("createBy");
        int idExportOrder = (int) (Math.random() * 10000);

        ExportOrder exportOrder = new ExportOrder(idStore,idStock,idStaff,name,createBy);
        this.exportService.save(exportOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("exportOrder/create.jsp");
        request.setAttribute("message", "New exportOrder was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
