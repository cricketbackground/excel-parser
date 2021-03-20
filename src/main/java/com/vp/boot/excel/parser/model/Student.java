package com.vp.boot.excel.parser.model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;
import lombok.Data;

@ExcelSheet(value = "Sheet1")
@Data
public class Student {

    @ExcelCellName("EMAIL")
    private String email;

    @ExcelCellName("AGE")
    private Integer age;

    @ExcelCellName("ID")
    private Long id;

    @ExcelCellName("NAME")
    private String name;

}
