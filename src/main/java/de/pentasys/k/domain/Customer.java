package de.pentasys.k.domain;

import java.io.Serializable;

/**
 *
 * Customer.
 *
 * @author <a href="mailto:martin.dilger@pentasys.de">martin dilger</a>
 * created on 24.06.2010
 */
public class Customer implements Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private Adress adress;
	private String email;
	private CustomerType type;

	public Customer(){
	}

	public Customer(String name, String email, CustomerType type, Adress adress) {
		this.email = email;
		this.name = name;
		this.adress = adress;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public CustomerType getType() {
	    return type;
	}

	public void setType(CustomerType type) {
	    this.type = type;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result
		    + ((adress == null) ? 0 : adress.hashCode());
	    result = prime * result + ((email == null) ? 0 : email.hashCode());
	    result = prime * result + ((name == null) ? 0 : name.hashCode());
	    result = prime * result + ((type == null) ? 0 : type.hashCode());
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    Customer other = (Customer) obj;
	    if (adress == null) {
		if (other.adress != null)
		    return false;
	    } else if (!adress.equals(other.adress))
		return false;
	    if (email == null) {
		if (other.email != null)
		    return false;
	    } else if (!email.equals(other.email))
		return false;
	    if (name == null) {
		if (other.name != null)
		    return false;
	    } else if (!name.equals(other.name))
		return false;
	    if (type != other.type)
		return false;
	    return true;
	}

	@Override
	public String toString() {
	    return "Customer [name=" + name + ", adress=" + adress + ", email="
		    + email + ", type=" + type + "]";
	}


}
