package controller;

import model.DetailExportOrder;
import model.ExportOrder;
import service.DetailExportOrderJDBCServiceImpl;
import service.DetailExportService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailExportOrderServlet",urlPatterns = "/detailExportOrder")
public class DetailExportOrderServlet extends HttpServlet {
    private DetailExportService detailExportService = new DetailExportOrderJDBCServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            case "view":
                viewDetailExportOrder(request, response);
                break;
            default:
                listDetailExportOrder(request, response);
                break;
        }
    }

    private void viewDetailExportOrder(HttpServletRequest request, HttpServletResponse response) {
        int idExportOrder = Integer.parseInt(request.getParameter("idExportOrder"));
        DetailExportOrder detailExportOrder = this.detailExportService.findById(idExportOrder);
        RequestDispatcher dispatcher;
        if(detailExportOrder == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("detailExportOrder", detailExportOrder);
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

    private void listDetailExportOrder(HttpServletRequest request, HttpServletResponse response) {
        List<DetailExportOrder> detailExportOrders = this.detailExportService.findAll();
        request.setAttribute("detailExportOrder",detailExportOrders);

        RequestDispatcher dispatcher = request.getRequestDispatcher("exportOrder/view.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
