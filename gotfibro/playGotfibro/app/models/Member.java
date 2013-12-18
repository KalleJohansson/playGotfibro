package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.Logger;
import play.db.ebean.Model;

import com.avaje.ebean.Page;

@Entity
public class Member extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7943975479692462780L;

	@Id
	public int id;
	
	public String lastname;
	
	public String firstname;
	
	public String address;
	
	public String postcode;
	
	public String postal;
	
	@OneToOne(mappedBy="member")
	public MemberInfo memberInfo;
	
	@OneToOne(mappedBy="member", 
			cascade=CascadeType.ALL)
	public MemberFixedPhone memberFixedPhone;
	
	@OneToOne(mappedBy="member", 
			cascade=CascadeType.ALL)
	public MemberMobilePhone memberMobilePhone;
	
	@OneToOne(mappedBy="member", 
			cascade=CascadeType.ALL)
	public MemberEmail memberEmail;
	
	@ManyToOne
	@JoinColumn(name="id")
	public MemberMembership memberMembership;
	
	public static Finder<Integer, Member> find = new Finder<Integer, Member>(
				Integer.class, Member.class
			);
	
	public static Page<Member> page(int page, int pageSize, String sortBy, String order, String filter) {
		Logger.info("Year no " + filter);
		return find
				.where()
				.ilike("memberMembership.membership_year", "%" + filter + "%")
				.orderBy(sortBy + " " + order)
				.findPagingList(pageSize)
				.setFetchAhead(false)
				.getPage(page);
	}
}
