package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;
import java.util.List;

public interface RecoveryCurveService {

    List<RecoveryCurveProfile> getAllCurves();

    List<RecoveryCurveProfile> getBySurgeryType(String surgeryType);
}
