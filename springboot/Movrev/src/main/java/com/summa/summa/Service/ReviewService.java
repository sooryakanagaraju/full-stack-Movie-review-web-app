package com.summa.summa.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.summa.summa.Entity.ReviewEntity;

@Service
public interface ReviewService {
	ReviewEntity createLeave(ReviewEntity leave);
	List<ReviewEntity> getAllrev();
	void deleteReview(Long revId);
	ReviewEntity updateRev(ReviewEntity review);
	
}
