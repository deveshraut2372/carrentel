package com.zplus.ZplusBackend.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MainResDto {

    private String message;
    private Boolean flag;
    private Integer responseCode;

}
