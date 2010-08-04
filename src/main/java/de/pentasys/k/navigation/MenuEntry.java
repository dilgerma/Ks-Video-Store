/**
 *
 */
package de.pentasys.k.navigation;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;

/**
 * @author <a href="mailto:martin.dilger@pentasys.de">Martin Dilger</a>
 * @since 29.07.2010
 */
public class MenuEntry implements Serializable {

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1L;

    private Class<? extends WebPage> targetPage;
    private String displayName;

    public MenuEntry(Class<? extends WebPage> targetPage, String displayName) {
	super();
	this.targetPage = targetPage;
	this.displayName = displayName;
    }

    public Class<? extends WebPage> getTargetPage() {
	return targetPage;
    }

    public void setTargetPage(Class<? extends WebPage> targetPage) {
	this.targetPage = targetPage;
    }

    public String getDisplayName() {
	return displayName;
    }

    public void setDisplayName(String displayName) {
	this.displayName = displayName;
    }

}
