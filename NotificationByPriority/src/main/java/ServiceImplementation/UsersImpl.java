package ServiceImplementation;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import net.codejava.model.Users;
import net.codejava.DAO.UserRepo;


import net.codejava.services.UsersService;

public class UsersImpl implements UsersService{

	
	@Autowired 
	private UserRepo ur;
	
	@Override
	public Users addUser(Users user) {
		// TODO Auto-generated method stub
		Users SaveUser = ur.save(user);
		return SaveUser;
	}

	@Override
	public List<Users> getUser() {
		// TODO Auto-generated method stub
		List<Users> allUsers = ur.findAll();
		return allUsers;
	}

	 @Autowired
	    private JavaMailSender mailSender;

	@Override
	public void  SendNotificationEmail(Users user) {
	
		    try {
			    String toAddress = user.getEmail();
			    String fromAddress = "staiang2749@gmail.com";
			    String senderName = "Saujanya Tailang";
			    String subject = "Please verify your registration";
			    String content = "Dear [[name]],<br>"
			            + "Please click the link below to verify your registration:<br>"
			            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
			            + "Thank you,<br>"
			            + "Your company name.";
			     
			    MimeMessage message = mailSender.createMimeMessage();
			    MimeMessageHelper helper = new MimeMessageHelper(message);
			     
			    helper.setFrom(fromAddress, senderName);
			    helper.setTo(toAddress);
			    helper.setSubject(subject);
			     
			    content = content.replace("[[name]]", user.getName());
			   
			     
			    helper.setText(content, true);
			     
			    mailSender.send(message);
		    }
		    catch(Exception e) {
		    	//throw new Exception(e);
		    }
		
	
	}

}
