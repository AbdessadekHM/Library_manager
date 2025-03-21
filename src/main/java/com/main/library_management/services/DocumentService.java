package com.main.library_management.services;


import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.library_management.dao.impl.DocumentDAO;
import com.main.library_management.models.Document;
import jakarta.servlet.Servlet;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;




@WebServlet(name = "document", value = "/document")
public class DocumentService extends HttpServlet {
    private static final ObjectMapper objectMapper = new ObjectMapper();






    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Document> documents = DocumentDAO.getInstance().getAllDocuments();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Create a sample response object


        // Convert object to JSON string
        String jsonResponse = objectMapper.writeValueAsString(documents);

        // Send JSON response
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();



    }

    public void destroy() {
    }
}






