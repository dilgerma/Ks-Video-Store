package de.pentasys.k;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

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

	final Customer customer = createEmptyCustomer();

	Form form = new Form<Customer>("customerForm", new CompoundPropertyModel<Customer>(customer));
	final TextField<String> nameField = new TextField<String>("name");
	final TextField<String> emailField = new TextField<String>("email");
	final TextField<String> streetField = new TextField<String>("adress.street");
	final TextField<String> zipField = new TextField<String>("adress.zip");
	final TextField<String> cityField = new TextField<String>("adress.city");
	final TextField<String> houseNumberField = new TextField<String>(
		"adress.houseNumber");

	form.add(nameField);
	form.add(emailField);
	form.add(streetField);
	form.add(houseNumberField);
	form.add(zipField);
	form.add(cityField);
	form.add(new SubmitLink("submit") {
	    /**
			 *
			 */
	    private static final long serialVersionUID = 1L;

	    @Override
	    public void onSubmit() {
		// store new customer in session
		((VideoSession) getSession()).setCustomer(customer);
	    }
	});
	add(form);
    }

    protected Customer createEmptyCustomer() {
	Customer customer = new Customer();
	return customer;
    }
}
