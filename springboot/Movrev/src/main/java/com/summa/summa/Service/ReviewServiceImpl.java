package com.summa.summa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summa.summa.Entity.ReviewEntity;
import com.summa.summa.Repo.ReviewRepo;

@Service
public class ReviewServiceImpl implements ReviewService {

	
	@Autowired
	ReviewRepo reviewrepo;
	
	@Override
	public ReviewEntity createLeave(ReviewEntity rev) {
		// TODO Auto-generated method stub
		 return reviewrepo.save(rev);
	}

	@Override
	public List<ReviewEntity> getAllrev() {
		// TODO Auto-generated method stub
		return (List<ReviewEntity>) reviewrepo.findAll();
	}

	@Override
	public void deleteReview(Long revId) {
		// TODO Auto-generated method stub
		reviewrepo.deleteById(revId);
		
	}

	@Override
	public ReviewEntity updateRev(ReviewEntity review) {
		// TODO Auto-generated method stub
		ReviewEntity existingreview = reviewrepo.findById(review.getRevId()).get();
		existingreview.setName(review.getName());
		existingreview.setEmail(review.getEmail());
		existingreview.setMessage(review.getMessage());
		existingreview.setProduct(review.getProduct());
//		existingresident.setResidentContactno(resident.getResidentContactno());
//		existingresident.setResidentEmail(resident.getResidentEmail());
		
		return reviewrepo.save(existingreview);
	}

}
