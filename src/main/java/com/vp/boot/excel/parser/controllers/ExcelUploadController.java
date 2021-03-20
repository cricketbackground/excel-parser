package com.vp.boot.excel.parser.controllers;

import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.vp.boot.excel.parser.model.Student;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api")
public class ExcelUploadController {

    @PostMapping(path = "upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> upload(@RequestParam("file") MultipartFile file) {

        try {
            List<Student> employees = Poiji.fromExcel(file.getInputStream(), PoijiExcelType.XLSX,
                    Student.class);
            return ResponseEntity.ok(employees);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ArrayList<>());
        }
    }

}
