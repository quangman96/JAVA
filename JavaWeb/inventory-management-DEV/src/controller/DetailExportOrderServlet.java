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

@WebServlet(name = "DetailImportOrderServlet", urlPatterns = "/detailExportOrders")
public class DetailExportOrderServlet extends HttpServlet {
    private DetailExportOrderService detailExportOrderServices = new DetailExportOrderJDBCServiceImpl.DetailExportOrderJDBCService();
//    private StaffService staffService = new StaffJDBCServiceImpl();
//    private ExportService exportService = new ExportOrderJDBCServiceImpl();
//    private StockService stockService = new StockJDBCServiceImpl();
//    private StoreService storeService = new StoreJBDCServiceImpl();
//    private PhoneService PhoneService = new PhoneJDBCServiceImpl();

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

                break;
        }
    }

    private void viewlist(HttpServletRequest request, HttpServletResponse response) {
        int idExportOrder = Integer.parseInt(request.getParameter("idExportOrder"));
        List<DetailExportOrder> detailExportOrders = this.detailExportOrderServices.findByIDExportOrder(idExportOrder);
//        List<Staff> staffs = this.staffService.findAll();
//        List<Stock> stocks = this.stockService.findAll();
//        List<Store> stores = this.storeService.findallStore();
//        List<Phone> phones = this.PhoneService.findAll();
//        List<ExportOrder> exportOrders = this.exportService.findAll();
//        request.setAttribute("staffList",staffs);
//        request.setAttribute("storeList",stores);
//        request.setAttribute("stockList",stocks);
//        request.setAttribute("phoneList",phones);
//        request.setAttribute("exportOrderList",exportOrders);
        RequestDispatcher dispatcher;
        if(detailExportOrders == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            request.setAttribute("detailExportOrder",detailExportOrders);
            dispatcher = request.getRequestDispatcher("detailExportOrder/list.jsp");
        }
        try{
            dispatcher.forward(request,response);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }
}


