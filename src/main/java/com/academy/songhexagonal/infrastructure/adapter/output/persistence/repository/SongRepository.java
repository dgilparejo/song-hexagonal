package com.academy.songhexagonal.infrastructure.adapter.output.persistence.repository;

import com.academy.songhexagonal.infrastructure.adapter.output.persistence.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<SongEntity, Long> {
}
