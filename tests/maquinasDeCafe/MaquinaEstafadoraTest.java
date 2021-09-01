package maquinasDeCafe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaquinaEstafadoraTest {

	MaquinaDeCafe maquina;
	
	@Before
	public void setUp() {
		maquina = new MaquinaEstafadora();		
	}
	
	@Test
	public void queDevuelveUnVasoAlServir() {
		VasoDeCafe vaso = maquina.servirCafe();
		assertNotNull(vaso);		
	}
	
	@Test
	public void quePuedeServirUnCafe() {
		assertTrue(maquina.puedeServir());	
	}

	@Test
	public void queElPrimerVasoEstaLlenoYElSiguienteVacio() {
		assertTrue(maquina.servirCafe().estaLleno());
		assertFalse(maquina.servirCafe().estaLleno());	
		assertTrue(maquina.servirCafe().estaLleno());
		assertFalse(maquina.servirCafe().estaLleno());
	}
	
	@Test
	public void queSeAgotaElCafe() {
		for (int i = 0; i < 200; i++) {
			maquina.servirCafe();
		}
		assertFalse(maquina.puedeServir());	
	}
	
	

}
