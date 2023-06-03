package com.example.demo.models.dao;

import com.example.demo.models.beans.Cancion;
import java.sql.*;
import java.util.ArrayList;

public class CancionesDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
    public ArrayList<Cancion> listarCancionRecomendada(){
        ArrayList<Cancion> lista = new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(url,user,pass); Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select c.idcancion,c.nombre_cancion,c.banda, count(r.idreproduccion) from cancion c\n" +
                    "inner join reproduccion r on c.idcancion = r.cancion_idcancion\n" +
                    "\n" +
                    "group by cancion_idcancion having count(r.idreproduccion) >2 order by count(r.idreproduccion) desc")){

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String banda = resultSet.getString(3);
                lista.add(new Cancion(nombre,id,banda));
            }
        }catch (SQLException e){
            System.out.println("No se pudo realizar la busqueda");
        }

        return lista;
    }
    public ArrayList<Cancion> listarCancionesBanda(){
        ArrayList<Cancion> lista2 = new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(url,user,pass); Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT idcancion, nombre_cancion, banda\n" +
                    "FROM cancion\n" +
                    "GROUP BY idcancion, nombre_cancion, banda order by banda ")){

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String banda = resultSet.getString(3);
                lista2.add(new Cancion(nombre,id,banda));
            }
        }catch (SQLException e){
            System.out.println("No se pudo realizar la busqueda");
        }
        return lista2;
    }
    public ArrayList<Cancion> listarCanciones(){
        ArrayList<Cancion> lista3 = new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(url,user,pass); Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from cancion")){

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String banda = resultSet.getString(3);
                lista3.add(new Cancion(nombre,id,banda));
            }
        }catch (SQLException e){
            System.out.println("No se pudo realizar la busqueda");
        }
        return lista3;
    }
}
