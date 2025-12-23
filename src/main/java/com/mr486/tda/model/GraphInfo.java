package com.mr486.tda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GraphInfo {
    private List<Integer> labels;
    private List<DataSet> dataSets;
}
