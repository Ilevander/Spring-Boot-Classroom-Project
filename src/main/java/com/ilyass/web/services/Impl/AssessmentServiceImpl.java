package com.ilyass.web.services.Impl;

import java.util.List;

import com.ilyass.web.dto.AssessmentDto;
import com.ilyass.web.services.AssessmentService;
import com.ilyass.web.repositories.AssessmentRepository;


public class AssessmentServiceImpl implements AssessmentService {

	private AssessmentRepository AssessmentRepository;
	
	
	@Override
	public List<AssessmentDto> findAllAssessments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssessmentDto findAssessmentById(int assessmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssessmentDto> findAssessmentsByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssessmentDto> findAssessmentsByDuration(int duration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAssessment(int assessmentId) {
		// TODO Auto-generated method stub
		
	}

}
