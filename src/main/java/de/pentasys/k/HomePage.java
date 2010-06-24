package de.pentasys.k;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import de.pentasys.k.domain.Customer;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	// TODO Add any page properties or variables here

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 *
	 * @param parameters
	 *            Page parameters
	 */
	@SuppressWarnings("rawtypes")
	public HomePage(final PageParameters parameters) {

		final Customer customer = createNewCustomer();

		Form form = new Form("customerForm");
		form.add(new TextField<String>("name", new PropertyModel<String>(
				customer, "name")));
		form.add(new TextField<String>("email", new PropertyModel<String>(
				customer, "email")));
		form.add(new TextField<String>("street", new PropertyModel<String>(
				customer, "adress.street")));
		form.add(new TextField<String>("houseNumber",
				new PropertyModel<String>(customer, "adress.houseNumber")));
		form.add(new TextField<String>("zip", new PropertyModel<String>(
				customer, "adress.zip")));
		form.add(new TextField<String>("city", new PropertyModel<String>(
				customer, "adress.city")));
		form.add(new SubmitLink("submit") {
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				((VideoSession)getSession()).setCustomer(customer);
				System.out.println(customer);
			}
		});
		add(form);
	}

	protected Customer createNewCustomer() {
		return new Customer();
	}
}
