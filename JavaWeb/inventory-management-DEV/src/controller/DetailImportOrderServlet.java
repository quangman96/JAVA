package controller;

import model.DetailImportOrder;
import service.DetailImportOrderJDBCServletImpl;
import service.DetailImportOrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailImportOrderServlet",urlPatterns = "/detailImportOrders")
public class DetailImportOrderServlet extends HttpServlet {
    private DetailImportOrderService detailImportOrderServices = new DetailImportOrderJDBCServletImpl.DetailImportOrderJDBCServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
                viewlist(request,response);
                break;
            default:
                viewlist(request,response);
                break;
        }
    }

    private void viewlist(HttpServletRequest request, HttpServletResponse response) {
        int idImportOrder = Integer.parseInt(request.getParameter("idImportOrder"));
        List<DetailImportOrder> detailImportOrders = this.detailImportOrderServices.findByIDImportOrder(idImportOrder);
        RequestDispatcher dispatcher;
        if(detailImportOrders == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            request.setAttribute("detailImportOrder",detailImportOrders);
            dispatcher = request.getRequestDispatcher("detailImportOrder/list.jsp");
        }
        try{
            dispatcher.forward(request,response);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }
}
