package com.main.library_management.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.library_management.dao.impl.UserDAO;
import com.main.library_management.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "user", value = "/user")
public class UserService extends HttpServlet {
    private static final ObjectMapper objectMapper = new ObjectMapper();

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       response.setContentType("application/json");
       response.setCharacterEncoding("UTF-8");


       User user = objectMapper.readValue(request.getReader(), User.class);

       UserDAO.getInstance().addUser(user);




   }
}
