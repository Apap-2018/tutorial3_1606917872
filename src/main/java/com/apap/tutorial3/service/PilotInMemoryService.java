package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tutorial3.model.PilotModel;

@Service
public class PilotInMemoryService implements PilotService {
	
	private List<PilotModel> archivePilot;
	
	public PilotInMemoryService() {
		archivePilot = new ArrayList<>();
	}
	
	public void addPilot(PilotModel pilot) {
		archivePilot.add(pilot);
	}
	
	public List<PilotModel> getPilotList(){
		return archivePilot;
	}
	
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		for (int i=0; i<archivePilot.size(); i++) {
			PilotModel temp = archivePilot.get(i);
			if(temp.getLicenseNumber().equals(licenseNumber)) {
				return temp;
			} 
		}
		return null;
	}
	
	public PilotModel updatePilotFlyHour(String licenseNumber, Integer updateNumber) {
		PilotModel temp = this.getPilotDetailByLicenseNumber(licenseNumber);
		temp.setFlyHour(updateNumber);
		return temp;
	}
	
	public PilotModel deletePilot(String id) {
		for (int i=0; i<archivePilot.size(); i++) {
			PilotModel temp = archivePilot.get(i);
			if(temp.getId().equals(id)) {
				archivePilot.remove(i);
				return temp;
			} 
		}
		return null;
	}
}
