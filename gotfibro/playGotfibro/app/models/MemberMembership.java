package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class MemberMembership extends Model {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 7790219897434305940L;

	@Id
	public int member_id;
	
	public int membership_year;
	
	public String membership_type;
	
	@OneToMany
	public List<Member> members;
	
	public static Finder<Integer, MemberMembership> find = new Finder<Integer, MemberMembership>(
			Integer.class, MemberMembership.class
		);
}
