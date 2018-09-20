/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dao.impl.ABMDao;
import com.util.Constantes;
import com.valueobject.ContactoVO;


public class ABMContactoController extends ABMController {

	String idString=Constantes.ID_CONTACTO;
	private final static String nombreTabla="contacto";
	
	/**
	 * Inserta el registro en la tabla
	 * @param insertString
	 * @throws Exception 
	 */
	public void insertOrUpdate(ContactoVO vo) throws Exception{
		
	//	System.out.println("Ingresando a insertOrUpdate de ABMROLCONTROLLER");
		
		ABMDao aBMDao= new ABMDao();			
		boolean esUpdate=aBMDao.existeRegistro("contacto",idString,vo.getId());
			
        
		String queryUpdateEmpresa=null;
		 
		if (esUpdate){			
			
				
			queryUpdateEmpresa="UPDATE `contacto` SET  `razon_social`='" + vo.getRazonSocial() + "',`domicilio`='" + vo.getDomicilio()  + "',`pagina_web`='" + vo.getWeb() + "',`email`='" + vo.getEmail() + "',`telefono`='" + vo.getTelefono();
			queryUpdateEmpresa+= "',`fax`='" + vo.getFax() ;	
			queryUpdateEmpresa=queryUpdateEmpresa + "' where " + idString + "='" + vo.getId() + "'";	
			
		}else{			
			
			
			queryUpdateEmpresa="INSERT INTO `contacto`(`id_contacto`, `razon_social`, `domicilio`, `pagina_web`, `email`, `telefono`, `fax`)VALUES ( '" ;	
			
			queryUpdateEmpresa+= vo.getId() + "','" ;
			queryUpdateEmpresa+= vo.getRazonSocial() + "','" ;					
			queryUpdateEmpresa+= vo.getDomicilio() + "','" ;			
			queryUpdateEmpresa+= vo.getWeb()+ "','" ;
			queryUpdateEmpresa+= vo.getEmail()+ "','" ;			
			queryUpdateEmpresa+= vo.getTelefono()+ "','" ;
			queryUpdateEmpresa+= vo.getFax()+ "')" ;
			
			
			

		}
		
		
		//System.out.println(queryUpdateEmpresa);				
		aBMDao.update(queryUpdateEmpresa);
		
	}
	
