package models;

import play.*;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.*;

@Entity
public class MemberInfo extends Model {
    
	@Id
	public int member_id;
	
	public String birthday;
	
	@OneToOne
	@JoinColumn(name="member_id")
	public Member member;
}
