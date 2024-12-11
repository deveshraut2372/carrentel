package com.zplus.ZplusBackend.dto.res;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class GallaryResponseDto {

    private Integer gallaryId;

    private String type;

    private String image;

    private String status;
}
