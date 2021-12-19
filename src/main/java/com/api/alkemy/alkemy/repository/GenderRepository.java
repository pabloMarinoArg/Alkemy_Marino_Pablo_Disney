package com.api.alkemy.alkemy.repository;

import com.api.alkemy.alkemy.entity.CharacterEntity;
import com.api.alkemy.alkemy.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<GenderEntity, Long> {
}
