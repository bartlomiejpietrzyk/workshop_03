package pl.coderslab.controller;

import pl.coderslab.model.SolutionDao;
import pl.coderslab.plain.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "")
public class LandingPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        SolutionDao solutionDao = new SolutionDao();
        List<Solution> recentList = solutionDao.findRecent(Integer.parseInt(getServletContext().getInitParameter("number-solutions")));
        req.setAttribute("recentList", recentList);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

    }

}
