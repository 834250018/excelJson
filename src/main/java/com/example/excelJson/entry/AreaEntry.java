package com.example.excelJson.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author ve
 * @date 2019/7/30 14:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@Document
public class AreaEntry implements Serializable {

    @Id
    private String id;
    private String parentId;
    private String name;

}
