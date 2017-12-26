package chenweipan.journal.service.impl;

import chenweipan.journal.po.UserInfo;
import chenweipan.journal.repository.UserInfoRepository;
import chenweipan.journal.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserInfoImpl implements UserInfoService {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoImpl.class);

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public void saveUserInfo(UserInfo userInfo, Long typeId, Long userId) {
        logger.info("userInfo,{},typeId:{},userId:{}", userInfo, typeId, userId);
        userInfo.setDefaultType(typeId);
        userInfo.setUserId(userId);
        userInfoRepository.saveAndFlush(userInfo);
    }

    @Override
    public UserInfo getUserInfoByUser(Long user) {
        logger.info("userId:{}",user);
        return userInfoRepository.findByUserId(user);
    }
}
