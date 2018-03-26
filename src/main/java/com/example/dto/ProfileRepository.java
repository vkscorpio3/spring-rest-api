/**
 * 
 */
package com.example.dto;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Profile;

/**
 * @author neeravshah
 *
 */
public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
