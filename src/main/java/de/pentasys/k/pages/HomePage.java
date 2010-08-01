package de.pentasys.k.pages;

import java.util.Arrays;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.form.EnumChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import de.pentasys.k.VideoSession;
import de.pentasys.k.domain.Customer;
import de.pentasys.k.domain.CustomerType;
import de.pentasys.k.validation.EmailValidator;

/**
 *
 * @author <a href="mailto:martin.dilger@pentasys.de">Martin Dilger</a>
 * @since 04.07.2010
 */
public class HomePage extends AbstractVideoStorePage {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor that is invoked when page is invoked without a session.
     *
     * @param parameters
     *            Page parameters
     */
    @SuppressWarnings("rawtypes")
    public HomePage(final PageParameters parameters) {

	final Customer customer = createEmptyCustomer();

	Form form = new Form<Customer>("customerForm",
		new CompoundPropertyModel<Customer>(customer));
	final TextField<String> nameField = new TextField<String>("name");
	nameField.setRequired(true);
	final TextField<String> emailField = new TextField<String>("email");
	emailField.setRequired(true);
	emailField.add(new EmailValidator());
	final RadioChoice<CustomerType> customerTypeChoice = new RadioChoice<CustomerType>(
		"type", Arrays.asList(CustomerType.values()),
		new EnumChoiceRenderer<CustomerType>());
	customerTypeChoice.setRequired(true);
	final TextField<String> streetField = new TextField<String>(
		"adress.street");
	final TextField<String> zipField = new TextField<String>("adress.zip");
	final TextField<String> cityField = new TextField<String>("adress.city");
	final TextField<String> houseNumberField = new TextField<String>(
		"adress.houseNumber");

	form.add(new FeedbackPanel("feedback"));

	form.add(nameField);
	form.add(emailField);
	form.add(customerTypeChoice);
	form.add(streetField);
	form.add(houseNumberField);
	form.add(zipField);
	form.add(cityField);

	form.add(new SubmitLink("submit") {
	    /**
	     * Serial Version UID
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
