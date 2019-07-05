package com.tts.ToDo.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PostLoad;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.ToDo.Model.User;
import com.tts.ToDo.Repository.Repository;
import com.tts.ToDo.Service.UserService;

//import com.tts.ToDo.Service.UserService;
@RequestMapping
@Controller
public class AuthorizationController {

	@Autowired
    private Repository repository;
	@Autowired 
	UserService userService;
	//Array list named posts 
	//inside bracket is the name of the class User
    private static List<User> posts = new ArrayList<>();
    
    @GetMapping(value="/")
    public String index(User user, Model model){
    	// getting the posts and showing on the index page
    	model.addAttribute("posts", posts);
        return "index";
    }
    private User user;
    
    @GetMapping (value= "/results")
    public String update (User user, Model model) {
    	model.addAttribute("posts", posts);
    	return "update";
    }
    
	@PostMapping(value = "/post")
	public String show(User user, Model model) {
		repository.save(user);
		model.addAttribute("id", user.getId());
		model.addAttribute("status", user.getStatus());
		model.addAttribute("title", user.getTitle());
		model.addAttribute("author", user.getAuthor());
		model.addAttribute("description", user.getDescription());
		
		//one liner:
		//model.addAttribute("blog", user);
		// blog can be any name and user is the model class
		//and then in the index file add "blog.title", "blog.author" etc...
		return "results";
		}
	
	@DeleteMapping("/posts/{id}")
	public String deletePostWithId(@PathVariable Long id, User user, Model model) {
    //Path variable looks up the id and implements it into the method
		model.addAttribute("id", user.getId());
		model.addAttribute("status", user.getStatus());
		model.addAttribute("title", user.getTitle());
		model.addAttribute("author", user.getAuthor());
		model.addAttribute("description", user.getDescription());
		repository.deleteById(id);
		return "results";
    
    }
	
	@GetMapping("/edit/{id}")
	 public String update (@PathVariable Long id, Model model, User user) {
		 User task = repository.findById(id).orElse(null);
		 	model.addAttribute("id", task.getId());
			model.addAttribute("status", task.getStatus());
			model.addAttribute("title", task.getTitle());
			model.addAttribute("author", task.getAuthor());
			model.addAttribute("description", task.getDescription());
		model.addAttribute("post", repository.findById(id).orElse(null));
		 return "update";	 
	 }
	
	@PutMapping("/edit/{id}")
	public String updateById(@PathVariable Long id, Model model, User user) {
		System.out.println("testing this");
		 User task = repository.findById(id).orElse(null);
		 repository.save(task);
		 	model.addAttribute("id", task.getId());
			model.addAttribute("status", task.getStatus());
			model.addAttribute("title", task.getTitle());
			model.addAttribute("author", task.getAuthor());
			model.addAttribute("description", task.getDescription());
		model.addAttribute("post", repository.findById(id).orElse(null));
		return "results";
	}
	
	
	
	
}
