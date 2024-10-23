package com.arunesh.DataReader.Controller;

import com.arunesh.DataReader.Model.JSONdata;
import com.arunesh.DataReader.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("data")
public class FileController {
    @Autowired
    FileService fileService;

    @GetMapping("get")
    public ResponseEntity<List<JSONdata>> getAllData(){
        return fileService.getAllData();
    }
    @GetMapping("get/{id}")
    public ResponseEntity<Optional<JSONdata>> getData(@PathVariable String id){
        return fileService.getData(id);
    }
    @PostMapping("add")
    public ResponseEntity<String> save(@RequestBody List<JSONdata> data){
        return fileService.save(data);
    }
}
