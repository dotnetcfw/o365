package hqr.o365.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hqr.o365.service.ChkUser;

@Controller
public class LoginCtrl {

	@Autowired
	private ChkUser cu;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String goHome(@RequestParam(name="userid") String userid,@RequestParam(name="pwd") String pwd) {
		String ind = cu.checkCredential(userid, pwd);
		if("Y".equals(ind)) {
			return "home";
		}
		else {
			return "login";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String goLogin() {
		return "login";
	}
}
