package planmytrip.user.service.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.entity.Role;
import com.assessment.service.RoleService;

@RequestMapping("/role")
@RestController
@CrossOrigin("*")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/getAllRoles")
	public Set<Role> getAllUserRoles(){
		return roleService.getAllRoles();
	}
}
