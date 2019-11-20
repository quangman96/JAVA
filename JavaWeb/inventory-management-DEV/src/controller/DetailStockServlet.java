package controller;

import model.DetailStock;
import service.DetailStockService;
import service.DetailStockJDBCServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailStockServlet", urlPatterns = "/detailstocks")
public class DetailStockServlet extends HttpServlet {

    private DetailStockService detailStockServlet = new DetailStockJDBCServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                //showCreateFormStock(request,response);
                break;
            case "edit":
                // showEditFormStock(request,response);
                break;
            case "delete":
                // showDeleteFormStock(request,response);
                break;
            case "view":
                viewlist(request,response);
                break;
            default:
                listDetailStock(request,response);
                break;
        }
    }

    private void viewlist(HttpServletRequest request, HttpServletResponse response) {
        int idStock = Integer.parseInt(request.getParameter("idStock"));
        List<DetailStock> detailStock = this.detailStockServlet.findByIdStock(idStock);
        RequestDispatcher dispatcher;
        if(detailStock == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            request.setAttribute("detailStock",detailStock);
            dispatcher = request.getRequestDispatcher("detailStock/list.jsp");
        }
        try{
            dispatcher.forward(request,response);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }

    private void listDetailStock(HttpServletRequest request, HttpServletResponse response) {
        List<DetailStock> detailStock = this.detailStockServlet.findAll();
        request.setAttribute("detailstock", detailStock);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailStock/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}