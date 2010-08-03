/**
 *
 */
package de.pentasys.k.pages;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.pentasys.k.domain.Actor;
import de.pentasys.k.domain.Movie;
import de.pentasys.k.domain.VideoStoreFacade;

/**
 * @author <a href="mailto:martin.dilger@pentasys.de">Martin Dilger</a>
 * @since 03.08.2010
 */
public class SelectMoviePage extends AbstractVideoStorePage {

    @SpringBean(name = "videoFacade")
    private VideoStoreFacade videoFacade;

    public SelectMoviePage() {
	List<Movie> movieList = videoFacade.getMovies();
	Form<List<? extends Movie>> form = new Form<List<? extends Movie>>(
		"movieForm", Model.ofList(movieList));

	form.add(new PropertyListView<Movie>("movieList", Model
		.ofList(movieList)) {

	    /**
	     * Serial Version UID
	     */
	    private static final long serialVersionUID = 1L;

	    @Override
	    protected void populateItem(ListItem<Movie> item) {
		item.add(new Label("title"));
		item.add(new PropertyListView<Actor>("actors", item
			.getModelObject().getActors()) {
		    /**
		     * Serial Version UID
		     */
		    private static final long serialVersionUID = 1L;

		    /*
		     * (non-Javadoc)
		     *
		     * @see
		     * org.apache.wicket.markup.html.list.ListView#populateItem
		     * (org.apache.wicket.markup.html.list.ListItem)
		     */
		    @Override
		    protected void populateItem(ListItem<Actor> item) {
			item.add(new Label("name"));
		    }
		});
		item.add(new Label("prizePerDay"));
	    }

	});
	add(form);
    }

}
