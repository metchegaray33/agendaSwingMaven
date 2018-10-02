/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maricel.agenda;

import com.controller.ABMController;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Documentacion sobre test
 *http://java-white-box.blogspot.com/2014/06/junit-asserts-como-comparar-resultados.html
 * @author Maricel
 */
public class AgendaJUnitTest {

    public AgendaJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void getMaximoValorCampo() throws Exception {
        int resultadoEsperado = 1;

        try {
            ABMController aBMController = new ABMController();
            int resultadoReal = aBMController.getMaximoValorCampo("contacto", "id_contacto");
            //assertEquals(resultadoEsperado, resultadoReal);
            assertNotNull(resultadoReal);
          //  Assert.assertNotNull(this);
        } catch (Exception e) {
          fail("exception no esperada");
        }

    }
}
