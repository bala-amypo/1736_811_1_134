package com.example.demo.controller;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recovery")
public class RecoveryCurveController {

    private final RecoveryCurveService service;

    public RecoveryCurveController(RecoveryCurveService service) {
        this.service = service;
    }

    @PostMapping("/post")
    public RecoveryCurveProfile createCurve(@Valid @RequestBody RecoveryCurveProfile curve) {
        return service.createCurveEntry(curve);
    }

    @GetMapping("/get/{surgeryType}")
    public List<RecoveryCurveProfile> getBySurgery(@PathVariable String surgeryType) {
        return service.getCurveForSurgery(surgeryType);
    }

    @GetMapping("/get")
    public List<RecoveryCurveProfile> getAllCurves() {
        return service.getAllCurves();
    }
}
