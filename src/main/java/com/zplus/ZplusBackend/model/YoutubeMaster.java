package com.zplus.ZplusBackend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class YoutubeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer youtubeId;

    private String status;

    private String youTubeLink;

}
