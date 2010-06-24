package de.pentasys.k.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/***
 * Movie.
 *
 * @author <a href="mailto:martin.dilger@pentasys.de">martin dilger</a>
 * created on 24.06.2010
 */
public class Movie implements Serializable {



	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	private List<Actor> actors;
	private Date releaseDate;
	private double prizePerDay;

	public Movie(String title, List<Actor> actors, Date releaseDate,
			double prizePerDay) {
		super();
		this.title = title;
		this.actors = actors;
		this.releaseDate = releaseDate;
		this.prizePerDay = prizePerDay;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getPrizePerDay() {
		return prizePerDay;
	}

	public void setPrizePerDay(double prizePerDay) {
		this.prizePerDay = prizePerDay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prizePerDay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (Double.doubleToLongBits(prizePerDay) != Double
				.doubleToLongBits(other.prizePerDay))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}



}
