package com.zplus.ZplusBackend.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YoutubeMasterReq {
    private Integer youtubeId;

    private String status;

    private String youtubeLink;
}
