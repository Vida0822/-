package org.doit.ik.service;

import java.sql.SQLException;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberShipServiceImpl implements MemberShipService {

	@Autowired
	private NoticeMapper noticeDao;
	
	// [6] 전파방식 설명을 위해 수정된 메서드
	@Override
   // @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
   public void insertAndPointUpOfMember(NoticeVO notice, String id) throws ClassNotFoundException, SQLException {
	   
	   noticeDao.insert(notice);
	   
	   notice.setTitle(notice.getTitle() + "-2");
	   
	   noticeDao.insert(notice);
	   
   }
	
}
