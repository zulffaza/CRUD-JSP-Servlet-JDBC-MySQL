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

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 */
public class AddController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nama");
        int price = Integer.parseInt(req.getParameter("harga"));
        String asal = req.getParameter("asal");

        FoodModel foodModel = new FoodModel();

        foodModel.setNama(name);
        foodModel.setHarga(price);
        foodModel.setAsal(asal);

        FoodDAO foodDAO = new FoodDAO();

        if (!req.getParameter("id").equals("")) {
            int id = Integer.parseInt(req.getParameter("id"));

            foodModel.setId(id);
            foodDAO.updateFood(foodModel);
        } else {
            String username = (String) req.getSession().getAttribute("username");

            UserDAO userDAO = new UserDAO();
            UserModel userModel = userDAO.showUser(username);

            foodModel.setUserId(userModel.getId());

            foodDAO.insertFood(foodModel);
        }

        resp.sendRedirect(req.getContextPath() + "/Index");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") == null && req.getSession().getAttribute("password") == null)
            resp.sendRedirect(req.getContextPath() + "/Index");
        else {
            if (req.getParameter("id") != null) {
                int id = Integer.parseInt(req.getParameter("id"));

                FoodDAO foodDAO = new FoodDAO();
                FoodModel foodModel = foodDAO.showFoodAtId(id);

                req.setAttribute("foodModel", foodModel);
            }

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/formAdd.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}