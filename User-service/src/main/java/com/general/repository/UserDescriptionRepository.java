package com.general.repository;

import com.general.entity.UserDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDescriptionRepository extends JpaRepository<UserDescription, Long> {
}
