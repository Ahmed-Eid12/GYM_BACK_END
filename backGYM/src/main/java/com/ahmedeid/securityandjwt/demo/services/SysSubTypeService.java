package com.ahmedeid.securityandjwt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.SysSubtype;
import com.ahmedeid.securityandjwt.demo.repository.SysSubTypeRepository;

@Service
public class SysSubTypeService {

	@Autowired
	private SysSubTypeRepository subTypeRepository;

	// get all SysSubtype of list ...
	public List<SysSubtype> getAll() {
		return this.subTypeRepository.findAll();
	}

	// get SysSubtype by id ...
	public SysSubtype getSysSubtypeById(int id) {
		return this.subTypeRepository.findById(id).get();
	}

	// save or update new SysSubtype ...
	public SysSubtype saveNewSysSubtype(SysSubtype sysSubtype) {
		return this.subTypeRepository.save(sysSubtype);
	}

	// delete SysSubtype By id ....
	public boolean deleteSysSubtypeById(int id) {
		boolean status = false;
		SysSubtype sysSubtype = getSysSubtypeById(id);
		if (sysSubtype != null) {
			this.subTypeRepository.delete(sysSubtype);
			status = true;
		}
		return status;
	}

}
