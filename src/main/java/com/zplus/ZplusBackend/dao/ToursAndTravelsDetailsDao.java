package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.ToursAndTravelsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToursAndTravelsDetailsDao extends JpaRepository<ToursAndTravelsDetails,Integer> {
    List findAllByStatus(String active);

//    List<ToursAndTravelsDetails> findAllByToursAndTravelsMaster_ToursAndTraveId(Integer toursAndTraveId);

    @Query("Select td from ToursAndTravelsDetails as td where td.toursAndTravelsMaster.toursAndTraveId=:toursAndTraveId")
    List<ToursAndTravelsDetails> getByToursAndTraveId(@Param("toursAndTraveId") Integer toursAndTraveId);
}
