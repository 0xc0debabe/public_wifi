package com.hmw.jsp.wifi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryDto {
    private long id;
    private String lat;
    private String lnt;
    private String search_dttm;
}
