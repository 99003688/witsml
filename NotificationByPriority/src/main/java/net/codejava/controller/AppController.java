package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.model.Users;
import net.codejava.services.UsersService;

@RestController
public class AppController {



	@Autowired
	private UsersService us;
	
	@PostMapping("/adduser")
	public Users addUser(@RequestBody Users u)
	{
		if(u.isSendViaEmail()) {
			System.out.println("email logged in");
			us.SendNotificationEmail(u);
			
		}
		if(u.isSendViaMessage()) {
			System.out.println("text logged in");
		}
		
		return this.us.addUser(u);
	}
	
	@GetMapping("/getuser")
	 public List<Users> getUser()
	{
		return this.us.getUser();
	}
	
//	@Autowired
//	private CoinRepository CoinRepo;
//	
//	@Autowired
//	private BuyerRepository BuyerRepo;
//	
//	@Autowired
//	private UserServices service;
//	
//	@GetMapping("")
//	public ModelAndView viewHomePage() {
//		return new ModelAndView("index");
//	}
//	
//	
//
//	@GetMapping("/register")
//	public ModelAndView showRegistrationForm(Model model) {
//		model.addAttribute("user", new User());
//		
//		return new ModelAndView("signup_form");
//	}
//	
//	@PostMapping("/process_register")
//	public ModelAndView processRegister(User user, HttpServletRequest request) 
//			throws UnsupportedEncodingException, MessagingException {
//		service.register(user, getSiteURL(request));		
//		return new ModelAndView("ver");
//	}
//	
//	private String getSiteURL(HttpServletRequest request) {
//		String siteURL = request.getRequestURL().toString();
//		return siteURL.replace(request.getServletPath(), "");
//	}	
//	
//	@GetMapping("/verify")
//	public ModelAndView verifyUser(@Param("code") String code) {
//		if (service.verify(code)) {
//			return new ModelAndView("verify_success");
//		} else {
//			return new ModelAndView("verify_fail");
//		}
//	}
//	
//	@GetMapping("/up")
//	public ModelAndView updatebla(Model model)
//	{
//		List<Coin> listBuyers = CoinRepo.findByBought();
//		model.addAttribute("listBuyers", listBuyers);
//		return new ModelAndView("buyy");
//	}
//	
//	
//	@GetMapping("/buyfg")
//	public ModelAndView listBuyers(Model model) {
//		
//		List<Coin> listBuyers = CoinRepo.findByBuyId();
//		model.addAttribute("listBuyers", listBuyers);
//		
//		
//		List<Coin> listSellers = CoinRepo.findByBought();
//		model.addAttribute("listSellers", listSellers);
//		return new ModelAndView("buy");
//	}
//	
//	
//	@GetMapping("/Coinregistration")
//	public ModelAndView CoinRegistration(Model model,HttpServletRequest req) {
////		String email=req.getParameter("email");
////		model.addAttribute("email", email);
//		return new ModelAndView("CoinReg");
//	}
//	@PostMapping("/coin_registeration")
//	public ModelAndView CoinRegister(Coin Coin,Model model,@RequestParam(value = "email",required = false) String email) {
//		
//		List<Coin> listStuff = CoinRepo.findByEmail(email);
//		model.addAttribute("listStuff", listStuff);
//		CoinRepo.save(Coin);
//		return new ModelAndView("Stuff");
//	}
//	
//	@GetMapping("/BuyerRegistration/cid={cid}")
//	public ModelAndView BuyerRegistration(Model model, @PathVariable("cid") int cid) {
//			
//		 
//		
//		    Coin c= CoinRepo.findByCoinId(cid);
//		    c.setBuy("Bought");
//		    CoinRepo.save(c);
//			
//			return new ModelAndView("BuyerRegistration");
//			}
//		
//		@PostMapping("/buyer1")
//		public ModelAndView BuyerRegister(Buyer Buyer) {
//			
//			
//			
//			BuyerRepo.save(Buyer);
//			
//			return new ModelAndView("successBuy");
//		}
//		
//		@GetMapping("/remote")
//		public ModelAndView rem(Model model,HttpServletRequest req)
//		{
//			User u = new User();
//			String email=u.getEmail();
//			model.addAttribute("email", email);
//			return new ModelAndView("neww");
//		}
}
