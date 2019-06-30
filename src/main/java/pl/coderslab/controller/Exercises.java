package pl.coderslab.controller;

import pl.coderslab.model.ExerciseDao;
import pl.coderslab.model.UserDao;
import pl.coderslab.plain.Exercise;
import pl.coderslab.plain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/exercises")
public class Exercises extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExerciseDao exerciseDao = new ExerciseDao();
        List<Exercise> exerciseList = Arrays.asList(exerciseDao.findAll());
        req.setAttribute("exerciseList", exerciseList);
        getServletContext().getRequestDispatcher("/exerciseList.jsp").forward(req, resp);

    }
}