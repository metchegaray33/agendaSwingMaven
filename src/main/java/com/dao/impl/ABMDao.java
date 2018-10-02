/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.conexion.AdministradorDeConexiones;

public class ABMDao {

    /**
     * Ejecuta la sentencia sql que recibe: puede ser insert, update o remove
     * Son insert simples de solo una tabla. No se necesita transaccion por ello
     *
     * @param updateString string con la query completa
     */
    public void update(String updateString) throws Exception {

        System.out.println("Ingresando a update DAO:" + updateString);
        Connection laConexion = AdministradorDeConexiones.getConnection();
        Statement stmt = laConexion.createStatement();
        stmt.executeUpdate(updateString);

        // Cierra el Statement y la Connection
        stmt.close();
        laConexion.close();
        System.out.println("Actualizacion Exitosa");
    }

    /**
     * Trae el maximo valor de ID que hay en la tabla.
     *
     * @param nombreTabla
     * @param nombreId
     * @return numero maximo id
     */
    public int getMaximoValorCampo(String nombreTabla, String nombreId) throws Exception {

        System.out.println("Ingresando a getMaximoValorCampo DAO");
        int maxReg = 0;
        Connection laConexion = AdministradorDeConexiones.getConnection();
        // Arma la consulta y la ejecuta				
        String consultaString = "SELECT MAX(" + nombreId + " )  as max FROM " + nombreTabla;
        System.out.println(consultaString);
        Statement stmtConsulta = laConexion.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(consultaString);

        // Muestra los datos
        while (rs.next()) {
            maxReg = rs.getInt("max");
            System.out.println("ID recuperado: " + maxReg);
        }

        // Cierra el Statement y la Connection	
        stmtConsulta.close();
        laConexion.close();
        System.out.println("Fin getMaximoValorCampo EXITOSO");
        return maxReg;

    }

    /**
     * Este metodo busca por un determinado id en la tabla.
     *
     * @param nombreTabla
     * @param id
     * @return true si existe ya el registro y false sino.
     * @throws Exception
     */
    public boolean existeRegistro(String nombreTabla, String nombreId, int id) throws Exception {

        System.out.println("Ingresando a existeRegistro de DAO");
        boolean existeRegistro = false;
        Connection laConexion = AdministradorDeConexiones.getConnection();
        // Arma la consulta y la ejecuta

        String consultaString = "SELECT " + nombreId + "  FROM  " + nombreTabla + " where " + nombreId + "='" + id + "'";
        System.out.println(consultaString);

        Statement stmtConsulta = laConexion.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(consultaString);
        // Muestra los datos
        while (rs.next()) {

            int maxReg = rs.getInt(nombreId);
            System.out.println("ID recuperado existente: " + maxReg);
            existeRegistro = true;
        }

        // Cierra el Statement y la Connection	
        stmtConsulta.close();
        laConexion.close();
        System.out.println("Fin existeRegistro EXITOSO");
        return existeRegistro;
    }

    /**
     * Trae una lista de objetos por el ID
     *
     * @param nombreTabla
     * @param id
     * @return
     * @throws Exception
     */

    public List<Object[]> getListOfObjectByIdy(String nombreTabla, String nombreId, int id) throws Exception {
        System.out.println("Ingresando a getListOfObjectByIdy  DAO");
        Connection laConexion = AdministradorDeConexiones.getConnection();
        // Arma la consulta y la ejecuta				
        String consultaString = "SELECT *  FROM " + nombreTabla + " where " + nombreId + " = " + id;
        System.out.println(consultaString);
        Statement stmtConsulta = laConexion.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(consultaString);
        List<Object[]> records = new ArrayList<Object[]>();
        // Muestra los datos

        while (rs.next()) {
            int cols = rs.getMetaData().getColumnCount();
            Object[] arr = new Object[cols];
            for (int i = 0; i < cols; i++) {
                arr[i] = rs.getObject(i + 1);
            }

            System.out.println("Cantidad de campos del objeto:" + arr.length);
            records.add(arr);
        }

        System.out.println("Cantidad de objetos:" + records.size());

        // Cierra el Statement y la Connection
        stmtConsulta.close();
        laConexion.close();
        System.out.println("Fin getListOfObjectByIdy EXITOSO");
        return records;

    }

    /**
     * Trae todos los objetos de un determinado tipo
     *
     * @param nombreTabla
     * @return
     * @throws Exception
     */
    public List<Object[]> traerTodos(String nombreTabla) throws Exception {
        System.out.println("Ingresando a traerTodos  ABMlDAO");
        Connection laConexion = AdministradorDeConexiones.getConnection();
        // Arma la consulta y la ejecuta				
        String consultaString = "SELECT *  FROM " + nombreTabla;
        System.out.println(consultaString);
        Statement stmtConsulta = laConexion.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(consultaString);
        List<Object[]> records = new ArrayList<Object[]>();
        // Muestra los datos

        while (rs.next()) {
            int cols = rs.getMetaData().getColumnCount();
            Object[] arr = new Object[cols];
            for (int i = 0; i < cols; i++) {
                arr[i] = rs.getObject(i + 1);
            }

            //   System.out.println("Cantidad de campos del objeto:" + arr.length);
            records.add(arr);
        }

        System.out.println("Cantidad de objetos:" + records.size());

        // Cierra el Statement y la Connection
        stmtConsulta.close();
        laConexion.close();
        System.out.println("Fin traerTodos EXITOSO");
        return records;

    }

    public List<Object[]> traerTodosByCriteria(String consultaString) throws Exception {
        System.out.println("Ingresando a traerTodos  traerTodosByCriteria");
        Connection laConexion = AdministradorDeConexiones.getConnection();
        // Arma la consulta y la ejecuta
        System.out.println(consultaString);
        Statement stmtConsulta = laConexion.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(consultaString);
        List<Object[]> records = new ArrayList<Object[]>();
        // Muestra los datos

        while (rs.next()) {
            int cols = rs.getMetaData().getColumnCount();
            Object[] arr = new Object[cols];
            for (int i = 0; i < cols; i++) {
                arr[i] = rs.getObject(i + 1);
            }

            //   System.out.println("Cantidad de campos del objeto:" + arr.length);
            records.add(arr);
        }

        System.out.println("Cantidad de objetos:" + records.size());

        // Cierra el Statement y la Connection
        stmtConsulta.close();
        laConexion.close();
        System.out.println("Fin traerTodosByCriteria EXITOSO");
        return records;

    }

    /**
     * Traa un objeto por un determinado ID
     *
     * @param queryString
     * @return
     * @throws Exception
     */
    public Object[] getObjectByIdy(String queryString) throws Exception {
        System.out.println("Ingresando a getObjectByIdy  DAO");
        Connection laConexion = AdministradorDeConexiones.getConnection();
        // Arma la consulta y la ejecuta		
        System.out.println(queryString);
        Statement stmtConsulta = laConexion.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(queryString);
        Object object = new Object();
        // Muestra los datos
        Object[] arr = null;
        while (rs.next()) {

            int cols = rs.getMetaData().getColumnCount();
            arr = new Object[cols];
            for (int i = 0; i < cols; i++) {
                arr[i] = rs.getObject(i + 1);
            }

            System.out.println("Cantidad de campos del objeto:" + arr.length);

        }

        // Cierra el Statement y la Connection
        stmtConsulta.close();
        laConexion.close();
        System.out.println("Fin getObjectByIdy EXITOSO");
        return arr;

    }

}
