package com.conexion;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MEtchegaray
 */
public class AdministradorDeConexiones {
    
    public static Connection getConnection() throws Exception
	{
	// Establece el nombre del driver a utilizar
	//String dbDriver = "com.mysql.jdbc.Driver";
        
         String dbDriver = "com.mysql.cj.jdbc.Driver";   
	// Establece la conexion a utilizar
	//String dbConnString = "jdbc:mysql://localhost/agenda";
        
           // Establece la conexion a utilizar contra la base de datos
        String dbConnString = "jdbc:mysql://localhost/agenda?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        
	// Establece el usuario de la base de datos
	String dbUser = "root";
	// Establece la contraseña de la base de datos
	String dbPassword = "admin";
	// Establece el driver de conexion
	Class.forName(dbDriver).newInstance();
	// Retorna la conexion
	return DriverManager.getConnection(	dbConnString, dbUser, dbPassword);
	}
}
