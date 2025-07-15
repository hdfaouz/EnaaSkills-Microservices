package com.enaa.rendu.Repository;

import com.enaa.rendu.Model.Rendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RenduRepository extends JpaRepository<Rendu,Long> {
//    List<Rendu> findByIdApprenant(Long idApprenant);
//    List<Rendu> findByIdBrief(Long idBrief);
    @Query(value = "select  id from rendu where id_brief = ? " , nativeQuery = true)
    List<Long> findIds(Long idbrief);
}
