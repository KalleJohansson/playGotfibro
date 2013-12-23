package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Page;
import com.avaje.ebean.Query;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

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
	
//	@OneToMany(mappedBy="member")
//	public List<MemberMembership> memberShips;
	
	public List<MemberMembership> myMembership(){
		List<MemberMembership> ms 
				= MemberMembership.find
				.where()
				.eq("memberid", this.id)
				.findList();
		return ms;
	}
	
	public List<MembershipYear> allYears(){
		return MembershipYear.find.all();
	}
	
	public static Finder<Integer, Member> find = new Finder<Integer, Member>(
				Integer.class, Member.class
			);
	
	public static Page<Member> page(int page, int pageSize, String sortBy, String order, String filter) {
		return find
				.where()
				.ilike("memberMembership.membershipyear", "%" + filter + "%")
				.orderBy(sortBy + " " + order)
				.findPagingList(pageSize)
				.setFetchAhead(true)
				.getPage(page);
	}
}
