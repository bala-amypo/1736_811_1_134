package com.example.demo.controller;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/symptom")
public class DailySymptomLogController {

    private final DailySymptomLogService service;

    public DailySymptomLogController(DailySymptomLogService service) {
        this.service = service;
    }

    @PostMapping("/post")
    public DailySymptomLog addLog(@Valid @RequestBody DailySymptomLog log) {
        return service.recordLog(log);
    }

    @GetMapping("/get/{id}")
    public DailySymptomLog getLog(@PathVariable Long id) {
        return service.getLogById(id);
    }

    @GetMapping("/patient/{id}")
    public List<DailySymptomLog> getLogsByPatient(@PathVariable Long id) {
        return service.getLogsByPatient(id);
    }
}
