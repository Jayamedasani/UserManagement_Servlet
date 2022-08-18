package org.example.servlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.implementation.UserManagerDatabaseImpl;
import org.example.implementation.UserManagerInMemoryImpl;
import org.example.userinterface.UserOperations;
import org.example.model.User;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    private UserOperations userManagerInDatabase = new UserManagerDatabaseImpl();
    private UserOperations userManagerInMemory = new UserManagerInMemoryImpl();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> users = userManagerInDatabase.getUsers();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = objectMapper.readValue(request.getReader(), User.class);
        userManagerInDatabase.addUser(user);
    }
}