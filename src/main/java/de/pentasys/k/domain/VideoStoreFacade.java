/**
 *
 */
package de.pentasys.k.domain;

import java.util.List;
import java.util.Set;


/**
 * A Facade to encapsulate the Backend Access and provide common functionality
 * for the whole application.
 *
 * @author <a href="mailto:martin.dilger@pentasys.de">Martin Dilger</a>
 * @since 21.07.2010
 */
public interface VideoStoreFacade {

    public List<Movie> getMovies();

    public void submitOrder(Customer customer, Set<Movie> movies) throws SubmitOrderFailedException;

    public Movie getDailyOffer();

}
