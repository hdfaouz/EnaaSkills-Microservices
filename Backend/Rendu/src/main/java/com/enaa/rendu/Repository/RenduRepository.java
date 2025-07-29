package com.enaa.rendu.Repository;

import com.enaa.rendu.Model.Rendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface RenduRepository extends JpaRepository<Rendu,Long> {
    @Query(value = "select  id from rendu where id_breif = ? " , nativeQuery = true)
    List<Long> findIds(Long idbrief);

    @Query(value = "select distinct id_breif from rendu where date_depot between ? and ?", nativeQuery = true)
    List<Long> findRenduByIdBreifs(Date date1, Date date2);
}
