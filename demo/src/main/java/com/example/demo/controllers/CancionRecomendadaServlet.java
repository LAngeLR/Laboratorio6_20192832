package com.example.demo.controllers;

import java.io.*;

import com.example.demo.models.dao.CancionesDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CancionRecomendadaServlet", value = "/listaRecomendados")
public class CancionRecomendadaServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CancionesDao cancionesDao = new CancionesDao();
        request.setAttribute("lista", cancionesDao.listarCancionRecomendada());

        RequestDispatcher view = request.getRequestDispatcher("cancion/cancionRecomendada.jsp");
        view.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}