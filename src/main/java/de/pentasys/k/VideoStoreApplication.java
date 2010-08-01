package de.pentasys.k;

import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import de.pentasys.k.pages.HomePage;

/***
 * Application.
 *
 * @author <a href="mailto:martin.dilger@pentasys.de">martin dilger</a>
 * created on 24.06.2010
 */
public class VideoStoreApplication extends WebApplication
{
    /**
     * Constructor
     */
	public VideoStoreApplication()
	{
	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}


	@Override
	public Session newSession(Request request, Response response) {
		return new VideoSession(request);
	}

	/* (non-Javadoc)
	 * @see org.apache.wicket.protocol.http.WebApplication#init()
	 */
	@Override
	protected void init() {
	    super.init();
	    addComponentInstantiationListener(new SpringComponentInjector(this));
	}
}
