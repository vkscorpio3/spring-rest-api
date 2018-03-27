/**
 * 
 */
package com.example.models;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author neeravshah
 *
 */
public class ProfileResource extends ResourceSupport {
	
	private Profile profile;

	public ProfileResource(Profile profile) {
		this.profile = profile;
	}
	
    @JsonProperty("id")
	public long getProfileId(){
		return profile.getId();
	}

    public String getFirstName(){
    	return profile.getFirstName();
    }
    public String getLastName(){
    	return profile.getLastName();
    }
}
