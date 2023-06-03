package com.example.demo.models.dao;
import com.example.demo.models.beans.CancionFavorita;
import java.sql.*;
import java.util.ArrayList;

public class CancionesFavoritasDao {

    public ArrayList<CancionFavorita> listarFavorita() {
        ArrayList<CancionFavorita> listaPreferida = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select idcancion, nombre_cancion, banda from cancion where estado=1";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                CancionFavorita cancionFavorita = new CancionFavorita();
                cancionFavorita.setIdCancion(resultSet.getInt(1));
                cancionFavorita.setNombre(resultSet.getString(2));
                cancionFavorita.setBanda(resultSet.getString(3));
                cancionFavorita.setEstado(resultSet.getInt(4));
                listaPreferida.add(cancionFavorita);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPreferida;
    }

    public void guardarFavorita(CancionFavorita cancionFavorita) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        String sql = "INSERT INTO cancion (idcancion,nombre_cancion,banda,estado) VALUES (?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, cancionFavorita.getIdCancion());
            pstmt.setString(2, cancionFavorita.getNombre());
            pstmt.setString(3, cancionFavorita.getNombre());
            int estadoPredeterminado = 1;
            pstmt.setInt(4, estadoPredeterminado);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
