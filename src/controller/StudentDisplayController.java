package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentDisplayController 
{
	
	public JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate=jdbcTemplate;
	}
	@RequestMapping("/insert")
	public ModelAndView insertStudent(HttpServletRequest request,HttpServletResponse response)
	{
		String name=request.getParameter("name");
		String course=request.getParameter("course");
		int roll=Integer.parseInt(request.getParameter("roll"));
		String query="insert into student values("+roll+",'"+name+"','"+course+"')";
		
		int i=jdbcTemplate.update(query);
		return new ModelAndView("outputMessage","message","Rows inserted");
	}

}
