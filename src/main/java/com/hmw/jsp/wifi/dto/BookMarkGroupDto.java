package com.hmw.jsp.wifi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookMarkGroupDto {
    private long id;
    private String name;
    private String order;
    private String register_dttm;
    private String update_dttm;
}
