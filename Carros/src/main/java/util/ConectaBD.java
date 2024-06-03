/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Administrador
 */
public class ConectaBD {
    Connection con;
    Statement stmt;
    public static String DataSetName = "jdbc/carros";

    public ConectaBD() {
    }
    public String testarConexao()throws Exception{
        
        try {
            ResultSet r = getResultset("select 1>0");
            if (r.next()) {
                return "Conexão bem sucedida!";
            }
               
        } catch (Exception e) {
            return "Conexão mal sucedida!" + e.getMessage();
        }
        return "Erro";
            
        
    
    }
    public void executa(String sql) throws Exception {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup(DataSetName);
            con = ds.getConnection();
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            fecha();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e);
        }
    }
    public ResultSet getResultset(String sql) throws Exception {
        try {
            
            Context envContext = new InitialContext();
            Context initContext = (Context) envContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) initContext.lookup(DataSetName);
            con = ds.getConnection();
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            fecha();
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }

    }
    
    private void fecha() {
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
        }
    }
    
}
