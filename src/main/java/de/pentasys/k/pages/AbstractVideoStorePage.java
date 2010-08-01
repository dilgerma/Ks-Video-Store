/**
 *
 */
package de.pentasys.k.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import de.pentasys.k.VideoSession;
import de.pentasys.k.navigation.MenuEntry;

/**
 * @author <a href="mailto:martin.dilger@pentasys.de">Martin Dilger</a>
 * @since 28.07.2010
 */
public abstract class AbstractVideoStorePage extends WebPage {

    public AbstractVideoStorePage() {
	super();
	initHeaderContributions();
	add(new ListView<MenuEntry>("navigationList", getMenuEntries()) {

	    /**
	     * Serial Version UID
	     * */
	    public static final long serialVersionUID = 1l;

	    /*
	     * (non-Javadoc)
	     *
	     * @see
	     * org.apache.wicket.markup.html.list.ListView#populateItem(org.
	     * apache.wicket.markup.html.list.ListItem)
	     */
	    @Override
	    protected void populateItem(ListItem<MenuEntry> item) {
		BookmarkablePageLink<MenuEntry> entryLink = new BookmarkablePageLink<MenuEntry>("entry",item.getModelObject().getTargetPage());
		entryLink.add(new Label("title", item.getModelObject()
			.getDisplayName()));
		item.add(entryLink);
	    }
	});
    }

    /**
     * Accessor Method for the current {@link VideoSession}.
     *
     * @return the Video Session.
     * */
    public VideoSession getSession() {
	return (VideoSession) VideoSession.get();
    }

    /**
     * @return a List of MenuEntries.
     */
    protected List<MenuEntry> getMenuEntries() {
	List<MenuEntry> entries = new ArrayList<MenuEntry>();
	entries.add(new MenuEntry(HomePage.class, "Filmauswahl"));
	entries.add(new MenuEntry(HomePage.class, "Bestellen"));
	entries.add(new MenuEntry(HomePage.class, "Bestätigung"));
	return entries;
    }

    protected void initHeaderContributions(){
	add(CSSPackageResource.getHeaderContribution(AbstractVideoStorePage.class, "style.css"));
    }


}
