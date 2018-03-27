package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProfileRepository;
import com.example.models.Profile;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
	
	@Autowired
	ProfileRepository profileRepository;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Long createProfile(@RequestBody Profile profile) {
		Profile newProfile=  profileRepository.save(profile);
		return newProfile.getId();
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.FOUND)
	public List<Profile> getAllProfile() {
		List<Profile> profiles = new ArrayList<Profile>();
		for(Profile profile:profileRepository.findAll()){
			profiles.add(profile);
			
		}
		return profiles;
	}

	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Optional<Profile> getProfile(@PathVariable Long id){
		return profileRepository.findById(id);
	}

	@RequestMapping(method=RequestMethod.PATCH,value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public boolean updateProfile(@PathVariable Long id,@RequestBody Profile profile){
		 if(profileRepository.existsById(id)){
			 profileRepository.save(profile);
			 return true;// not checking is save pass or fails
		 }
		return false;
	}

}
