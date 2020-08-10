package com.ahmedeid.securityandjwt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedeid.securityandjwt.demo.entities.Player;
import com.ahmedeid.securityandjwt.demo.entities.SysExerciseType;
import com.ahmedeid.securityandjwt.demo.entities.User;
import com.ahmedeid.securityandjwt.demo.repository.HQLDaoService;
import com.ahmedeid.securityandjwt.demo.services.PlayerService;
import com.ahmedeid.securityandjwt.demo.services.SysExerciseTypeService;
import com.ahmedeid.securityandjwt.demo.services.UserService;
import com.ahmedeid.securityandjwt.demo.uibean.ChangePassword;
import com.ahmedeid.securityandjwt.demo.uibean.UserUIBean;

@CrossOrigin
@RestController
@RequestMapping(value = "/adminServiceIntegration")
public class AdminServiceIntegration {

	@Autowired
	private SysExerciseTypeService sysExerciseTypeService;

	@Autowired
	private UserService userService;

	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private HQLDaoService hqlDaoService;

	// get list of exercise type
	@GetMapping(value = "/getSysExerciseTypeList")
	public List<SysExerciseType> getSysExerciseTypeList() {
		return this.sysExerciseTypeService.getAll();
	}

	// get list of users
	@GetMapping(value = "/getUsersList")
	public List<User> getUsersList() {
		return this.userService.getAll();
	}

	// get list of users
	@GetMapping(value = "/getPlayersList")
	public List<Player> getPlayersList() {
		return this.playerService.getAll();
	}

	@DeleteMapping(value = "/deletePlayer/{id}")
	public boolean deletePlayer(@PathVariable int id) {
		boolean status = false;
		status = this.playerService.deletePlayerById(id);

		return status;
	}

	// get userBy id
	@GetMapping(value = "/getUserById/{id}")
	public User getUserById(@PathVariable int id) {
		return this.userService.getUserById(id);
	}

	// update user admin ...
	@PutMapping(value = "/updateUserAdmin/{id}")
	public User updateUserAdmin(@RequestBody UserUIBean userUI, @PathVariable int id) {

		User user = this.userService.getUserById(id);
		User saveUser = null;

		if (user != null && (user.getId() == userUI.getId())) {
			User newUser = new User();
			newUser.setId(userUI.getId());
			newUser.setEmail(userUI.getEmail());
			newUser.setUserName(userUI.getUsername());
			newUser.setPassword(user.getPassword());
			newUser.setCode(user.getCode());
			newUser.setIsAdmin(0);

			saveUser = userService.saveUserWithExistPassword(newUser);
		}

		return saveUser;
	}

	// delete user admin ...
	@DeleteMapping(value = "/deleteUserAdmin/{id}")
	public void deleteUserAdmin(@PathVariable int id) {
		this.userService.deleteUser(id);
	}
	
	@PutMapping(value = "updateUserPassword/{id}")
	public boolean updateUserPassword(@RequestBody ChangePassword changePassword, @PathVariable int id) {
		boolean status = false;
		if(changePassword != null && id != 0) {
			User user = this.userService.getUserById(id);
			if(user != null) {
				status = this.userService.checkOldPassword(changePassword.getPassword(), user.getPassword());
				if( status) {
					String password = this.userService.encodeNewPassword(changePassword.getNpassword());
					status = this.hqlDaoService.updatePassword(password, id);
					if( status) {
						return status;
					}
				}
			}
		}
		return status;
	}

}
