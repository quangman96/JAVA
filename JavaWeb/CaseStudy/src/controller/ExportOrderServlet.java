package controller;

import model.ExportOrder;
import service.ExportOrderJDBCServiceImpl;
import service.ExportServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExportOrderServlet",urlPatterns = "/exportorder")
public class ExportOrderServlet extends HttpServlet {
    private ExportServiceImpl exportService = new ExportOrderJDBCServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            case "edit":
                break;
            case "delete":
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
//                showCreateForm(request, response);
                break;
            case "edit":
//                showEditForm(request, response);
                break;
            case "delete":
//                showDeleteForm(request, response);
                break;
            case "view":
//                viewCustomer(request, response);
                break;
            default:
                listExportOrder(request, response);
                break;
        }
    }

    private void listExportOrder(HttpServletRequest request, HttpServletResponse response) {
        List<ExportOrder> exportOrders = this.exportService.findAll();
        request.setAttribute("exportOrder",exportOrders);

        RequestDispatcher dispatcher = request.getRequestDispatcher("exportOrder/list.jsp");
        try{
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
