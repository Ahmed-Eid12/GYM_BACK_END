package com.ahmedeid.securityandjwt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.SysExerciseType;
import com.ahmedeid.securityandjwt.demo.repository.SysExerciseTypeRepository;

@Service
public class SysExerciseTypeService {

	@Autowired
	private SysExerciseTypeRepository sysExerciseTypeRepository;

	// get all SysExerciseType of list ...
	public List<SysExerciseType> getAll() {
		return this.sysExerciseTypeRepository.findAll();
	}

	// get SysExerciseType by id ...
	public SysExerciseType getSysExerciseTypeById(int id) {
		return this.sysExerciseTypeRepository.findById(id).get();
	}

	// save or update new SysExerciseType ...
	public SysExerciseType saveNewSysExerciseType(SysExerciseType sysExerciseType) {
		return this.sysExerciseTypeRepository.save(sysExerciseType);
	}

	// delete SysExerciseType By id ....
	public boolean deleteSysExerciseTypeById(int id) {
		boolean status = false;
		SysExerciseType sysExerciseType = getSysExerciseTypeById(id);
		if (sysExerciseType != null) {
			this.sysExerciseTypeRepository.delete(sysExerciseType);
			status = true;
		}
		return status;
	}

}
