package com.ahmedeid.securityandjwt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedeid.securityandjwt.demo.entities.SysExerciseType;
import com.ahmedeid.securityandjwt.demo.services.SysExerciseTypeService;

@CrossOrigin
@RestController
@RequestMapping(value= "/adminServiceIntegration")
public class AdminServiceIntegration {
	
	@Autowired
	private SysExerciseTypeService sysExerciseTypeService;
	
	@GetMapping(value = "/getSysExerciseTypeList")
	public List<SysExerciseType> getSysExerciseTypeList() {
		return this.sysExerciseTypeService.getAll();
	}

}
