/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import bdd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Producto;

/**
 *
 * @author fabi-
 */
public class RegistroProducto {
    
        public boolean agregarProducto(Producto producto) {

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "INSERT INTO producto(precio,stock,nombre,editorial,autor) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setInt(1, producto.getPrecio());
            stmt.setInt(2, producto.getStock());
            stmt.setString(3, producto.getNombre());
            stmt.setString(4, producto.getEditorial());
            stmt.setString(5, producto.getAutor());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL al agregar un producto " + e.getMessage());
            return false;
        }
    }
    
}
