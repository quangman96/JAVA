package controller;

import model.Store;
import service.StoreJBDCServiceImpl;
import service.StoreService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StoreServlet", urlPatterns = "/stores")
public class StoreServlet extends javax.servlet.http.HttpServlet {
    private StoreService storeService = new StoreJBDCServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStore(request, response);
                break;
            case "edit":
                updateStore(request, response);
                break;
            case "delete":
                deleteStore(request, response);
                break;
            default:
                listStore(request, response);
                break;
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateFormStore(request, response);
                break;
            case "edit":
                showEditFormStore(request, response);
                break;
            case "delete":
                showDeleteFormStore(request, response);
                break;
            case "view":
                viewStore(request, response);
            default:
                listStore(request, response);
                break;
        }
    }

    private void listStore(HttpServletRequest request, HttpServletResponse response) {
        List<Store> stores = this.storeService.findallStore();
        request.setAttribute("stores", stores);

        RequestDispatcher dispatcher = request.getRequestDispatcher("store/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createStore(HttpServletRequest request, HttpServletResponse response) {
        String nameStore = request.getParameter("nameStore");
        String addressStore = request.getParameter("addressStore");
        String PhoneNumberStore = request.getParameter("PhoneNumberStore");
        String createBy = request.getParameter("createBy");
        Store stores = new Store(nameStore, addressStore, PhoneNumberStore, createBy);
        this.storeService.saveStore(stores);
        RequestDispatcher dispatcher = request.getRequestDispatcher("store/create.jsp");
        request.setAttribute("message", "New store was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateFormStore(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("store/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateStore(HttpServletRequest request, HttpServletResponse response) {
        int idStore = Integer.parseInt(request.getParameter("idStore"));
        String nameStore = request.getParameter("nameStore");
        String addressStore = request.getParameter("addressStore");
        String PhoneNumberStore = request.getParameter("PhoneNumberStore");
        String modifyBy = request.getParameter("modifyBy");
        Store stores = storeService.findByIdStore(idStore);
        RequestDispatcher dispatcher;
        if (stores == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            stores.setNameStore(nameStore);
            stores.setPhoneNumberStore(PhoneNumberStore);
            stores.setAddressStore(addressStore);
            stores.setModifyBy(modifyBy);
            this.storeService.updateStore(idStore, stores);
            request.setAttribute("stores", stores);
            request.setAttribute("message", "Store information was updated");
            dispatcher = request.getRequestDispatcher("store/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditFormStore(HttpServletRequest request, HttpServletResponse response) {
        int idStore = Integer.parseInt(request.getParameter("idStore"));
        Store stores = this.storeService.findByIdStore(idStore);
        RequestDispatcher dispatcher;
        if (stores == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("stores", stores);
            dispatcher = request.getRequestDispatcher("store/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteStore(HttpServletRequest request, HttpServletResponse response) {
        int idStore = Integer.parseInt(request.getParameter("idStore"));
        String deleteBy = request.getParameter("deleteBy");
        Store stores = this.storeService.findByIdStore(idStore);
        RequestDispatcher dispatcher;
        if (stores == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.storeService.removeStore(idStore, deleteBy);
            try {
                response.sendRedirect("/stores");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showDeleteFormStore(HttpServletRequest request, HttpServletResponse response) {
        int idStore = Integer.parseInt(request.getParameter("idStore"));
        Store stores = this.storeService.findByIdStore(idStore);
        RequestDispatcher dispatcher;
        if (stores == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("stores", stores);
            dispatcher = request.getRequestDispatcher("store/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewStore(HttpServletRequest request, HttpServletResponse response) {
        int idStore = Integer.parseInt(request.getParameter("idStore"));
        Store stores = this.storeService.findByIdStore(idStore);
        RequestDispatcher dispatcher;
        if (stores == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("stores", stores);
            dispatcher = request.getRequestDispatcher("store/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
