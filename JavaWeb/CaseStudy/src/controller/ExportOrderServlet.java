package controller;

import model.ExportOrder;
import service.ExportOrderJDBCServiceImpl;
import service.ExportService;

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
//    private ExportServiceI exportService = new ExportOrderJDBCServiceImpl();
    private ExportService exportService = new ExportOrderJDBCServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String search = request.getParameter("txtSearch");
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");

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
                viewCustomer(request, response);
                break;
            default:
                listExportOrder(request, response);
                break;
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
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
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("exportOrder/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listExportOrder(HttpServletRequest request, HttpServletResponse response) {
        List<ExportOrder> exportOrders = this.exportService.findAll();
        request.setAttribute("exportOrders", exportOrders);

        RequestDispatcher dispatcher = request.getRequestDispatcher("exportOrder/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
        String createBy = request.getParameter("createBy");
//        String createDate = request.getParameter("createDate");
        int idExportOrder = (int) (Math.random() * 10000);

        ExportOrder exportOrder = new ExportOrder(idExportOrder,name,null,null,createBy,null,null,null);
        this.exportService.save(exportOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("exportOrder/create.jsp");
        request.setAttribute("message", "New exportOrder was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
