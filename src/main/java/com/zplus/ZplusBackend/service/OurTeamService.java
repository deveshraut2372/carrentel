package com.zplus.ZplusBackend.service;


import com.zplus.ZplusBackend.dto.req.OurTeamRequestDto;
import com.zplus.ZplusBackend.model.OurTeamMaster;

import java.util.List;

public interface OurTeamService {

    public Boolean create(OurTeamRequestDto ourTeamRequestDto);

    public Boolean update(OurTeamRequestDto ourTeamRequestDto);

    public Boolean delete(Integer teamId);

    public OurTeamMaster findById(Integer teamId);

    public List getAllTeam();

    public List getAllByStatus();
}
