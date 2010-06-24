package de.pentasys.k;

import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.Request;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;

import de.pentasys.k.domain.Customer;
import de.pentasys.k.domain.Movie;

/***
 * Simple Session to access the current Customer
 * and its selected movies.
 *
 * @author <a href="mailto:martin.dilger@pentasys.de">martin dilger</a>
 * created on 24.06.2010
 */
public class VideoSession extends WebSession{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	public VideoSession(Request request) {
		super(request);
	}

	private Customer customer;
	private List<Movie> selectedMovies;


	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Movie> getSelectedMovies() {
		return selectedMovies;
	}
	public void setSelectedMovies(List<Movie> selectedMovies) {
		this.selectedMovies = selectedMovies;
	}

	public static VideoSession get(){
		return (VideoSession) Session.get();
	}

}
