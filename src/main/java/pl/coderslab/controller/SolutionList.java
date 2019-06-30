package pl.coderslab.controller;

import pl.coderslab.model.SolutionDao;
import pl.coderslab.plain.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@WebServlet(urlPatterns = "/solutions")
public class SolutionList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SolutionDao solutionDao = new SolutionDao();
        List<Solution> solutionList = Arrays.asList(solutionDao.findAll());
        req.setAttribute("solutionList", solutionList);
        getServletContext().getRequestDispatcher("/solutionList.jsp").forward(req, resp);

    }

}
