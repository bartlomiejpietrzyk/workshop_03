package pl.coderslab.controller;

import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.UserDao;
import pl.coderslab.plain.User;
import pl.coderslab.plain.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/userGroups")

public class UserGroupList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserGroupDao userGroupDao = new UserGroupDao();
        List<UserGroup> userGroupList = Arrays.asList(userGroupDao.findAll());
        req.setAttribute("userGroup", userGroupList);
        getServletContext().getRequestDispatcher("/usersGroupList.jsp").forward(req, resp);

    }
}
