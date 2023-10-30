package mk.ukim.finki.vebprogramiranje.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import mk.ukim.finki.vebprogramiranje.service.CategoryService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "category-servlet", urlPatterns = "/servlet/category")
public class CategoryServlet extends HttpServlet {


private final CategoryService categoryService;

    public CategoryServlet(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ipAddress = req.getRemoteAddr();
        String ClientAgent = req.getHeader("user-Agent");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<body>");
        out.println("<h3>User Info </h3>");
        out.format("IP Address: %s<br>",ipAddress);
        out.format("User Agent: %s",ClientAgent);
        out.println("<h3>Category List </h3>");
        out.println("<ul>");
        this.categoryService.listCategories().forEach(r->
                out.format("<li>%s</li>",r.getName()));
        out.println("</ul>");
        out.println("<h3>Add Category </h3>");
        out.println("<form method='POST' action='/servlet/category'>");
        out.println("<label for='name'> Name: </label>");
        out.println("<input id='name' type='text' name='name'/>");
        out.println("<label for='des'> Description: </label>");
        out.println("<input id='desc' type='text' name='desc'/>");
        out.println("<input type='submit' value='Submit'/>");
        out.println("<form>");
        out.println("<body>");
        out.println("</head>");
        out.println("</html>");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("name");
        String categoryDescription = req.getParameter("desc");
        categoryService.create(categoryName, categoryDescription);
        resp.sendRedirect("/servlet/category");
    }

}