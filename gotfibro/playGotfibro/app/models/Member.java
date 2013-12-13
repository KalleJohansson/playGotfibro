package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.avaje.ebean.Page;

import play.db.ebean.Model;

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
