package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
	@OneToOne(mappedBy="member")
	public MemberFixedPhone memberFixedPhone;
	
	@OneToOne(mappedBy="member")
	public MemberMobilePhone memberMobilePhone;
	
	@OneToOne(mappedBy="member")
	public MemberEmail memberEmail;
	
	public static Finder<Integer, Member> find = new Finder<Integer, Member>(
				Integer.class, Member.class
			);
	
	public static Page<Member> page(int page, int pageSize, String sortBy, String order) {
		return find
				.where()
				.orderBy(sortBy + " " + order)
				.findPagingList(pageSize)
				.setFetchAhead(false)
				.getPage(page);
	}
}
