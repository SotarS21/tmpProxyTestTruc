package org.ProxiBanque.service;

import java.util.List;

import org.ProxiBanque.dao.ICRUDAccount;
import org.ProxiBanque.dao.ICRUDClient;
import org.ProxiBanque.model.BankAccount;
import org.ProxiBanque.model.BankAccount.e_AccountType;
import org.ProxiBanque.model.Client;
import org.ProxiBanque.model.CurrentAccount;
import org.ProxiBanque.model.SavingAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAccount implements IServiceAccount {

	private static final Logger logger = LoggerFactory.getLogger(ServiceAccount.class);
	
	@Autowired
	ICRUDAccount daoAccount;
	
	@Autowired
	ICRUDClient daoClient;
	
	@Override
	public void addAccount(BankAccount account, Client client) {
		logger.debug("test add account 1");
		account.setClient(client);
		daoAccount.save(account);
		if (account.getType().equals(e_AccountType.CURRUENT_ACCOUNT)) {
			CurrentAccount account1 = (CurrentAccount) account;
			client.setCurrentAccount(account1);
			daoClient.save(client);
		}else if (account.getType().equals(e_AccountType.SAVING_ACCOUNT)) {
			SavingAccount account2 = (SavingAccount) account;
			client.setSafeAccount(account2);
			daoClient.save(client);
		}
			
		logger.debug("test add account 2");
	}

	@Override
	public List<BankAccount> listAccounts() {
		logger.debug("test list accounts");
		return daoAccount.findAll();
	}

	@Override
	public void deleteAccount(Long idAccount) {
		logger.debug("test delete account 1");
		daoAccount.delete(idAccount);
		logger.debug("test delete account 2");
	}

	@Override
	public void editAccount(BankAccount account) {
		logger.debug("test edit account 1");
		if (account != null) {
			daoAccount.save(account);
			logger.debug("test edit account 2");
		}
		
	}

	@Override
	public BankAccount getAccount(Long id) {
		return daoAccount.findOne(id);
	}

	@Override
	public List<BankAccount> getAccountsByClientId(Long idClient) {
		return daoAccount.findAllByClient_Id(idClient);
	}

	@Override
	public String doVirement(BankAccount debiteur, BankAccount crediteur, double montant) {
		if (debiteur.getAccountNumber() == crediteur.getAccountNumber()) {
			return "pas le droit pour un m�me compte";
		}else{
			double soldDeb = debiteur.getSold();
			double soldCred = crediteur.getSold();
			debiteur.setSold(soldDeb - montant);
			crediteur.setSold(soldCred + montant);
			this.editAccount(crediteur);
			this.editAccount(debiteur);
		}
		return "Le virement a �t� effectu�";
	}

	
}
