/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Backend.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author osdroix
 */
public class usuarios {
    private String Nom_usu, Contraseña_usu,Fecha_Agenda,Nom_Agenda,Agenda,Id_AS;
    private int Id_agenda, Id_usuario;

    public String getNom_usu() {
        return Nom_usu;
    }

    public void setNom_usu(String Nom_usu) {
        this.Nom_usu = Nom_usu;
    }

    public String getContraseña_usu() {
        return Contraseña_usu;
    }

    public void setContraseña_usu(String Contraseña_usu) {
        this.Contraseña_usu = Contraseña_usu;
    }

    public String getFecha_Agenda() {
        return Fecha_Agenda;
    }

    public void setFecha_Agenda(String Fecha_Agenda) {
        this.Fecha_Agenda = Fecha_Agenda;
    }

    public String getNom_Agenda() {
        return Nom_Agenda;
    }

    public void setNom_Agenda(String Nom_Agenda) {
        this.Nom_Agenda = Nom_Agenda;
    }

    public String getAgenda() {
        return Agenda;
    }

    public void setAgenda(String Agenda) {
        this.Agenda = Agenda;
    }

    public int getId_agenda() {
        return Id_agenda;
    }

    public void setId_agenda(int Id_agenda) {
        this.Id_agenda = Id_agenda;
    }

    public int getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(int Id_usuario) {
        this.Id_usuario = Id_usuario;
    }
    public usuarios Validarusuario(String user, String contra){
        usuarios a=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        /*u=null;*/
        try{
              cn = conexion.getConnection();
            String sql="SELECT * FROM usuario WHERE Nom_usu=? AND Contraseña_usu=?";
            pr=cn.prepareStatement(sql);
            pr.setString(1,user);
            pr.setString(2,contra);
            rs=pr.executeQuery();
            while(rs.next()){
                a=new usuarios();
                 a.setId_usuario(rs.getInt("Id_usua"));
                a.setNom_usu(rs.getString("Nom_usu"));
                a.setContraseña_usu(rs.getString("Contraseña_usu"));
          
                break;
                
            }
        }catch(SQLException ex){
            a=null;
        }finally{
            try{;
                rs.close();
            }catch(SQLException ex){
                
            }
        }
        return a;
    }

    public String getId_AS() {
        return Id_AS;
    }

    public void setId_AS(String Id_AS) {
        this.Id_AS = Id_AS;
    }
}
