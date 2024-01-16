/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Entidades.usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author osdroix
 */
public class CRUD {
    public static int guardar(usuarios e){
        
        int estado = 0;
        try{
            Connection con = conexion.getConnection();
           String q="insert into usuario (Id_usua,Nom_usu,Contraseña_usu)values(?,?,?)";
            PreparedStatement set=con.prepareStatement(q);
            set.setInt(1, e.getId_usuario());
            set.setString(2, e.getNom_usu());
            set.setString(3, e.getContraseña_usu());
            System.out.println("Tabla registro encontrada");
             estado = set.executeUpdate();
             
                System.out.print(e);
                con.close();
        }catch(Exception d){
            System.out.println("NO HAY TABLA  registro");
            System.out.println(d.getMessage());
            
                System.out.print(e);
            System.out.println(d.getStackTrace());
        }
        return estado;
    
    }
    public static int guardarAgenda(usuarios e){
        
        int estado = 0;
        try{
            Connection con = conexion.getConnection();
           String q="insert into agenda (Id_agenda,Id_usuario,Fecha_Agenda,Nom_Agenda,Agenda)values(?,?,?,?,?)";
            PreparedStatement set=con.prepareStatement(q);
            set.setInt(1, e.getId_agenda());
            set.setString(2, e.getId_AS());
            set.setString(3, e.getFecha_Agenda());
            set.setString(4, e.getNom_Agenda());
            set.setString(5, e.getAgenda());
            System.out.println("Tabla agenda encontrada");
             estado = set.executeUpdate();
             
                System.out.print(e);
                con.close();
        }catch(Exception d){
            System.out.println("NO HAY TABLA agenda");
            System.out.println(d.getMessage());
            System.out.println(d.getStackTrace());
            
                System.out.print(e);
        }
        return estado;
    
    }
     public static ArrayList<usuarios> getagenda( String fecha){
        
        ArrayList<usuarios> agendas = new ArrayList();
        
        try{
            Connection c = conexion.getConnection();
            
            String x = "select * from usuario INNER JOIN agenda ON usuario.Id_usua=agenda.Id_usuario where Fecha_Agenda like '"+fecha+"'";
            PreparedStatement set1 = c.prepareStatement(x);
            ResultSet rs = set1.executeQuery();
            while (rs.next()) {
                usuarios u = new usuarios();
                u.setNom_Agenda(rs.getString("Nom_Agenda"));
                u.setFecha_Agenda(rs.getString("Fecha_Agenda"));
                u.setAgenda(rs.getString("Agenda"));
                agendas.add(u);
            }
            c.close();
            
        }catch(Exception e){
            
            System.out.println(e.getMessage()+"Quezo");
            System.out.println(e.getStackTrace()+"Quezo3");
            
        }
        
        return agendas;
     }
     public static ArrayList<usuarios> getagendalista(int i){
        
        ArrayList<usuarios> agendas = new ArrayList();
        
        try{
            Connection c = conexion.getConnection();
            
            String x = "select * from usuario INNER JOIN agenda ON usuario.Id_usua=agenda.Id_usuario where Id_usuario like '"+i+"'";
            PreparedStatement set1 = c.prepareStatement(x);
            ResultSet rs = set1.executeQuery();
            while (rs.next()) {
                usuarios u = new usuarios();
                u.setId_agenda(rs.getInt("Id_agenda"));
                u.setNom_Agenda(rs.getString("Nom_Agenda"));
                u.setFecha_Agenda(rs.getString("Fecha_Agenda"));
                u.setAgenda(rs.getString("Agenda"));
                agendas.add(u);
            }
            c.close();
            
        }catch(Exception e){
            
            System.out.println(e.getMessage()+"Quezo");
            System.out.println(e.getStackTrace()+"Quezo3");
            
        }
        
        return agendas;
     }
     
}
