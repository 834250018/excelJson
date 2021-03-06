package com.example.excelJson.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

/**
 * @author ve
 * @date 2019/7/30 15:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class CountyVO implements Serializable {
    private String name;
}
