package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class MemberEmail extends Model {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -7642516896233030997L;

	@Id
	public int memberid;
	
	public String email;
	
	@OneToOne
	@JoinColumn(name="memberid")
	public Member member;
}
