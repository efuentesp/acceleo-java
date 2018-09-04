package com.softtek.demo.test.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.Cliente;
import com.softtek.acceleo.demo.repository.ClienteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/applicationContext.xml")
public class ClienteTest {

		private static Log log = LogFactory.getLog(ClienteTest.class);
		
		@Autowired
		private ClienteRepository clienteRepository;
		
		@Before
		public void setup() {
			//super.setup();
			System.out.println("********Iniciando pruebas de ClienteTest...");
		}

		@Test
		@Transactional
		public void findAll() throws Exception {
			int idClientePadre = 1;
			try {
			System.out.println("********Ejecutando JUnit()... findAll - " + clienteRepository);
			List<Cliente> result = clienteRepository.listClientes(idClientePadre);//listAllClientes();
			System.out.println("********El numero de clientes obtenidos es: " + result.size());
			//assertEquals(1, result.size());
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
//		
//		@Test
//		public void findAllIsActive() throws Exception {
//
//			List<Country> result = countryDao.findAllIsActive();
//			assertEquals(1, result.size());
//
//		}
//		
//		@Test
//		public void findAllByUser() throws Exception {
//
//			int userId = 1; 
//			int reportId = 1;
//			List<Country> result = countryDao.findAllByUser(userId,reportId);
//			assertEquals(1, result.size());
//
//		}
//		
//		@Test
//		public void findById() throws Exception {
//
//			Country result = countryDao.findById(1);
//			log.debug("Resultado: " + result.getCountryId());
//			assertEquals(1, result);
//
//		}
//		
//		@Test
//		public void update() throws Exception {
//
//			final Country u = new Country();
//			u.setCountryId(1);
//			
//			int result = countryDao.update(u);
//			
//			//assertEquals(0, result.size());
//		}
//		
//		@Test
//		public void create() throws Exception {
//
//			final Date currentDt = new Date();
//			
//			Country c1 = new Country();
//			c1.setCountryId(1);
//			c1.setCountryNm("Mexico");
//			c1.setActive(true);
//			c1.setCodeIso("ISO");
//			c1.setShortNm("MX");
//			c1.setCreateDt(new Timestamp(currentDt.getTime()));
//			c1.setUpdateDt(new Timestamp(currentDt.getTime()));
//			
//			int result = countryDao.create(c1);
//			//assertEquals(0, result.size());
//		}
//		
//		@Test
//		public void delete() throws Exception {
//
//			final Country u = new Country();
//			u.setCountryId(1);
//			
//			int result = countryDao.delete(u);
//			//assertEquals(0, result);
//		}

	
}
