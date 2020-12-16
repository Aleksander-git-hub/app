package com.cascade.app.repository;

import com.cascade.app.entity.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeometryRepository extends JpaRepository<Geometry, Integer>
{

}
