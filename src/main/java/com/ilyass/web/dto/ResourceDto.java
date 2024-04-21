package com.ilyass.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResourceDto {

    private int resourceId;
    private String resourceName;
    private String description;
    private String type;
    private String link;
    private String accessibility;
    
}
