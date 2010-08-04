/**
 *
 */
package de.pentasys.k.validation;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.validator.AbstractValidator;
import org.apache.wicket.validation.validator.EmailAddressValidator;

/**
 * This is a simple Demo-Implementation for a Custom Validator.
 *
 * @see EmailAddressValidator
 *
 * @author <a href="mailto:martin.dilger@pentasys.de">Martin Dilger</a>
 * @since 05.07.2010
 */
public class EmailValidator extends AbstractValidator<String> {

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1L;

    /*
     * (non-Javadoc)
     *
     * @see
     * org.apache.wicket.validation.validator.AbstractValidator#onValidate(org
     * .apache.wicket.validation.IValidatable)
     */
    @Override
    protected void onValidate(IValidatable<String> validatable) {
	String pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z]{2,}){1}$)";
	String email = validatable.getValue();
	if (!email.matches(pattern)) {
	    error(validatable, "email.error");
	}
    }

}
