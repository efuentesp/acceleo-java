package com.softtek.demo.test.dao;

import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;

import com.softtek.acceleo.demo.domain.Cliente;
import com.softtek.acceleo.demo.repository.ClienteRepository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

public class ClienteTest {

		private static Log log = LogFactory.getLog(ClienteTest.class);
		
//		@Autowired
//		private ClienteRepository clienteRepository;
//		
//		@Before
//		public void setup() {
//			super.setup();
//		}
//
//		@Test
//		public void findAll() throws Exception {
//
//			List<Cliente> result = clienteRepository.listAllClientes();
//			assertEquals(1, result.size());
//
//		}
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
