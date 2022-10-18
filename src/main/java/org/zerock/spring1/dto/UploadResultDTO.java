package org.zerock.spring1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadResultDTO {

    private String uuid, fileName;

    private boolean image;

    public String getFullName(){
        return uuid + "_" + fileName;
    }

}
