package org.ProxiBanque.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.ProxiBanque.model.BankAccount;
import org.ProxiBanque.model.Client;
import org.ProxiBanque.service.IServiceAccount;
import org.ProxiBanque.service.IServiceClient;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;




/**
 * Classe de contr�ler permettant d'effectuer des actions sur le client dans nos pages xhtml
 * 
 * @author kevin jonas
 *
 */

@Controller
@SessionScope
public class ClientController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BankAccount bankAccount;

	private  List<Client> listClient = new ArrayList<>();
	private  List<Client> listFilter = new ArrayList<>();
	private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	

	@Autowired
	private IServiceClient serviceClient;
	@Autowired
	private IServiceAccount serviceAccount;

	
	public List<Client> getListClient() {
		return listClient;
	}
	public List<Client> getListFilter() {
		return listFilter;
	}

	
	@PostConstruct
	private void init() {
		
		serviceClient.init();
//		serviceAccount.init();
	}
	

	
	

	
	public void loadClients() {
		listClient.clear();
		LOGGER.debug("Load all client in BDD");
		try {
			listClient = serviceClient.findAll();//findByConseiller_Id(3L);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
/**
 * Appelle le service pour effectuer une mise � jour sur la basse de donn�es
 * @param client : r�cup�re le client a modifier
 * @return la page de destination. Si erreur dans la m�thode il restera sur la page en cours
 */
	public void updateClient() {
		LOGGER.debug("Update Client!");
//		try {
//			serviceClient.update(client);
//
//		} catch (Exception e) {
//			return null;
//		}
//		return "listClient";
	}

	/**
	 * Appelle le service pour supprimer le client dans la basse de donn�es 
	 * @param id : identifiant du client
	 * @return la page de destination. Si erreur dans la m�thode il restera sur la page en cours
	 */
	public String deleteClient(long id) {
		LOGGER.info("Delete CLient!");
		try {
			serviceClient.delete(id);
		} catch (Exception e) {

			LOGGER.error("error virement:" + e.getMessage());
			return null;
		}
		return "listClient";
	}
	
	public List<BankAccount> accountLoad(Client client){
			List<BankAccount> listAccount = new ArrayList<>();
			listAccount.add(client.getSafeAccount());
			listAccount.add(client.getCurrentAccount());
		return listAccount;
	}

	/**
	 * Appelle le service pour supprimer le compte dans la basse de donn�es 
	 * @param idClient : identifiant du client
	 * @param account : compte � supprimer
	 * @return la page de destination. Si erreur dans la m�thode il restera sur la page en cours
	 */

	public void cancel(RowEditEvent event) {
		LOGGER.info("Cancel modification!");
	}

	/**
	 * Appelle le service pour cr�er un compt �pargne au client dans la basse de donn�es 
	 * @param client : envois le client sur lequel cr�er un compte �pargne
	 * @return la page de destination. Si erreur dans la m�thode il restera sur la page en cours
	 */
	public String addSavingAccount(Client client) {
		try {
			//serviceAccount.addAccountToClient(client.getId(), e_AccountType.SAVING_ACCOUNT, 80);
		} catch (Exception e) {

			LOGGER.error("error virement:" + e.getMessage());
			return null;
		}
		return "listClient";
	}

	/**
	 * Appelle le service pour cr�er un compt courrant au client dans la basse de donn�es 
	 * @param client : envois le client sur lequel cr�er un compte courrant
	 * @return la page de destination. Si erreur dans la m�thode il restera sur la page en cours
	 */
	public String addCurrentAccount(Client client) {
		try {
			//serviceAccount.addAccountToClient(client.getId(), e_AccountType.CURRENT_ACCOUNT, 80);
		} catch (Exception e) {
			LOGGER.error("error virement:" + e.getMessage());
			return null;
		}
		return "listClient";
	}


}
