package Controller;

import DAO.FoodDAO;
import DAO.UserDAO;
import Model.FoodModel;
import Model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 */
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {
                case "logout":
                    req.getSession().removeAttribute("username");
                    req.getSession().removeAttribute("password");
                    break;
                case "delete":
                    int id = Integer.parseInt(req.getParameter("id"));

                    FoodDAO foodDAO = new FoodDAO();
                    foodDAO.deleteFood(id);
                    break;
            }

            resp.sendRedirect(req.getContextPath() + "/Index");
        } else {
            String username = (String) req.getSession().getAttribute("username");

            UserDAO userDAO = new UserDAO();
            ArrayList<UserModel> userModels = userDAO.showUser();
            UserModel userModel = userDAO.showUser(username);

            FoodDAO foodDAO = new FoodDAO();
            ArrayList<FoodModel> foodModels = foodDAO.showFood();

            req.setAttribute("userModels", userModels);
            req.setAttribute("foodModels", foodModels);
            req.setAttribute("userModel", userModel);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/index.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}