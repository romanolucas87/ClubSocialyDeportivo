/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DTO.DTOComboSocio;
import DTO.DTONoticiaFiltrada;
import DTO.DtoActividadesPorSocio;
import DTO.DtoComboCuota;
import DTO.DtoComboNacionalidad;
import DTO.DtoListaSocios;
import DTO.DtoTipoDocumento;
import Modelo.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class ConexionJDBC {

    private String CadenaBD = "jdbc:sqlserver://DESKTOP-E24IO4F\\SQLEXPRESS:1433;databaseName=ClubDeportivo";
    private String User = "sa";
    private String Pass = "laboratorio4";
    private Connection conexion;

    private void abrirConexion() {
        try {

            conexion = DriverManager.getConnection(CadenaBD, User, Pass);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cerrarConexion() {
        try {
            if (conexion != null && conexion.isClosed()) {
                conexion.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ConexionJDBC() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//------------------------MODULO SOCIOS--------------------------------//
    public void agregarSocio(Socio nuevoSocio) {

        try {

            abrirConexion();

            PreparedStatement st = conexion.prepareStatement("INSERT INTO Socios ([nombreSocio],[apellidoSocio],[telefonoSocio],[direccionSocio],"
                    + "[fechaNacimiento],[idNacionalidad] ,[idTipoDocumento] ,[nroDocumentoSocio],[email],[estadoSocio]) VALUES (?,?,?,?,?,?,?,?,?,1)");

            st.setString(1, nuevoSocio.getNombreSocio());
            st.setString(2, nuevoSocio.getApellidoSocio());
            st.setLong(3, nuevoSocio.getTelefonoSocio());
            st.setString(4, nuevoSocio.getDireccionSocio());
            st.setString(5, nuevoSocio.getFechaNacimiento());
            st.setInt(6, nuevoSocio.getIdNacionalidad());
            st.setInt(7, nuevoSocio.getTipoDocumento());
            st.setInt(8, nuevoSocio.getDocumentoSocio());
            st.setString(9, nuevoSocio.getEmail());

            st.executeUpdate();

            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarSocio(Socio nuevoSocio) {

        try {

            abrirConexion();

            PreparedStatement st = conexion.prepareStatement("UPDATE Socios SET [nombreSocio] = ?\n"
                    + "      ,[apellidoSocio] = ?,\n"
                    + "      [telefonoSocio] = ?,\n"
                    + "      [direccionSocio] = ?,\n"
                    + "      [fechaNacimiento] = ?,\n"
                    + "      [idNacionalidad] = ?,\n"
                    + "      [idTipoDocumento] = ?,\n"
                    + "      [nroDocumentoSocio] = ?,\n"
                    + "      [email] = ?,\n"
                    + "      [estadoSocio] = ?\n"
                    + " WHERE idSocio=? ");

            st.setString(1, nuevoSocio.getNombreSocio());
            st.setString(2, nuevoSocio.getApellidoSocio());
            st.setLong(3, nuevoSocio.getTelefonoSocio());
            st.setString(4, nuevoSocio.getDireccionSocio());
            st.setString(5, nuevoSocio.getFechaNacimiento());
            st.setInt(6, nuevoSocio.getIdNacionalidad());
            st.setInt(7, nuevoSocio.getTipoDocumento());
            st.setInt(8, nuevoSocio.getDocumentoSocio());
            st.setString(9, nuevoSocio.getEmail());
            st.setBoolean(10, nuevoSocio.isEstadoSocio());
            st.setInt(11, nuevoSocio.getIdSocio());

            st.executeUpdate();

            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EliminarSocio(int idSocio) {

        try {

            abrirConexion();

            PreparedStatement st = conexion.prepareStatement("UPDATE Socios SET estadoSocio = 0\n"
                    + " WHERE idSocio=? ");

            st.setInt(1, idSocio);

            st.executeUpdate();

            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socio getSocioId(int idSoc) {
        Socio nuevoSocio = null;

        try {
            abrirConexion();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM Socios WHERE idSocio=?");
            st.setInt(1, idSoc);
            ResultSet resultado = st.executeQuery();
            if (resultado.next()) {
                int idSocio = resultado.getInt("idSocio");
                String nombreSocio = resultado.getString("nombreSocio");
                String apellidoSocio = resultado.getString("apellidoSocio");
                long telefono = resultado.getLong("telefonoSocio");
                String direccion = resultado.getString("direccionSocio");
                String fechaNacimiento = resultado.getString("fechaNacimiento");
                int idNacionalidad = resultado.getInt("idNacionalidad");
                int tipoDocumento = resultado.getInt("idTipoDocumento");
                int nroDocumento = resultado.getInt("nroDocumentoSocio");
                String email = resultado.getString("email");
                boolean estadoSocio = resultado.getBoolean("estadoSocio");

                nuevoSocio = new Socio(idSocio, nombreSocio, apellidoSocio, telefono, direccion, fechaNacimiento, idNacionalidad, tipoDocumento, nroDocumento, email, estadoSocio);
                nuevoSocio.setIdSocio(idSocio);
            }
            resultado.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return nuevoSocio;

    }

    public Socio getSocioPago(int idSoc) {
        Socio nuevoSocio = null;

        try {
            abrirConexion();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM Socios WHERE idSocio=?");
            st.setInt(1, idSoc);
            ResultSet resultado = st.executeQuery();
            if (resultado.next()) {
                int idSocio = resultado.getInt("idSocio");
                String nombreSocio = resultado.getString("nombreSocio");
                String apellidoSocio = resultado.getString("apellidoSocio");

                boolean estadoSocio = resultado.getBoolean("estadoSocio");

                nuevoSocio = new Socio();
                nuevoSocio.setIdSocio(idSocio);
                nuevoSocio.setNombreSocio(nombreSocio);
                nuevoSocio.setApellidoSocio(apellidoSocio);
                nuevoSocio.setEstadoSocio(estadoSocio);
            }
            resultado.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return nuevoSocio;

    }

    public ArrayList<DtoListaSocios> getSocios() {

        ArrayList<DtoListaSocios> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("SELECT s.idSocio, s.nombreSocio , s.apellidoSocio ,  s.telefonoSocio Telefono, "
                    + "s.direccionSocio Direccion, s.fechaNacimiento AS 'Fecha Nacimiento', n.descripcionNacionalidad Nacionalidad, "
                    + "td.descripcionDocumento AS 'tipoDocumento', s.nroDocumentoSocio AS 'NrodeDocumento', S.email AS 'E-Mail'\n"
                    + "FROM Socios s\n"
                    + "JOIN Nacionalidades n ON n.idNacionalidad=s.idNacionalidad\n"
                    + "JOIN TiposDocumentos td ON td.idTipoDocumento=s.idTipoDocumento\n"
                    + "WHERE estadoSocio = 1;");
            while (resultado.next()) {

                int idSocio = resultado.getInt("idSocio");
                String nombreSocio = resultado.getString("nombreSocio");
                String apellidoSocio = resultado.getString("apellidoSocio");
                long telefono = resultado.getLong("Telefono");
                String direccion = resultado.getString("Direccion");
                String fechaNacimiento = resultado.getString("Fecha Nacimiento");
                String nacionalidad = resultado.getString("Nacionalidad");
                String tipoDocumento = resultado.getString("tipoDocumento");
                int nroDocumento = resultado.getInt("NrodeDocumento");
                String email = resultado.getString("E-Mail");

                DtoListaSocios paciente = new DtoListaSocios(idSocio, nombreSocio, apellidoSocio, telefono, direccion, fechaNacimiento, nacionalidad, tipoDocumento, nroDocumento, email);
                lista.add(paciente);
            }
            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<DTOComboSocio> getComboSocio() {

        ArrayList<DTOComboSocio> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("SELECT idSocio, nombreSocio + ' ' + apellidoSocio as NombreSocio\n"
                    + "FROM Socios\n"
                    + "where estadoSocio=1;");
            while (resultado.next()) {

                int idSocio = resultado.getInt("idSocio");
                String nombreSocio = resultado.getString("NombreSocio");

                DTOComboSocio nuevoSocio = new DTOComboSocio(idSocio, nombreSocio);

                lista.add(nuevoSocio);
            }
            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }
    //-----------------------------------------------------------------------//
    //------------------------MODULO NOTICIAS---------------------------//  

    public ArrayList<DtoActividadesPorSocio> getActividadesXSocio(int idSoc) {

        ArrayList<DtoActividadesPorSocio> lista = new ArrayList<>();

        try {
            abrirConexion();
            String consulta = ("select s.nombreSocio + ' ' + s.apellidoSocio nombreSocio, a.NombreActividad, s.idSocio, a.idActividad\n"
                    + "from ActividadesXSocio ax\n"
                    + "JOIN Actividades A ON a.idActividad=ax.idActividad\n"
                    + "JOIN Socios S ON s.idSocio=ax.idSocio\n"
                    + "WHERE AX.idSocio=?\n"
                    + "AND ax.estadoInscripcion= 1");
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idSoc);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                String nombreSocio = resultado.getString("nombreSocio");
                String nombreActividad = resultado.getString("NombreActividad");
                int idSocio = resultado.getInt("idSocio");
                int idActividad = resultado.getInt("idActividad");

                DtoActividadesPorSocio nuevoDto = new DtoActividadesPorSocio(nombreSocio, nombreActividad, idSocio, idActividad);

                lista.add(nuevoDto);
            }
            ps.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public void altaActividad(int idSocio, int idActividad) {

        try {

            abrirConexion();

            PreparedStatement st = conexion.prepareStatement("INSERT INTO [dbo].[ActividadesXSocio]\n"
                    + "           ([idSocio]\n"
                    + "           ,[idActividad]\n"
                    + "           ,[estadoInscripcion])\n"
                    + "     VALUES (?,?,1)");

            st.setInt(1, idSocio);
            st.setInt(2, idActividad);

            st.executeUpdate();

            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bajaActividad(int idSocio, int idActividad) {

        try {

            abrirConexion();

            PreparedStatement st = conexion.prepareStatement("UPDATE ActividadesXSocio\n"
                    + "   SET estadoInscripcion = 0\n"
                    + " WHERE idActividad=?\n"
                    + " AND idSocio =?");
            st.setInt(1, idActividad);
            st.setInt(2, idSocio);

            st.executeUpdate();

            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//-----------------------------------------------------------------------//
    //------------------------MODULO ACTIVIDADES---------------------------//  
    public void agregarActividad(Actividad nuevaActividad) {

        try {

            abrirConexion();

            PreparedStatement st = conexion.prepareStatement("INSERT INTO [dbo].[Actividades]\n"
                    + "           ([NombreActividad]\n"
                    + "           ,[precioActividad]\n"
                    + "           ,[estadoActividad])\n"
                    + "            VALUES(?,?,1)");

            st.setString(1, nuevaActividad.getNombreActividad());
            st.setDouble(2, nuevaActividad.getPrecioActividad());

            st.executeUpdate();

            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarActividad(Actividad nuevaActividad) {

        try {

            abrirConexion();

            PreparedStatement st = conexion.prepareStatement("UPDATE Actividades\n"
                    + "   SET [NombreActividad] = ?,\n"
                    + "       [precioActividad] = ?,\n"
                    + "       [estadoActividad] =?\n"
                    + " WHERE idActividad=?");

            st.setString(1, nuevaActividad.getNombreActividad());
            st.setDouble(2, nuevaActividad.getPrecioActividad());
            st.setBoolean(3, nuevaActividad.isEstadoActividad());
            st.setInt(4, nuevaActividad.getIdActividad());

            st.executeUpdate();

            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EliminarActividad(int idActividad) {

        try {

            abrirConexion();

            PreparedStatement st = conexion.prepareStatement("UPDATE Actividades SET estadoActividad = 0\n"
                    + " WHERE idActividad=? ");

            st.setInt(1, idActividad);

            st.executeUpdate();

            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Actividad> getActividades() {

        ArrayList<Actividad> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM Actividades where estadoActividad=1");
            while (resultado.next()) {

                int idACtividad = resultado.getInt("idActividad");
                String nombreActividad = resultado.getString("NombreActividad");
                double precioActividad = resultado.getDouble("precioActividad");
                boolean estadoActividad = resultado.getBoolean("estadoActividad");

                Actividad nuevaActividad = new Actividad(idACtividad, nombreActividad, precioActividad, estadoActividad);
                lista.add(nuevaActividad);
            }
            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public Actividad getActividadId(int idAct) {
        Actividad nuevaActividad = null;

        try {
            abrirConexion();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM Actividades WHERE idActividad = ?");
            st.setInt(1, idAct);
            ResultSet resultado = st.executeQuery();
            if (resultado.next()) {
                int idActividad = resultado.getInt("idActividad");
                String nombreActividad = resultado.getString("nombreActividad");
                double precioActividad = resultado.getDouble("precioActividad");
                boolean estadoActividad = resultado.getBoolean("estadoActividad");

                nuevaActividad = new Actividad(idActividad, nombreActividad, precioActividad, estadoActividad);
                nuevaActividad.setIdActividad(idActividad);
            }
            resultado.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return nuevaActividad;

    }

//-----------------------------------------------------------------------//
    //------------------------MODULO NOTICIAS---------------------------//  
    public void cargarNoticia(Noticia nuevaNoticia) {

        try {

            abrirConexion();

            PreparedStatement st = conexion.prepareStatement("INSERT INTO [dbo].[Noticias]\n"
                    + "           ([idActividad]\n"
                    + "           ,[descripcionNoticia]\n"
                    + "           ,[estadoNoticia])\n"
                    + "            VALUES(?,?,1)");

            st.setInt(1, nuevaNoticia.getIdActividad().getIdActividad());
            st.setString(2, nuevaNoticia.getDescripcionNoticia());

            st.executeUpdate();

            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarNoticia(Noticia nuevaNoticia) {

        try {

            abrirConexion();

            PreparedStatement st = conexion.prepareStatement("UPDATE [dbo].[Noticias]\n"
                    + "   SET [idActividad] = ?,\n"
                    + "       [descripcionNoticia] =?,\n"
                    + "       [estadoNoticia] = ?,\n"
                    + " WHERE idNoticia =?");

            st.setInt(1, nuevaNoticia.getIdActividad().getIdActividad());
            st.setString(2, nuevaNoticia.getDescripcionNoticia());
            st.setBoolean(3, nuevaNoticia.isEstadoNoticia());
            st.setInt(4, nuevaNoticia.getIdNoticia());

            st.executeUpdate();

            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Noticia getNoticiaId(int idNot) {
        Noticia nuevaNoticia = null;

        try {
            abrirConexion();
            PreparedStatement st = conexion.prepareStatement("SELECT N.* ,A.nombreActividad FROM Noticias N JOIN Actividades A ON a.idActividad=N.idActividad WHERE idNoticia = ?");
            st.setInt(1, idNot);
            ResultSet resultado = st.executeQuery();
            if (resultado.next()) {
                int idNoticia = resultado.getInt("idNoticia");
                int idActividad = resultado.getInt("idActividad");
                String descripcionNoticia = resultado.getString("descripcionNoticia");
                String nombreActividad = resultado.getString("nombreActividad");
                boolean estadoNoticia = resultado.getBoolean("estadoNoticia");

                Actividad nuevaActividad = new Actividad();
                nuevaActividad.setIdActividad(idActividad);
                nuevaActividad.setNombreActividad(nombreActividad);

                nuevaNoticia = new Noticia(idNoticia, nuevaActividad, descripcionNoticia, estadoNoticia);

            }
            resultado.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return nuevaNoticia;

    }

    public void habilitarNoticia(int id) {
        try {
            Noticia nuevaNoticia = getNoticiaId(id);
            abrirConexion();
            if (nuevaNoticia.isEstadoNoticia()) {
                PreparedStatement ps = conexion.prepareStatement("UPDATE Noticias SET estadoNoticia = 0 WHERE idNoticia = ?"); //DESHABILITA
                ps.setInt(1, id);
                ps.executeUpdate();

            } else {
                PreparedStatement ps = conexion.prepareStatement("UPDATE Noticias SET estadoNoticia = 1 WHERE idNoticia = ?"); //HABILITA
                ps.setInt(1, id);
                ps.executeUpdate();
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public ArrayList<Noticia> getNoticiaFiltrada(int idActividad) {

        ArrayList<Noticia> lista = new ArrayList<>();

        try {
            abrirConexion();
            String consulta = ("SELECT n.descripcionNoticia Noticia, A.NombreActividad Actividad\n"
                    + "FROM Noticias N\n"
                    + "JOIN Actividades A ON A.idActividad=N.idActividad\n"
                    + "WHERE N.idActividad=?");
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idActividad);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                String noticia = resultado.getString("Noticia");
                String actividad = resultado.getString("Actividad");

                Actividad nuevaActividad = new Actividad();
                nuevaActividad.setNombreActividad(actividad);

                Noticia nuevaNoticia = new Noticia();
                nuevaNoticia.setDescripcionNoticia(noticia);
                nuevaNoticia.setIdActividad(nuevaActividad);

                lista.add(nuevaNoticia);
            }
            ps.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Noticia> getNoticias() {

        ArrayList<Noticia> lista = new ArrayList<>();

        try {
            abrirConexion();
            String consulta = ("SELECT N.idNoticia, A.idActividad, A.NombreActividad, N.descripcionNoticia, N.estadoNoticia\n"
                    + "FROM Noticias N\n"
                    + "JOIN Actividades A ON a.idActividad=N.idActividad");

            PreparedStatement ps = conexion.prepareStatement(consulta);

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                int idNoticia = Integer.parseInt(resultado.getString("idNoticia"));
                int idActividad = Integer.parseInt(resultado.getString("idActividad"));
                String nombreActividad = resultado.getString("NombreActividad");
                String descripcionNoticia = resultado.getString("descripcionNoticia");
                boolean estadoNoticia = resultado.getBoolean("estadoNoticia");

                Actividad nuevaActividad = new Actividad();
                nuevaActividad.setIdActividad(idActividad);
                nuevaActividad.setNombreActividad(nombreActividad);

                Noticia nuevaNoticia = new Noticia(idNoticia, nuevaActividad, descripcionNoticia, estadoNoticia);
                lista.add(nuevaNoticia);
            }
            ps.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Noticia> getNoticiasHabilitadas() {

        ArrayList<Noticia> lista = new ArrayList<>();

        try {
            abrirConexion();
            String consulta = ("SELECT N.idNoticia, A.idActividad, A.NombreActividad, N.descripcionNoticia, N.estadoNoticia\n"
                    + "FROM Noticias N\n"
                    + "JOIN Actividades A ON a.idActividad=N.idActividad\n"
                    + "WHERE N.estadoNoticia=1");

            /*String consulta = ("SELECT N.idNoticia, A.idActividad, A.NombreActividad, N.descripcionNoticia, N.estadoNoticia\n"
                    + "FROM Noticias N\n"
                    + "JOIN Actividades A ON a.idActividad=N.idActividad");*/
            PreparedStatement ps = conexion.prepareStatement(consulta);

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                int idNoticia = Integer.parseInt(resultado.getString("idNoticia"));
                int idActividad = Integer.parseInt(resultado.getString("idActividad"));
                String nombreActividad = resultado.getString("NombreActividad");
                String descripcionNoticia = resultado.getString("descripcionNoticia");
                boolean estadoNoticia = resultado.getBoolean("estadoNoticia");

                Actividad nuevaActividad = new Actividad();
                nuevaActividad.setIdActividad(idActividad);
                nuevaActividad.setNombreActividad(nombreActividad);

                Noticia nuevaNoticia = new Noticia(idNoticia, nuevaActividad, descripcionNoticia, estadoNoticia);
                lista.add(nuevaNoticia);
            }
            ps.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    //-----------------------------------------------------------------------//   
    //------------------------MODULO PAGOS---------------------------//  
    public float calcularMontoAPagar(int idSocio) {
        float monto = 0;

        try {
            abrirConexion();
            String consulta = ("SELECT axs.idSocio , SUM(a.precioActividad) precioActividad\n"
                    + "FROM ActividadesXSocio axs\n"
                    + "JOIN Actividades a ON a.idActividad=axs.idActividad\n"
                    + "WHERE axs.idSocio = ? AND axs.estadoInscripcion=1\n"
                    + "GROUP BY axs.idSocio;");
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idSocio);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                monto = resultado.getFloat("precioActividad");
                idSocio = resultado.getInt("idSocio");

            }
            ps.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return monto;

    }

    public void registrarPago(Pago nuevoPago) {

        try {

            abrirConexion();

            PreparedStatement st = conexion.prepareStatement("INSERT INTO Pagos\n"
                    + "           (idCuota\n"
                    + "           ,idSocio\n"
                    + "           ,monto\n"
                    + "           ,fechaPago\n"
                    + "           ,fechaVencimiento)\n"
                    + "     VALUES(?,?,?,?,?)");

            st.setInt(1, nuevoPago.getIdCuota());
            st.setInt(2, nuevoPago.getIdSocio());
            st.setDouble(3, nuevoPago.getMonto());
            st.setString(4, nuevoPago.getFechaPago());
            st.setString(5, nuevoPago.getFechaVencimiento());

            st.executeUpdate();

            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//-----------------------------------------------------------------------// 
//------------------------MODULO REPORTES---------------------------//    
    public double montoTotalGananciasEnCuotas() {
        double monto = 0;

        try {
            abrirConexion();
            String consulta = ("SELECT SUM(p.monto) monto\n"
                    + "FROM Pagos p");
            PreparedStatement ps = conexion.prepareStatement(consulta);

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                monto = resultado.getDouble("monto");

            }
            ps.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return monto;

    }

    public ArrayList<Actividad> getTop3GananciasActividades() {

        ArrayList<Actividad> lista = new ArrayList<>();

        try {
            abrirConexion();
            String consulta = ("SELECT TOP 3  a.NombreActividad, (SUM(a.precioActividad) * COUNT(axs.idActividad)) GANANCIA\n"
                    + "FROM ACTIVIDADES A\n"
                    + "JOIN ActividadesXSocio axs ON axs.idActividad= a.idActividad\n"
                    + "GROUP BY A.NombreActividad\n"
                    + " ORDER BY 2 DESC");
            PreparedStatement ps = conexion.prepareStatement(consulta);

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                String NombreActividad = resultado.getString("NombreActividad");
                double precioActividad = resultado.getDouble("GANANCIA");

                Actividad nuevaActividad = new Actividad();
                nuevaActividad.setNombreActividad(NombreActividad);
                nuevaActividad.setPrecioActividad(precioActividad);

                lista.add(nuevaActividad);
            }
            ps.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Socio> getListadoSociosInscriptosActividadParticular(int idActividad) {

        ArrayList<Socio> lista = new ArrayList<>();

        try {
            abrirConexion();
            String consulta = ("SELECT s.nombreSocio + ' ' + s.apellidoSocio as 'NOMBRE Y APELLIDO'\n"
                    + "FROM ActividadesXSocio axs\n"
                    + "JOIN Socios s ON s.idSocio = axs.idSocio\n"
                    + "WHERE axs.idActividad= ?");
            PreparedStatement ps = conexion.prepareStatement(consulta);

            ps.setInt(1, idActividad);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                String nombreSocio = resultado.getString("NOMBRE Y APELLIDO");

                Socio nuevoSocio = new Socio();
                nuevoSocio.setNombreSocio(nombreSocio);

                lista.add(nuevoSocio);
            }
            ps.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<DtoComboCuota> listadoSocioCuotasPagas(int idSocio) {

        ArrayList<DtoComboCuota> lista = new ArrayList<>();

        try {
            abrirConexion();
            String consulta = ("SELECT C.nroCuota\n"
                    + "FROM PAGOS P\n"
                    + "JOIN CUOTAS C ON C.idCuotas=P.idCuota\n"
                    + "WHERE P.idSocio=?");
            PreparedStatement ps = conexion.prepareStatement(consulta);

            ps.setInt(1, idSocio);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                String cuotaPaga = resultado.getString("nroCuota");

                DtoComboCuota nvaCuota = new DtoComboCuota();
                nvaCuota.setNroCuota(cuotaPaga);

                lista.add(nvaCuota);
            }
            ps.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

//-----------------------------------------------------------------------// 
//------------------------MODULO COMBOS---------------------------//   
    public ArrayList<DtoComboNacionalidad> getComboNacionalidades() {
        ArrayList<DtoComboNacionalidad> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM Nacionalidades");

            while (resultado.next()) {

                int idNacionalidad = resultado.getInt("idNacionalidad");
                String descripcionNacionalidad = resultado.getString("descripcionNacionalidad");

                DtoComboNacionalidad nuevaNacionalidad = new DtoComboNacionalidad(idNacionalidad, descripcionNacionalidad);
                lista.add(nuevaNacionalidad);

            }
            st.close();

            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<DtoComboCuota> getComboCuotas() {
        ArrayList<DtoComboCuota> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM Cuotas");

            while (resultado.next()) {

                int idCuotas = resultado.getInt("idCuotas");
                String nroCuota = resultado.getString("nroCuota");

                DtoComboCuota nuevaCuota = new DtoComboCuota(idCuotas, nroCuota);
                lista.add(nuevaCuota);

            }
            st.close();

            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<DtoTipoDocumento> getComboTipoDocumento() {
        ArrayList<DtoTipoDocumento> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM TiposDocumentos");

            while (resultado.next()) {

                int idTipoDocumento = resultado.getInt("idTipoDocumento");
                String descripcionDocumento = resultado.getString("descripcionDocumento");

                DtoTipoDocumento nuevoTipo = new DtoTipoDocumento(idTipoDocumento, descripcionDocumento);
                lista.add(nuevoTipo);

            }
            st.close();

            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

//-----------------------------------------------------------------------// 
}
