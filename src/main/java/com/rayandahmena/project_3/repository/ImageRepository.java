package com.rayandahmena.project_3.repository;

import com.rayandahmena.project_3.entity.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer> {}
