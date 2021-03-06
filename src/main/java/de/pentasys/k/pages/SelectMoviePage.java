/**
 *
 */
package de.pentasys.k.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeaderlessColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.pentasys.k.VideoSession;
import de.pentasys.k.domain.Actor;
import de.pentasys.k.domain.Movie;
import de.pentasys.k.domain.SubmitOrderFailedException;
import de.pentasys.k.domain.VideoStoreFacade;

/**
 * @author <a href="mailto:martin.dilger@pentasys.de">Martin Dilger</a>
 * @since 05.08.2010
 */
public class SelectMoviePage extends AbstractVideoStorePage {

    @SpringBean(name = "videoFacade")
    private VideoStoreFacade videoFacade;

    private FeedbackPanel feedbackPanel;

    public SelectMoviePage() {

	MovieDataProvider movieDataProvider = new MovieDataProvider();

	Form<List<? extends Movie>> form = new Form<List<? extends Movie>>(
		"movieForm", Model.ofList(videoFacade.getMovies()));

	form.add(feedbackPanel = new FeedbackPanel("feedback"));
	feedbackPanel.setOutputMarkupId(true);

	DataTable<Movie> dataTable = new DataTable<Movie>("movieTable",
		createMovieColumnList(), movieDataProvider, 5);
	dataTable.setTableBodyCss("movieTable");
	dataTable
		.addTopToolbar(new HeadersToolbar(dataTable, movieDataProvider));
	form.add(dataTable);
	form.add(new AjaxSubmitLink("submit") {

	    /**
	     * Serial Version UID
	     */
	    private static final long serialVersionUID = 1L;

	    @Override
	    protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
		try {
		    videoFacade.submitOrder(VideoSession.get().getCustomer(),
			    VideoSession.get().getSelectedMovies());
		} catch (SubmitOrderFailedException e) {
		    /*
		     * If an Exception occurs, just show the Error-Message
		     * and stay in the Page.
		     * */
		    error(e.getMessage());
		    target.addComponent(feedbackPanel);
		    return;
		}
		setResponsePage(ConfirmationPage.class);
	    }

	});

	add(form);
    }

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
    private IColumn<Movie>[] createMovieColumnList() {
	List<IColumn<Movie>> columnList = new ArrayList<IColumn<Movie>>();
	IColumn<Movie> titleColumn = new PropertyColumn<Movie>(
		new Model<String>("Titel"), "title", "title") {
	    /**
	     * Serial Version UID
	     */
	    private static final long serialVersionUID = 1L;

	    /*
	     * (non-Javadoc)
	     *
	     * @see
	     * org.apache.wicket.extensions.markup.html.repeater.data.table.
	     * AbstractColumn#getCssClass()
	     */
	    @Override
	    public String getCssClass() {
		return "movieColumnBig";
	    }
	};
	IColumn<Movie> actorsColumn = new PropertyColumn<Movie>(
		new Model<String>("Schauspieler"), "actors") {
	    /**
	     * Serial Version UID
	     */
	    private static final long serialVersionUID = 1L;

	    /*
	     * (non-Javadoc)
	     *
	     * @see
	     * org.apache.wicket.extensions.markup.html.repeater.data.table.
	     * PropertyColumn
	     * #populateItem(org.apache.wicket.markup.repeater.Item,
	     * java.lang.String, org.apache.wicket.model.IModel)
	     */
	    @Override
	    public void populateItem(Item<ICellPopulator<Movie>> item,
		    String componentId, IModel<Movie> rowModel) {
		item.add(new ActorsFragment(componentId, SelectMoviePage.this,
			new Model((Serializable) rowModel.getObject()
				.getActors())));
	    }

	    /*
	     * (non-Javadoc)
	     *
	     * @see
	     * org.apache.wicket.extensions.markup.html.repeater.data.table.
	     * AbstractColumn#getCssClass()
	     */
	    @Override
	    public String getCssClass() {
		return "movieColumnMedium";
	    }
	};
	IColumn<Movie> prizeColumn = new PropertyColumn<Movie>(
		new Model<String>("Preis / Tag"), "prizePerDay", "prizePerDay") {
	    /**
	     * Serial Version UID
	     */
	    private static final long serialVersionUID = 1L;

	    /*
	     * (non-Javadoc)
	     *
	     * @see
	     * org.apache.wicket.extensions.markup.html.repeater.data.table.
	     * AbstractColumn#getCssClass()
	     */
	    @Override
	    public String getCssClass() {
		return "movieColumnSmall";
	    }
	};
	IColumn<Movie> submitColumn = new HeaderlessColumn<Movie>() {

	    /**
	     * Serial Version UID
	     */
	    private static final long serialVersionUID = 1L;

	    public void populateItem(Item<ICellPopulator<Movie>> cellItem,
		    String componentId, IModel<Movie> rowModel) {
		cellItem.add(new LinkFragment(componentId,
			SelectMoviePage.this, rowModel));
	    }

	    /*
	     * (non-Javadoc)
	     *
	     * @see
	     * org.apache.wicket.extensions.markup.html.repeater.data.table.
	     * AbstractColumn#getCssClass()
	     */
	    @Override
	    public String getCssClass() {
		return "movieColumnSmall";
	    }

	};

	columnList.add(titleColumn);
	columnList.add(actorsColumn);
	columnList.add(prizeColumn);
	columnList.add(submitColumn);

	return columnList.toArray(new IColumn[0]);
    }

    private static class ActorsFragment extends Fragment {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 * @param markupId
	 * @param markupProvider
	 */
	public ActorsFragment(String id, MarkupContainer markupProvider,
		IModel<List<Actor>> model) {
	    super(id, "actorsListFragment", markupProvider, model);
	    add(new PropertyListView<Actor>("actorsList", model) {

		/**
		 * Serial Version UID
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void populateItem(ListItem<Actor> item) {
		    item.add(new Label("name"));
		}

	    });
	}


    }

    private static class LinkFragment extends Fragment {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 * @param markupId
	 * @param markupProvider
	 */
	public LinkFragment(String id, MarkupContainer markupProvider,
		IModel<Movie> model) {
	    super(id, "linkFragment", markupProvider, model);
	    AjaxLink<Movie> link;
	    add(link = new AjaxLink<Movie>("order", model) {

		/**
		 * Serial Version UID
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void onClick(AjaxRequestTarget target) {
		    VideoSession.get().getSelectedMovies()
			    .add(getModelObject());
		    target.addComponent(this);
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see org.apache.wicket.Component#isVisible()
		 */
		@Override
		public boolean isVisible() {
		    Set<Movie> selectedMovies = VideoSession.get()
			    .getSelectedMovies();
		    return !selectedMovies.contains(getModelObject());
		}
	    });
	    link.add(new Label("title", "Bestellen"));
	}

    }

}
