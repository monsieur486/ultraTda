package com.mr486.tda.dto;

import com.mr486.tda.model.GraphInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto {
    private Integer etape;
    private List<ScoreDto> scores;
    private GraphInfo graphInfo;
    private List<String> parties;
}
