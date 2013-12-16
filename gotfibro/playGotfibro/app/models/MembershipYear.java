package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class MembershipYear extends Model {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public int year_id;
	
	public String year;
	
	public static Finder<Integer, MembershipYear> find = new Finder<Integer, MembershipYear>(
			Integer.class, MembershipYear.class
		);
	
	}
