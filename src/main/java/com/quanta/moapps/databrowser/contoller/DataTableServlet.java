package com.quanta.moapps.databrowser.contoller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by anderson on 2015/2/11.
 */
@WebServlet(name = "DataTableServlet")
public class DataTableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String json = "{ \"demo\":[[\"John\",\"Sam\",\"Sola\",\"Accun\"],[\"Raj\",\"Raj\",\"Sanjosh\",\"CA\"]]}";
        out.println(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
