package com.example.demo.controllers;

import java.io.*;

import com.example.demo.models.dao.CancionesDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CancionesGeneralServlet", value = "/listaCancionesGeneral")
public class CancionesGeneralServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CancionesDao cancionesDao1 = new CancionesDao();

        request.setAttribute("lista2", cancionesDao1.listarCanciones());

        RequestDispatcher view = request.getRequestDispatcher("cancion/canciones.jsp");
        view.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
