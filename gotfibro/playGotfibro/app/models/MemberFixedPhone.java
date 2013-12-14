package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class MemberFixedPhone extends Model {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -4415116847842831325L;

	@Id
	public int member_id;
	
	public String phonenumber;
	
	@OneToOne
	@JoinColumn(name="member_id")
	public Member member;
}
