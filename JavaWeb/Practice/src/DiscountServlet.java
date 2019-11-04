import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float discount_percent = Float.parseFloat(request.getParameter("discount_percent"));

        float discount_amount = (float) (price * discount_percent * 0.1);
        float price_after_discount = (float) (price * discount_amount);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product Discount Calculator\n</h1>");
        writer.println("<h1>Product Description: "+ description + "</h1>");
        writer.println("<h1>Price: "+price+ "</h1>");
        writer.println("<h1>Discount Price: "+ discount_percent + "</h1>");
        writer.println("<h1>Discount Amount: "+discount_amount+"</h1>");
        writer.println("<h1>Discount Price: "+ price_after_discount+"</h1>");
        writer.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/web/discount.jsp").forward(request, response);
    }
}
