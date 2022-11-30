package controlador;

import bdd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author FabianDuran DenisseVenegas
 */
public class RegistroUsuario {
    public boolean validarLogin(Usuario newUser) {

        List<Usuario> user = new ArrayList<>();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.objetenerConexion();

            String query = "SELECT usuario,contrasenna FROM usuario";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario us = new Usuario();

                us.setUsuario(rs.getString("usuario"));
                us.setContrasenna(rs.getString("contrasenna"));
                user.add(us);
            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL al encontrar el usuario" + e.getMessage());
        }

        for (Usuario us : user){

            if(newUser.getUsuario().equalsIgnoreCase(us.getUsuario())&& newUser.getContrasenna().equalsIgnoreCase(us.getContrasenna())){
                System.out.println("Inicio de sesion exitoso");
                return true;
            }
        }

        return false;
    }
}
