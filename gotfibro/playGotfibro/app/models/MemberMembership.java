package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class MemberMembership extends Model {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 7790219897434305940L;

	@Id
	public int memberid;
	
	public String membershipyear;
	
	public String membershiptype;
	
	@OneToMany
	public List<Member> members;
	
//	@ManyToOne
//	@JoinColumn(name="memberid")
//	public Member member;
	
//	@OneToOne
//	public MembershipYear membershipYear;
	
	public static Finder<Integer, MemberMembership> find = new Finder<Integer, MemberMembership>(
			Integer.class, MemberMembership.class
		);
}
