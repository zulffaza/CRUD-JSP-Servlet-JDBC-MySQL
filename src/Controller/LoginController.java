package Controller;

import DAO.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAO();
        userDAO.login(req.getSession(), username, password);

        resp.sendRedirect(req.getContextPath() + "/Index");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") != null && req.getSession().getAttribute("password") != null)
            resp.sendRedirect(req.getContextPath() + "/Index");
        else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}