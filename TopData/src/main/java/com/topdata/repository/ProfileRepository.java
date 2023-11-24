package com.topdata.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.topdata.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // métodos do repositório
	
}