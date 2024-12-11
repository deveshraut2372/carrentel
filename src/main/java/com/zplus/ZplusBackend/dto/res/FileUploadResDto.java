package com.zplus.ZplusBackend.dto.res;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class FileUploadResDto {

    public String path;

    public Boolean status;
}
