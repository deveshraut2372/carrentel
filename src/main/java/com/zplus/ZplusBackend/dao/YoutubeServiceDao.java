package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.YoutubeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface YoutubeServiceDao extends JpaRepository<YoutubeMaster,Integer> {

    List findAllByStatus(String status);
}
