package com.uptempo.ams.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.uptempo.ams.model.entity.Session;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SessionRepository extends EntityGraphJpaRepository<Session, UUID> {

}