	/**
	 * Inserta el registro en la tabla
	 * @param insertString
	 * @throws Exception 
	 */
	public void remove(ContactoVO vo) throws Exception{
	//	System.out.println("Ingresando a remove de ABMROLCONTROLLER");
		ABMDao aBMDao= new ABMDao();
		String queryUpdateEmpleado = "DELETE FROM " + nombreTabla + "  where " + idString + " = '" + vo.getId() + "'";
		//System.out.println(queryUpdateEmpleado);
		aBMDao.update(queryUpdateEmpleado);		
		
	}
	
	
	/**
	 * Borra todos los registros de la tabla empleado y usuario	 *
	 * @throws Exception 
	 */
	public void removeAll() throws Exception{
		//System.out.println("Ingresando a remove de ABMROLCONTROLLER");
		ABMDao aBMDao= new ABMDao();
		String queryUpdateEmpleado = "DELETE FROM " + nombreTabla ;		
		//System.out.println(queryUpdateEmpleado);
		aBMDao.update(queryUpdateEmpleado);				
	}
	
	
/**
 * Encuentra el primer registro de la tabla
 * @return
 * @throws Exception
 */
	public ContactoVO  encontrarPrimerRegistro() throws Exception{			
		//System.out.println("Ingresando a encontrarPrimerRegistro");
		String queryString = "SELECT * FROM " + nombreTabla + "  order by " + idString + " limit 0,1;";	
		//System.out.println(queryString);
		ABMDao aBMDao= new ABMDao();		
		Object[] o=aBMDao.getObjectByIdy(queryString);		
		ContactoVO vo= new ContactoVO();
		
		if (o !=null){		
			
			return populateEmpresaVO(o, vo);
			
		}else{
			
			return vo;
		}
		
		
	}
	/**
	 * Encuentra el registro anterior del registro actual
	 * @param idActual
	 * @return
	 * @throws Exception
	 */
	
public ContactoVO  encontrarAnteriorRegistro(ContactoVO vo) throws Exception{		
	    //System.out.println("Ingresando a encontrarAnteriorRegistro");
		String queryString = "SELECT * FROM " + nombreTabla + " where " +  idString + " <" + vo.getId() + " order by " + idString  + " desc limit 0,1";	
		//System.out.println(queryString);
		ABMDao aBMDao= new ABMDao();		
		Object[] o=aBMDao.getObjectByIdy(queryString);	
		ContactoVO vo1= new ContactoVO();	
		
		if (o !=null){	
				
			return populateEmpresaVO(o, vo1);
			
		}else{
			
			return traerObjetoById(vo.getId());
		}
		
	}
	
/**
 * Encuentra el registro PosteriorRegistro
 * @param idActual
 * @return
 * @throws Exception
 */
public ContactoVO  encontrarPosteriorRegistro(ContactoVO vo) throws Exception{			
	//System.out.println("Ingresando a encontrarPosteriorRegistro");
	String queryString = "SELECT * FROM " + nombreTabla + "  where " +  idString + " > " + vo.getId() + " order by  " + idString + " asc limit 0,1";	
	//System.out.println(queryString);
	ABMDao aBMDao= new ABMDao();		
	Object[] o=aBMDao.getObjectByIdy(queryString);	
	
	ContactoVO vo1= new ContactoVO();		
	
	if (o !=null){		
		
		return populateEmpresaVO(o, vo1);
		
	}else{
		return traerObjetoById(vo.getId());
		
	}
	
	
	
}
/**
 * Encuentra el ultimo registro
 * @param rolVOIn
 * @return
 * @throws Exception
 */
public ContactoVO  encontrarUltimoRegistro(ContactoVO vo) throws Exception{			

	//System.out.println("Ingresando a encontrarUltimoRegistro");
	String queryString = "SELECT * FROM " + nombreTabla + "  where " +  idString +  " >" + vo.getId() + " order by " + idString +" desc limit 0,1";	
	//System.out.println(queryString);
	ABMDao aBMDao= new ABMDao();		
	Object[] o=aBMDao.getObjectByIdy(queryString);	
	
	ContactoVO vo1= new ContactoVO();		
	
	if (o !=null){		
		
		return populateEmpresaVO(o, vo1);
		
	}else{
		
		return traerObjetoById(vo.getId());
		
		
	}
	
}
/**
 * Completa los datos de Empleado a partir de datos traidos de la BD
 * @param o
 * @param vo1
 * @return
 * @throws Exception
 */
private ContactoVO populateEmpresaVO(Object[] o, ContactoVO vo1)	throws Exception {
	
	vo1.setId(( (Integer)o[0]).intValue());	
	vo1.setRazonSocial((String)o[1]);
	
	
	vo1.setDomicilio((String)o[2]);
	
	
	vo1.setWeb((String)o[3]);
	vo1.setEmail((String)o[4]);	
	vo1.setTelefono((String)o[5]);
        
        System.out.println ("telefono que traigo:" + vo1.getTelefono());
        
	vo1.setFax((String)o[6]);
	
	
	
	return vo1;
}
	
/**
 * Trae el objeto empleado por el id del empleado
 * @param idValue
 * @return
 * @throws Exception
 */
public ContactoVO traerObjetoById(int idValue) throws Exception{
	
	ABMDao aBMDao= new ABMDao();		
	Object[] o=aBMDao.getObjectByIdy("SELECT * FROM " + nombreTabla + "  where " +  idString + " = " + idValue);		
	ContactoVO empresaVO= new ContactoVO();			
	if (o !=null){				
		return populateEmpresaVO(o, empresaVO);
	}else{		
		 return null;
	}
	
 }







/**
 * Trae una col
 * @param idValue  1-CARRIER| 2-CLIENTE
 * @return List<EmpresaVO>
 * @throws Exception
 */
public List<ContactoVO>traerTodosTipoEmpresa() throws Exception{
	
	ABMDao aBMDao= new ABMDao();		
	List<Object[]> listObject=aBMDao.traerTodosByCriteria("SELECT id_empresa,razon_social FROM " + nombreTabla);		
	List<ContactoVO>  listEmpresaVO=new ArrayList();
	Iterator it=listObject.iterator();		
	while (it.hasNext()){						
		Object[] o=(Object[]) it.next();			
		int cols =o.length ;			
		//System.out.println("Cantidad de campos del objeto:" + cols);	
		ContactoVO vo=new ContactoVO();	
                vo.setId(( (Integer)o[0]).intValue());
		vo.setRazonSocial((String)o[1]);	
		listEmpresaVO.add(vo);	
	}
	
	//System.out.println("cantidad de objetos de la lista:" + listEmpresaVO.size());
	return listEmpresaVO;
	
 }

}

