package org.ProxiBanque.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *	Bean Advisor regroupe les informations du conseiler  : Le user , La liste des clients  
 * 
 * @author Jonas, Kevin, Andy, Mathieu 
 *
 */

@Entity
//@Table(name="ADVISOR")
@DiscriminatorValue("A")
public class Advisor extends Person{

	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy="advisor")
	private List<Client> clients = new ArrayList<>();
	
	public Advisor(String firstName, String lastName, Address address, User user) {
		super(firstName, lastName, address);
		this.user = user;
	}
	public Advisor(String firstName, String lastName, Address address) {
		super(firstName, lastName, address);
	}
	public User getUser() {
		return user;
	}
	public Collection<Client> getClients() {
		return clients;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public Advisor() {
		super();
	}
	
	@Override
	public String toString() {
		return "Advisor [user=" + user + ", clients=" + clients + "]";
	}
	
	/**
	 * Ajout un client dans la liste des clients du conseiller
	 * @param cl : client
	 */
	public void addClient(Client cl)
	{
		this.clients.add(cl);
	}
	
}
