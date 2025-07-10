package com.enaa.apprenant.Repositories;

import com.enaa.apprenant.Model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenantRepository extends JpaRepository<Apprenant,Long> {

    List<Rendu> findByIdApprenant(Long idApprenant);
    List<Rendu> findByIdBrief(Long idBrief);
}
