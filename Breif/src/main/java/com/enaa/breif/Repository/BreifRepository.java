package com.enaa.breif.Repository;

import com.enaa.breif.Model.Breif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BreifRepository extends JpaRepository<Breif,Long> {

}
