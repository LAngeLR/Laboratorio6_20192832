package com.example.demo.controllers;

import com.example.demo.models.beans.CancionFavorita;
import com.example.demo.models.dao.CancionesFavoritasDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CancionFavoritaServlet", value = "/CancionFavorita")
public class CancionFavoritaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CancionesFavoritasDao cancionesFavoritasDao = new CancionesFavoritasDao();

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");

        switch (action) {
            case "listar":
                request.setAttribute("lista", cancionesFavoritasDao.listarFavorita());
                request.getRequestDispatcher("cancion/cancionRecomendada.jsp").forward(request, response);
                break;
            case "crear":
                request.getRequestDispatcher("cancion/nuevo.jsp").forward(request, response);
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public CancionFavorita parseCancionFavorita(HttpServletRequest request) {

        CancionFavorita cancionFavorita = new CancionFavorita();
        String jobId = request.getParameter("cancionId");
        String nombre = request.getParameter("nombre");
        String banda = request.getParameter("banda");
        String estado = request.getParameter("estado");

        try {
            int id = Integer.parseInt(jobId);
            int status = Integer.parseInt(estado);

            cancionFavorita.setIdCancion(id);
            cancionFavorita.setNombre(nombre);
            cancionFavorita.setBanda(banda);
            cancionFavorita.setEstado(status);

            return cancionFavorita;

        } catch (NumberFormatException e) {

        }
        return cancionFavorita;
    }
}
