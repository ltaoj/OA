package com.yunlg.oa.domain.wrapper;

import com.yunlg.oa.domain.model.Assessment;
import lombok.Data;

@Data
public class ViewAssessment {
    private Assessment assessment;
    private String name;
    private int department;
    private int position;
}
