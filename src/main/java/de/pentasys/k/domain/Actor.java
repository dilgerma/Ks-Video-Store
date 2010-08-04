/**
 *
 */
package de.pentasys.k.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <a href="mailto:martin.dilger@pentasys.de">martin dilger</a> created
 *         on 24.06.2010
 */
public class Actor implements Serializable {

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = 1L;

    private String name;
    private Date birthday;
    private int fameIndicator;

    /***/
    public Actor(String name, Date birthday, int fameIndicator) {
	super();
	this.name = name;
	this.birthday = birthday;
	this.fameIndicator = fameIndicator;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Date getBirthday() {
	return birthday;
    }

    public void setBirthday(Date birthday) {
	this.birthday = birthday;
    }

    public int getFameIndicator() {
	return fameIndicator;
    }

    public void setFameIndicator(int fameIndicator) {
	this.fameIndicator = fameIndicator;
    }

    @Override
    public String toString() {
	return "Actor [name=" + name + ", birthday=" + birthday
		+ ", fameIndicator=" + fameIndicator + "]";
    }

}
