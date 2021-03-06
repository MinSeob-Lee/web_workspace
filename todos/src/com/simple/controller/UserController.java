package com.simple.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.service.UserService;
import com.simple.vo.User;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;

@Controller
public class UserController {

	private JSONView jsonView = new JSONView();
	private UserService userService = new UserService();
	
	@RequestMapping("/register.hta")
	public ModelAndView registerUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 요청 파라미터값 조회
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String email = req.getParameter("email");
		
		// User 객체를 생성해서 값 저장
		User user = new User();
		user.setName(name);
		user.setId(id);
		user.setPassword(password);
		user.setEmail(email);
		
		// UserService의 addNewUser(User user)를 실행
		Boolean result = userService.addNewUser(user);
		
		// ModelAndView 객체를 생성
		ModelAndView mav = new ModelAndView();
		// addNewUser의 반환값을 ModelAndView에 담는다.
		mav.addAttribute("result", result);
		// JSON 응답을 제공하기 위해서 ModelAndView에 JSONView 객체를 담는다.
		mav.setView(jsonView);	// 클라이언트에 jsonText 응답을 제공
		// {"result":true} 혹은 {"result":false} JSON 텍스트가 응답으로 제공된다.
		
		// ModelAndView 반환
		return mav;
	}
	
	@RequestMapping("/login.hta")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 요청파라미터 정보를 조회한다.
		String id = req.getParameter("userid");
		String password = req.getParameter("userpwd");
		
		// UserService의 loginCheck(String id, String password)를 실행한다.
		User user = userService.loginCheck(id, password);
		ModelAndView mav = new ModelAndView();
		
		// 반환값이 null이면 ModelAndView에 result -> false를 저장한다.
		if (user == null) {
			mav.addAttribute("result", false);
		}
		
		// 반환값이 null이 아니면 ModelAndView에 result -> true를 저장한다.
		if (user != null) {
			mav.addAttribute("result", true);
			
		// 반환값이 null이 아니면 HttpSession객체를 획득해서 "loginUser"라는 속성명으로 사용자정보를 세션에 저장한다.
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", user);
		}
		
		mav.setView(jsonView);
		
		return mav;
	}
	
	@RequestMapping("/logout.hta")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 세션을 무효화 시킨다.
		HttpSession session = req.getSession(false);
		
		if (session != null) {
			session.invalidate();
		}
		
		// home.hta를 재요청하게 한다. --> ModelAndView에 재요청URL을 담는다.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/home.hta");
		return mav;
	}
}
