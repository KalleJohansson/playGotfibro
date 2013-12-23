package controllers;

import static play.data.Form.form;

import java.util.List;

import models.Member;
import models.MemberEmail;
import models.MemberFixedPhone;
import models.MemberMembership;
import models.MemberMobilePhone;
import models.MembershipYear;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.editForm;
import views.html.list;

/**
 * Manage a database of computers
 */
public class Application extends Controller {
    
    /**
     * This result directly redirect to application home.
     */
    public static Result GO_HOME = redirect(
        routes.Application.list(0, "lastname", "asc", "1")
    );
    
    /**
     * Handle default path requests, redirect to computers list
     */
    public static Result index() {
        return GO_HOME;
    }

    /**
     * Display the paginated list of computers.
     *
     * @param page Current page number (starts from 0)
     * @param sortBy Column to be sorted
     * @param order Sort order (either asc or desc)
     * @param filter Filter applied on computer names
     */
    public static Result list(int page, String sortBy, String order, String filter) {
        return ok(
        		list.render(
        				Member.page(page, 10, sortBy, order, filter), 
        				sortBy, order, filter, MembershipYear.find.all()
        				)
        		);
    }
    
    /**
     * Display the 'edit form' of a existing Computer.
     *
     * @param id Id of the computer to edit
     */
    public static Result edit(Integer id) {
        Form<Member> memberForm = form(Member.class).fill(
        		Member.find.byId(id)
        );
        return ok(
            editForm.render(id, memberForm)
        );
    }
    
    /**
     * Handle the 'edit form' submission 
     *
     * @param id Id of the computer to edit
     */
    public static Result update(Integer id) {
        Form<Member> memberForm = form(Member.class).bindFromRequest();
        
        if(memberForm.hasErrors()) {
            return badRequest(editForm.render(id, memberForm));
        }
        MemberEmail mE = memberForm.get().memberEmail;
        MemberMobilePhone mMP = memberForm.get().memberMobilePhone;
        MemberFixedPhone mFP = memberForm.get().memberFixedPhone;
        mE.update(id);
        mMP.update(id);
        mFP.update(id);
        memberForm.get().update(id);
        flash("success", "Medlemmen " + memberForm.get().firstname + "s uppgifter har ändrats");
        return GO_HOME;
    }
    
//    /**
//     * Display the 'new computer form'.
//     */
//    public static Result create() {
//        Form<Computer> computerForm = form(Computer.class);
//        return ok(
//            createForm.render(computerForm)
//        );
//    }
    
//    /**
//     * Handle the 'new computer form' submission 
//     */
//    public static Result save() {
//        Form<Computer> computerForm = form(Computer.class).bindFromRequest();
//        if(computerForm.hasErrors()) {
//            return badRequest(createForm.render(computerForm));
//        }
//        computerForm.get().save();
//        flash("success", "Computer " + computerForm.get().name + " has been created");
//        return GO_HOME;
//    }
    
    /**
     * Handle computer deletion
     */
    public static Result delete(Integer id) {
        Member.find.ref(id).delete();
        flash("success", "Medlemmen har tagits bort");
        return GO_HOME;
    }
    

}
            
