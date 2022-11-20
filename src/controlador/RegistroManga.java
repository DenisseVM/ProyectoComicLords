/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import bdd.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Manga;

/**
 *
 * @author fabi-
 */
public class RegistroManga {

    public boolean agregarManga(Manga manga) {

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "INSERT INTO producto(precio,stock,nombre,editorial,autor,mesesSerial,nroTomo,estado,demografia) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setInt(1, manga.getPrecio());
            stmt.setInt(2, manga.getStock());
            stmt.setString(3, manga.getNombre());
            stmt.setString(4, manga.getEditorial());
            stmt.setString(5, manga.getAutor());
            stmt.setInt(6, manga.getMesesSerial());
            stmt.setInt(7, manga.getNroTomo());
            stmt.setBoolean(8, manga.isEstado());
            stmt.setString(9, manga.getDemografia());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL al agregar un manga " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarManga(String nombre) {

        boolean flag = false;
        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "DELETE FROM producto WHERE nombre =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nombre);

            int preg = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea eliminar esto?", "Eliminar Producto", 1);

            if (preg == 0) {
                stmt.executeUpdate();
                stmt.close();
                cnx.close();
                flag = true;
            }

        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL a la hora de eliminar producto" + e.getMessage());
            flag = false;
        }
        return flag;
    }

    //ACTUALIZACION DE LOS ATRIBUTOS
    public boolean actualizarPrecioManga(int precio, int newPrecio) {

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "UPDATE producto SET precio = ? WHERE precio =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, newPrecio);
            stmt.setInt(2, precio);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al actualizar el precio del manga" + e.getMessage());
            return false;
        }
    }

    public boolean actualizarStockManga(int stock, int newStock) {

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "UPDATE producto SET stock = ? WHERE stock =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, newStock);
            stmt.setInt(2, stock);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al actualizar el stock del manga" + e.getMessage());
            return false;
        }
    }

    public boolean actualizarNombreManga(String nombre, String newNombre) {

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "UPDATE producto SET nombre = ? WHERE nombre =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, newNombre);
            stmt.setString(2, nombre);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al actualizar el nombre del manga" + e.getMessage());
            return false;
        }
    }

    public boolean actualizarEditorialManga(String editorial, String newEditorial) {

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "UPDATE producto SET editorial = ? WHERE editorial =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, newEditorial);
            stmt.setString(2, editorial);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al actualizar la editorial del manga" + e.getMessage());
            return false;
        }
    }

    public boolean actualizarAutorManga(String autor, String newAutor) {

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "UPDATE producto SET autor = ? WHERE autor =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, newAutor);
            stmt.setString(2, autor);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al actualizar el autor del manga" + e.getMessage());
            return false;
        }
    }

    public boolean actualizarMesesSerial(int mesesSerial, int newMesesSerial) {

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "UPDATE producto SET mesesSerial = ? WHERE mesesSerial =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, newMesesSerial);
            stmt.setInt(2, mesesSerial);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al actualizar los meses del manga" + e.getMessage());
            return false;
        }
    }

    public boolean actualizarNroTomo(int nroTomo, int newNroTomo) {

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "UPDATE producto SET nroTomo = ? WHERE nroTomo =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, newNroTomo);
            stmt.setInt(2, nroTomo);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al actualizar el numero del tomo del manga" + e.getMessage());
            return false;
        }
    }

    public boolean actualizarEstadoManga(boolean estado, boolean newEstado) {

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "UPDATE producto SET estado = ? WHERE estado =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setBoolean(1, newEstado);
            stmt.setBoolean(2, estado);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al actualizar el estado del manga" + e.getMessage());
            return false;
        }
    }

    public boolean actualizarDemografiaManga(String demografia, String newDemografia) {

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "UPDATE producto SET demografia = ? WHERE demografia =?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, newDemografia);
            stmt.setString(2, demografia);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al actualizar la demografia del manga" + e.getMessage());
            return false;
        }
    }

    public Manga buscarPorNombre(String nombre) {

        Manga mg = new Manga();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "SELECT * FROM producto WHERE nombre = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nombre);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                mg.setCodigo(rs.getInt("codigo"));
                mg.setPrecio(rs.getInt("precio"));
                mg.setStock(rs.getInt("Stock"));
                mg.setNombre(rs.getString("nombre"));
                mg.setEditorial(rs.getString("editorial"));
                mg.setAutor(rs.getString("autor"));
                mg.setMesesSerial(rs.getInt("mesesSerial"));
                mg.setNroTomo(rs.getInt("nroTomo"));
                mg.setEstado(rs.getBoolean("estado"));
                mg.setDemografia(rs.getString("demografia"));
            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al consultar por el nombre" + e.getMessage());
        }
        return mg;

    }

    public Manga buscarPorDemografia(String demografia) {

        Manga mg = new Manga();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "SELECT * FROM producto WHERE demografia = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, demografia);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                mg.setCodigo(rs.getInt("codigo"));
                mg.setPrecio(rs.getInt("precio"));
                mg.setStock(rs.getInt("Stock"));
                mg.setNombre(rs.getString("nombre"));
                mg.setEditorial(rs.getString("editorial"));
                mg.setAutor(rs.getString("autor"));
                mg.setMesesSerial(rs.getInt("mesesSerial"));
                mg.setNroTomo(rs.getInt("nroTomo"));
                mg.setEstado(rs.getBoolean("estado"));
                mg.setDemografia(rs.getString("demografia"));
            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al consultar por el nombre" + e.getMessage());
        }
        return mg;

    }

    public Manga buscarPorAutor(String autor) {

        Manga mg = new Manga();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "SELECT * FROM producto WHERE autor = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, autor);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                mg.setCodigo(rs.getInt("codigo"));
                mg.setPrecio(rs.getInt("precio"));
                mg.setStock(rs.getInt("Stock"));
                mg.setNombre(rs.getString("nombre"));
                mg.setEditorial(rs.getString("editorial"));
                mg.setAutor(rs.getString("autor"));
                mg.setMesesSerial(rs.getInt("mesesSerial"));
                mg.setNroTomo(rs.getInt("nroTomo"));
                mg.setEstado(rs.getBoolean("estado"));
                mg.setDemografia(rs.getString("demografia"));
            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al consultar por el autor" + e.getMessage());
        }
        return mg;

    }

    public List<Manga> buscarTodos() {

        List<Manga> lista = new ArrayList<>();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "SELECT * FROM producto ";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Manga mg = new Manga();
                mg.setCodigo(rs.getInt("codigo"));
                mg.setPrecio(rs.getInt("precio"));
                mg.setStock(rs.getInt("Stock"));
                mg.setNombre(rs.getString("nombre"));
                mg.setEditorial(rs.getString("editorial"));
                mg.setAutor(rs.getString("autor"));
                mg.setMesesSerial(rs.getInt("mesesSerial"));
                mg.setNroTomo(rs.getInt("nroTomo"));
                mg.setEstado(rs.getBoolean("estado"));
                mg.setDemografia(rs.getString("demografia"));

                lista.add(mg);
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
