/**
 *
 */
package de.pentasys.k.domain;

import java.io.Serializable;

/**
 * @author <a href="mailto:martin.dilger@pentasys.de">martin dilger</a> created
 *         on 24.06.2010
 */
public class Adress implements Serializable {

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1L;

    private String street;
    private String houseNumber;
    private String zip;
    private String city;

    public Adress(String street, String houseNumber, String zip, String city) {
	super();
	this.street = street;
	this.houseNumber = houseNumber;
	this.zip = zip;
	this.city = city;
    }

    public String getStreet() {
	return street;
    }

    public void setStreet(String street) {
	this.street = street;
    }

    public String getHouseNumber() {
	return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
	this.houseNumber = houseNumber;
    }

    public String getZip() {
	return zip;
    }

    public void setZip(String zip) {
	this.zip = zip;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result
		+ ((houseNumber == null) ? 0 : houseNumber.hashCode());
	result = prime * result + ((zip == null) ? 0 : zip.hashCode());
	result = prime * result + ((street == null) ? 0 : street.hashCode());
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
	Adress other = (Adress) obj;
	if (city == null) {
	    if (other.city != null)
		return false;
	} else if (!city.equals(other.city))
	    return false;
	if (houseNumber == null) {
	    if (other.houseNumber != null)
		return false;
	} else if (!houseNumber.equals(other.houseNumber))
	    return false;
	if (zip == null) {
	    if (other.zip != null)
		return false;
	} else if (!zip.equals(other.zip))
	    return false;
	if (street == null) {
	    if (other.street != null)
		return false;
	} else if (!street.equals(other.street))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Adress [street=" + street + ", houseNumber=" + houseNumber
		+ ", zip=" + zip + ", city=" + city + "]";
    }

}
