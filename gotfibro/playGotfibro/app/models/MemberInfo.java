package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class MemberInfo extends Model {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 7733931381681664666L;

	@Id
	public int member_id;
	
	public String birthday;
	
	@OneToOne
	@JoinColumn(name="member_id")
	public Member member;
}
