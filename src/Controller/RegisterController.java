package Controller;

import DAO.UserDAO;
import Model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Date date = new Date();
        UserModel userModel = new UserModel();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");

        userModel.setUsername(username);
        userModel.setPassword(password);
        userModel.setLastLogin(format.format(date));

        UserDAO userDAO = new UserDAO();
        userDAO.insertUser(userModel);
        userDAO.login(req.getSession(), username, password);

        resp.sendRedirect(req.getContextPath() + "/Index");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") != null && req.getSession().getAttribute("password") != null)
            resp.sendRedirect(req.getContextPath() + "/Index");
        else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/register.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}