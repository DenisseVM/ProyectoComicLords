/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import bdd.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        
            public List<Producto> buscarTodos() {

        List<Producto> lista = new ArrayList<>();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "SELECT * FROM producto ";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                Producto prt = new Producto();
                prt.setCodigo(rs.getInt("codigo"));
                prt.setPrecio(rs.getInt("precio"));
                prt.setStock(rs.getInt("Stock"));
                prt.setNombre(rs.getString("nombre"));
                prt.setEditorial(rs.getString("auditorial"));
                prt.setAutor(rs.getString("autor"));
                
                lista.add(prt);
            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al consultar todos los datos" + e.getMessage());
        }
        return lista;

    }
    
}
