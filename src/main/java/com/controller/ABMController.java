/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;

import com.dao.impl.ABMDao;

public class ABMController {
	
	/**
	 * Trae el maximo ID cargado en la tabla
	 * @param nombreTabla
	 * @param nombreId
	 * @return
	 * @throws Exception 
	 */
public int getMaximoValorCampo(String nombreTabla, String nombreId) throws Exception{
		
		ABMDao aBMDao= new ABMDao();				 		 
		int maximoValor=aBMDao.getMaximoValorCampo(nombreTabla,nombreId);		
		return maximoValor;
		
	}
	
	
	
}
