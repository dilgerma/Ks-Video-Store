/**
 *
 */
package de.pentasys.k.domain;

/**
 * @author <a href="mailto:martin.dilger@pentasys.de">Martin Dilger</a>
 * @since 21.07.2010
 */
public class SubmitOrderFailedException extends Exception {

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1L;

    public SubmitOrderFailedException(String message, Throwable t) {
	super(message, t);
    }

    public SubmitOrderFailedException(String message) {
	super(message);
    }
}
