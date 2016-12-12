package com.letzchaat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.letzchaat.dao.UserDao;
import com.letzchaat.model.User;

@RestController
public class UserController {
	@Autowired
	private UserDao userDao;
	@RequestMapping(value="/addUser", method=RequestMethod.POST,headers="Accept=application/json")
	public void addUser(@RequestBody User user)
	{
		userDao.addUser(user);
	}
	 @RequestMapping(value = "/getUsers", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public List<User> getUsers()
	 {
		 List<User> users=userDao.viewUsers();
		return users;
	 }
	 @RequestMapping(value="/updateUser",method=RequestMethod.PUT,headers="Accept=application/json")
	 public void updateUser(@RequestBody User user)
	 {
		 userDao.update(user);
	 }
	 @RequestMapping(value="/getUser/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	 public @ResponseBody User getUserById(@PathVariable("id") int id)
	 {
		 System.out.println("User Id:"+id);
		 return userDao.viewUserById(id);
	 }
	 @RequestMapping(value="/authenticate", method=RequestMethod.POST,headers="Accept=application/json")
	 public int authenticateUser(@RequestBody User user)
	 {
		 System.out.println("username:"+user.getUsername());
		 System.out.println("password:"+user.getPassword());
	int result=0;
		 result=userDao.validateUser(user.getUsername(),user.getPassword());
		 System.out.println("result we have got is:"+result);
		 return result;
	 }

}
