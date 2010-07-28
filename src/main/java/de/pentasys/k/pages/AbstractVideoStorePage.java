/**
 *
 */
package de.pentasys.k.pages;

import org.apache.wicket.markup.html.WebPage;

import de.pentasys.k.VideoSession;

/**
 * @author <a href="mailto:martin.dilger@pentasys.de">Martin Dilger</a>
 * @since 28.07.2010
 */
public abstract class AbstractVideoStorePage extends WebPage {

    public AbstractVideoStorePage(){
	super();
    }

    /**
     * Accessor Method for the current {@link VideoSession}.
     * @return the Video Session.
     * */
    public VideoSession getSession(){
	return (VideoSession)VideoSession.get();
    }

}
