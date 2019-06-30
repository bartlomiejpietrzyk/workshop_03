package pl.coderslab.dao;

import pl.coderslab.plain.Solution;
import pl.coderslab.utils.DatabaseUtils;

import java.sql.*;
import java.util.Arrays;

public class SolutionDao {
    private static final String CREATE_SOLUTION_QUERY =
            "INSERT INTO solution(user_id, exercise_id, description) VALUES (?, ?, ?)";

    private static final String READ_SOLUTION_QUERY =
            "SELECT * FROM solution WHERE user_id = ?";

    private static final String UPDATE_SOLUTION_QUERY =
            "UPDATE solution SET user_id = ?, exercise_id = ?, description = ?,";

    private static final String DELETE_SOLUTION_QUERY =
            "DELETE FROM solution WHERE id = ?";
    private static final String FIND_ALL_SOLUTION_QUERY = "SELECT * FROM solution";

    private static final String FIND_ALL_SOLUTION_BY_USER_ID_QUERY = "SELECT * FROM solution WHERE user_id = ?";

    private static final String FIND_ALL_SOLUTION_BY_EXERCISE_ID_QUERY =
            "SELECT * FROM solution WHERE exercise_id = ? ORDER BY created DESC";

    public Solution create(Solution solution) {
        try (Connection conn = DatabaseUtils.getConnection("java_warsztat_2")) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_SOLUTION_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, solution.getUserId());
            statement.setInt(2, solution.getExerciseId());
            statement.setString(3, solution.getSolutionDescription());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                solution.setSolutionId((resultSet.getInt(1)));
            }
            return solution;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Solution read(int solutionId) {
        try (Connection conn = DatabaseUtils.getConnection("java_warsztat_2")) {
            PreparedStatement statement = conn.prepareStatement(READ_SOLUTION_QUERY);
            statement.setInt(1, solutionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Solution solution = new Solution();
                solution.setSolutionId(resultSet.getInt("id"));
                solution.setUserId(resultSet.getInt("user_id"));
                solution.setExerciseId(resultSet.getInt("exercise_id"));
                solution.setCreated(resultSet.getDate("created"));
                solution.setUpdated(resultSet.getDate("updated"));
                solution.setSolutionDescription(resultSet.getString("description"));
                return solution;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 public boolean exist(int solutionId) {
        try (Connection conn = DatabaseUtils.getConnection("java_warsztat_2")) {
            PreparedStatement statement = conn.prepareStatement(READ_SOLUTION_QUERY);
            statement.setInt(1, solutionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Solution solution = new Solution();
                solution.setSolutionId(resultSet.getInt("id"));
                solution.setUserId(resultSet.getInt("user_id"));
                solution.setExerciseId(resultSet.getInt("exercise_id"));
                solution.setCreated(resultSet.getDate("created"));
                solution.setUpdated(resultSet.getDate("updated"));
                solution.setSolutionDescription(resultSet.getString("description"));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void update(Solution solution) {
        try (Connection conn = DatabaseUtils.getConnection("java_warsztat_2")) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_SOLUTION_QUERY);
            statement.setInt(1, solution.getUserId());
            statement.setInt(2, solution.getExerciseId());
            statement.setString(3, solution.getSolutionDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int solutionId) {
        try (Connection conn = DatabaseUtils.getConnection("java_warsztat_2")) {
            PreparedStatement statement = conn.prepareStatement(DELETE_SOLUTION_QUERY);
            statement.setInt(1, solutionId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Solution[] addToArray(Solution solution, Solution[] solutions) {
        Solution[] tmpSolutions = Arrays.copyOf(solutions, solutions.length + 1);
        tmpSolutions[solutions.length] = solution;
        return tmpSolutions;
    }

    public Solution[] findAll() {
        try (Connection conn = DatabaseUtils.getConnection("java_warsztat_2")) {
            Solution[] solutions = new Solution[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_SOLUTION_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setSolutionId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getDate("created"));
                solution.setUpdated(resultSet.getDate("updated"));
                solution.setExerciseId(resultSet.getInt("exercise_id"));
                solution.setUserId(resultSet.getInt("user_id"));
                solution.setSolutionDescription(resultSet.getString("description"));
                solutions = addToArray(solution, solutions);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Solution[] findAllByExerciseId(int exerciseId) {
        try (Connection conn = DatabaseUtils.getConnection("java_warsztat_2")) {
            Solution[] solutions = new Solution[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_SOLUTION_BY_EXERCISE_ID_QUERY);
            statement.setInt(1, exerciseId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setSolutionId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getDate("created"));
                solution.setUpdated(resultSet.getDate("updated"));
                solution.setExerciseId(resultSet.getInt("exercise_id"));
                solution.setUserId(resultSet.getInt("user_id"));
                solution.setSolutionDescription(resultSet.getString("description"));
                solutions = addToArray(solution, solutions);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
 public Solution[] findAllByUserId(int userId) {
        try (Connection conn = DatabaseUtils.getConnection("java_warsztat_2")) {
            Solution[] solutions = new Solution[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_SOLUTION_BY_USER_ID_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setSolutionId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getDate("created"));
                solution.setUpdated(resultSet.getDate("updated"));
                solution.setExerciseId(resultSet.getInt("exercise_id"));
                solution.setUserId(resultSet.getInt("user_id"));
                solution.setSolutionDescription(resultSet.getString("description"));
                solutions = addToArray(solution, solutions);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}