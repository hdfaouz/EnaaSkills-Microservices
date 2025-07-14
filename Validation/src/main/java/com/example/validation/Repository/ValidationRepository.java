package com.example.validation.Repository;

import com.example.validation.Model.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<Validation,Long> {
}
