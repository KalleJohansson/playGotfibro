package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class MembershipYear extends Model {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public int yearid;
	
	public String year;
	
//	@OneToOne
//	@JoinColumn(name="yearid")
//	public MemberMembership memberMembership;
	
	public static Finder<Integer, MembershipYear> find = new Finder<Integer, MembershipYear>(
			Integer.class, MembershipYear.class
		);
	
	}
