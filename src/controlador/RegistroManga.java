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
 * @author FabianDuran DenisseVenegas
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
            System.out.println("Error en la consulta SQL al agregar manga " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarManga(int codigo) {

        boolean flag = false;
        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "DELETE FROM producto WHERE codigo = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, codigo);

            int preg = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este producto?", "ELIMINAR PRODUCTO", 1);

            if (preg == 0) {
                stmt.executeUpdate();
                stmt.close();
                cnx.close();
                flag = true;
            }

        } catch (HeadlessException | SQLException e) {
            System.out.println("Error en la consulta SQL al eliminar producto" + e.getMessage());
            flag = false;
        }
        return flag;
    }

    //ACTUALIZACION DE LOS ATRIBUTOS
    public boolean actualizarManga(Manga nManga) {

        Conexion con = new Conexion();
        Connection cnx = con.objetenerConexion();

        try {

            String query = "UPDATE producto SET precio=?,stock=?,nombre=?,editorial=?,autor=?,mesesSerial=?,nroTomo=?,estado=?,demografia=? WHERE codigo=?";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setInt(1, nManga.getPrecio());
            stmt.setInt(2, nManga.getStock());
            stmt.setString(3, nManga.getNombre());
            stmt.setString(4, nManga.getEditorial());
            stmt.setString(5, nManga.getAutor());
            stmt.setInt(6, nManga.getMesesSerial());
            stmt.setInt(7, nManga.getNroTomo());
            stmt.setBoolean(8, nManga.isEstado());
            stmt.setString(9, nManga.getDemografia());
            stmt.setInt(10, nManga.getCodigo());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL al actualizar el manga" + e.getMessage());
            return false;
        }

    }

    public List<Manga> buscarPorNombre(String nombre) {

        List<Manga> lista = new ArrayList<>();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "SELECT * FROM producto WHERE nombre = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nombre);

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
            System.out.println("Error en la consulta SQL al consultar por el nombre" + e.getMessage());
        }
        return lista;

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
            System.out.println("Error en la consulta SQL al consultar los datos" + e.getMessage());
        }
        return lista;

    }

}
