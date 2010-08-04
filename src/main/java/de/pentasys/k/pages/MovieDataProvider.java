/**
 *
 */
package de.pentasys.k.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.injection.web.InjectorHolder;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.pentasys.k.domain.Movie;
import de.pentasys.k.domain.VideoStoreFacade;

/**
 * @author <a href="mailto:martin.dilger@pentasys.de">Martin Dilger</a>
 * @since 05.08.2010
 */
public class MovieDataProvider extends SortableDataProvider<Movie>{

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1L;

    private List<Movie> movieList;

    @SpringBean(name = "videoFacade")
    private VideoStoreFacade facade;

    public MovieDataProvider() {
	InjectorHolder.getInjector().inject(this);
	movieList = facade.getMovies();
	setSort(new SortParam("title",true));
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.wicket.markup.repeater.data.IDataProvider#iterator(int,
     * int)
     */
    public Iterator<Movie> iterator(int first, int count) {
	Collections.sort(movieList, new PropertyAwareComparator(getSort()));
	return movieList.iterator();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.wicket.markup.repeater.data.IDataProvider#size()
     */
    public int size() {
	return movieList.size();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.apache.wicket.markup.repeater.data.IDataProvider#model(java.lang.
     * Object)
     */
    public IModel<Movie> model(Movie movie) {
	return Model.of(movie);
    }

    private class PropertyAwareComparator implements Comparator<Movie> {

	private SortParam param;

	public PropertyAwareComparator(SortParam param){
	    this.param = param;
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Movie o1, Movie o2) {
	    boolean ascending = param.isAscending();
	    String property = param.getProperty();

	    PropertyModel<Comparable> m1 = new PropertyModel<Comparable>(o1, property);
	    PropertyModel<Comparable> m2 = new PropertyModel<Comparable>(o2, property);

	    int result = m1.getObject().compareTo(m2.getObject());
	    if(!ascending)
		result*=-1;
	    return result;

	}

    }

}
