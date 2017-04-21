package org.ProxiBanque.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.ProxiBanque.config.ApplicationConfig;
import org.ProxiBanque.dao.ICRUDAdvisor;
import org.ProxiBanque.model.Address;
import org.ProxiBanque.model.Advisor;
import org.ProxiBanque.model.Client;
import org.ProxiBanque.model.Client.e_ClientType;
import org.ProxiBanque.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class AdvisorTestService {

	
	@Autowired
	ICRUDAdvisor dao;
	
	@Autowired
	IServiceAdvisor service;
	
	@Autowired
	IServiceClient clientService;

	private static final Logger logger = LoggerFactory.getLogger(AdvisorTestService.class);

//	@Test
//	public void testAdvisorService() {
//		assertNotNull(service);
//	}
//
//	@Test
//	public void testAddAdvisor() {
//		Advisor advisor = new Advisor("Jean", "Valjean", new Address("10", "75010", "Paris"), new User("jean", "jean"));
//
//		advisor.setCellphone("09784556");
//		advisor.setEmail("jean.valjean@gmail.com");
//
//		int presize = service.findAll().size();
//		service.save(advisor);
//		int postSize = service.findAll().size();
//		assertTrue(presize < postSize);
//	}
//
//	@Test
//	public void testListFindByName() {
//		Advisor advisor = new Advisor("Jean", "Valjean", new Address("10", "75010", "Paris"), new User("jean", "jean"));
//
//		advisor.setCellphone("09784556");
//		advisor.setEmail("jean.valjean@gmail.com");
//
//		service.save(advisor);
//		int size = service.findByLastNameAndFirstNameAllIgnoreCase("Valjean", "jean").size();
//		assertTrue(size > 0);
//	}
//
//	@Test
//	public void testUpdate() {
//		Advisor advisor = new Advisor("Jean", "Valjean", new Address("10", "75010", "Paris"), new User("jean", "jean"));
//		advisor.setCellphone("09784556");
//		advisor.setEmail("jean.valjean@gmail.com");
//
//		service.save(advisor);
//		List<Advisor> advisors = service.findByLastNameAndFirstNameAllIgnoreCase("Valjean", "jean");
//
//		Advisor advisor2 = advisors.get(advisors.size() - 1);
//
//		advisor2.setAddress(new Address("78", "77420", "Champ sur Marne"));
//		service.update(advisor2);
//		List<Advisor> advisors2 = service.findByLastNameAndFirstNameAllIgnoreCase("Valjean", "jean");
//		// System.out.println("-------------------------------------------
//		// advisor = "+advisor);
//		// System.out.println("-------------------------------------------
//		// advisor2 = "+advisors2.get(advisors.size()-1));
//		assertFalse(
//				advisor.getAddress().getZipCode().equals(advisors2.get(advisors.size() - 1).getAddress().getZipCode()));
//	}
//
//	@Test
//	public void testDelete() {
//		Advisor advisor = new Advisor("Jean", "Valjean", new Address("10", "75010", "Paris"), new User("jean", "jean"));
//		advisor.setCellphone("09784556");
//		advisor.setEmail("jean.valjean@gmail.com");
//
//		service.save(advisor);
//		List<Advisor> advisors = service.findByLastNameAndFirstNameAllIgnoreCase("Valjean", "jean");
//		int sizeBefor = advisors.size();
//		service.delete(advisors.get(0).getId());
//		int sizeAfter = service.findByLastNameAndFirstNameAllIgnoreCase("Valjean", "jean").size();
//		assertTrue(sizeBefor > sizeAfter);
//	}

//	@Test
//	public void testCreateAndUpdateAdvisorWithClient() {
//		System.out.println("((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((");
//		Advisor advisor = new Advisor("Deni", "Devis", new Address("65 rue allייייייי", "75010", "Paris"),
//				new User("Deni", "Deni"));
//		advisor.setCellphone("09784556");
//		advisor.setEmail("Deni.vdevisn@gmail.com");
//
//		Client client = new Client("Fallafel", "Gilon", new Address("45 rue de lalilou", "78015", "Labaville"),
//				e_ClientType.CASUAL_CLIENT, false, advisor);
//		
//		System.out.println("TA RACE ADD CLIENT INTO ADVISOR");
////		advisor.addClient(client);
//		advisor.getClients().add(client);
//
//		System.out.println("_____________________________BEFOR SAVE____________________________________");
////		service.save(advisor);
//		clientService.save(client);
//		List<Advisor> listAdvisor = service.findAll();
//		logger.debug("---------------------CreateAndUpdateAdvisorWith-----------------------------");
//		System.out.println("listAdvisor size = "+listAdvisor.size());
////		logger.debug("advisor into client = "+client.getAdvisor());
////		logger.debug(" client inot advisor = "+advisor.getClients());
//		Advisor advisor2 = listAdvisor.get(listAdvisor.size()-1);
//		System.out.println(" set cellphone sur "+advisor2.getFirstName());
//		advisor2.setCellphone("100000");
//		service.save(advisor2);
//		System.out.println(" fist cellphone = "+advisor.getCellphone()+" , secound cellphone = "+advisor2.getCellphone()+" id : "+advisor2.getId());
//		assertTrue(!advisor.getCellphone().equals(advisor2.getCellphone()));
//	}
	
	@Test
	public void testUpdateAdvisor()
	{
		System.out.println("____________________________________Find ADVISOR");
		Advisor advisor = null;//= dao.findOne(59L);
		for (Advisor e : dao.findAll()) {
			System.out.println(" advisor id "+ e.getId());
		}
		System.out.println("advisor = "+advisor);
		
		advisor.setFirstName("QODFJQDSKFGHSDRFLKGS");
		System.out.println("____________________________________SAVE BEFOR "+advisor);
		service.save(advisor);
		System.out.println("____________________________________FINI");
		assertTrue(true);
	}
}
