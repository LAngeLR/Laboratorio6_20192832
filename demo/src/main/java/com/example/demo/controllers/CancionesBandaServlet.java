package com.example.demo.controllers;

import java.io.*;

import com.example.demo.models.dao.CancionesDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CancionesBandaServlet", value = "/listaCanciones")
public class CancionesBandaServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CancionesDao cancionesDao2 = new CancionesDao();

        request.setAttribute("lista1", cancionesDao2.listarCancionesBanda());

        RequestDispatcher view = request.getRequestDispatcher("cancion/cancionesporbanda.jsp");
        view.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}