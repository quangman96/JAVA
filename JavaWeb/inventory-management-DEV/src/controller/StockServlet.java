package controller;

import model.Stock;
import service.StockJDBCServiceImpl;
import service.StockService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StockServlet", urlPatterns = "/stocks")
public class StockServlet extends HttpServlet {

    private StockService stockServlet= new StockJDBCServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createStock(request, response);
                break;
            case "edit":
                editStock(request, response);
                break;
            case "delete":
                deleteStock(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteStock(HttpServletRequest request, HttpServletResponse response) {
        int idStock = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String deleteBy = request.getParameter("deleteBy");

        Stock stock = this.stockServlet.findById(idStock);
        RequestDispatcher dispatcher;
        if(stock == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            stock.setName(name);
            stock.setAddress(address);
            stock.setPhoneNumber(phoneNumber);
            stock.setDeleteBy(deleteBy);
            this.stockServlet.remove(idStock,stock);
            request.setAttribute("stock", stock);
            request.setAttribute("message", "Stock information was deleted ");
            dispatcher = request.getRequestDispatcher("stock/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editStock(HttpServletRequest request, HttpServletResponse response) {
        int idStock = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String modifyBy = request.getParameter("modifyBy");

        Stock stock = this.stockServlet.findById(idStock);
        RequestDispatcher dispatcher;
        if(stock == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            stock.setName(name);
            stock.setAddress(address);
            stock.setPhoneNumber(phoneNumber);
            stock.setModifyBy(modifyBy);
            this.stockServlet.update(idStock,stock);
            request.setAttribute("stock", stock);
            request.setAttribute("message", "Stock information was updated");
            dispatcher = request.getRequestDispatcher("stock/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void createStock(HttpServletRequest request, HttpServletResponse response) {
        int idStock = 0;
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String createBy = request.getParameter("createBy");

        Stock stock = new Stock(idStock,name, address, phoneNumber, null, null, null, null,createBy, null);
        this.stockServlet.save(stock);
        RequestDispatcher dispatcher = request.getRequestDispatcher("stock/create.jsp");
        request.setAttribute("message","New stock was created");
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
                listStock(request,response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("stock/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int idStock = Integer.parseInt(request.getParameter("id"));
        Stock stock = this.stockServlet.findById(idStock);
        RequestDispatcher dispatcher;
        if(stock == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            request.setAttribute("stock",stock);
            dispatcher = request.getRequestDispatcher("stock/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int idStock = Integer.parseInt(request.getParameter("id"));
        Stock stock = this.stockServlet.findById(idStock);
        RequestDispatcher dispatcher;
        if(stock == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            request.setAttribute("stock",stock);
            dispatcher = request.getRequestDispatcher("stock/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listStock(HttpServletRequest request, HttpServletResponse response) {
        List<Stock> stocks = this.stockServlet.findAll();
        request.setAttribute("stockList", stocks);
        RequestDispatcher dispatcher =request.getRequestDispatcher("stock/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
