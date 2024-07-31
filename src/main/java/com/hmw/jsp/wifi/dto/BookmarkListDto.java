package com.hmw.jsp.wifi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkListDto {
    private long id;
    private String register_dttm;
    private long info_id;
    private long group_id;
}
