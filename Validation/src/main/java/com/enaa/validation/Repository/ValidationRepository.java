package com.enaa.validation.Repository;

import com.enaa.validation.Model.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<Validation,Long > {
}
