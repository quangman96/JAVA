package controller;

import model.DetailStore;
import service.DetailStoreJBDCServiceImpl;
import service.DetailStoreService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailStoreServlet", urlPatterns = "/detailstores")
public class DetailStoreServlet extends HttpServlet {
    private DetailStoreService detailStoreService = new DetailStoreJBDCServiceImpl.DetailStoreJDBCServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                //showCreateFormStore(request,response);
                break;
            case "edit":
               // showEditFormStore(request,response);
                break;
            case "delete":
               // showDeleteFormStore(request,response);
                break;
            case "view":
                viewlist(request,response);
                break;
            default:
                listDetailStore(request,response);
                break;
        }
    }

    private void viewlist(HttpServletRequest request, HttpServletResponse response) {
        int idStore = Integer.parseInt(request.getParameter("idStore"));
        List<DetailStore> detailStore = this.detailStoreService.findByIDStore(idStore);
        RequestDispatcher dispatcher;
        if(detailStore == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else{
            request.setAttribute("detailstore",detailStore);
            dispatcher = request.getRequestDispatcher("detailStore/list.jsp");
        }
        try{
            dispatcher.forward(request,response);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }

    private void listDetailStore(HttpServletRequest request, HttpServletResponse response) {
        List<DetailStore> detailstore = this.detailStoreService.findalldetailStore();
        request.setAttribute("detailstore", detailstore);

        RequestDispatcher dispatcher = request.getRequestDispatcher("detailStore/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

