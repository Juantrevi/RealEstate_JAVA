package com.project.realEstate.Repositories;

import com.project.realEstate.Entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {


    Property findPropertyByTitle(String title);
}
