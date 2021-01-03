package com.vsystem.evento.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vsystem.evento.model.Usuario;
import com.vsystem.evento.repository.UserRespository;

@Controller

public class HomeController {
	
	@Autowired
	private UserRespository repo;
	
	@RequestMapping(value="/home")	
	public String home() {
		return "usuario";
	}
	
	@RequestMapping(value="/")
	@ResponseBody
	public String Empty() {
		return "hello home";
	}
	
	@RequestMapping(value="/getData")
	public String getData(HttpServletRequest req) {
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
		HttpSession session = req.getSession();
		session.setAttribute("usuario", usuario);
		session.setAttribute("senha", senha);
		return "home";
	}
	
	@RequestMapping(value="/getLoginData")
	public ModelAndView getLoginData(@RequestParam("usuario") String usuario, @RequestParam("senha") String senha) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", usuario);
		mv.addObject("senha", senha);
		mv.setViewName("home");
		return mv;		
	}
	
	@RequestMapping(value="/getUserData")
	public ModelAndView getUserData(Usuario user) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("home");
		repo.save(user);
		return mv;		
	}

}
