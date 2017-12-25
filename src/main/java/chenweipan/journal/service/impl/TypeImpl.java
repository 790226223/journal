package chenweipan.journal.service.impl;

import chenweipan.journal.po.DailyRecord;
import chenweipan.journal.po.DailyType;
import chenweipan.journal.po.UserInfo;
import chenweipan.journal.repository.DailyTypeRepository;
import chenweipan.journal.repository.UserInfoRepository;
import chenweipan.journal.service.DailyTypeService;
import chenweipan.journal.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;

@Service
@Transactional
public class TypeImpl implements DailyTypeService {

    private static final Logger logger = LoggerFactory.getLogger(TypeImpl.class);

    @Autowired
    DailyTypeRepository typeRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    UserInfoService userInfoService;

    @Override
    public void createType(String typeName, String desc, Long operator) {
        logger.info("name:{},desc:{}", typeName, desc);
        DailyType type = new DailyType();
        type.setTypeName(typeName);
        type.setDescript(desc);
        type.setUserId(operator);
        type = typeRepository.saveAndFlush(type);
        UserInfo userInfo = userInfoRepository.findByUserId(operator);
        createDefaultType(userInfo, type.getId(), operator);
    }

    public void createDefaultType(UserInfo userInfo, Long typeId, Long operatorId) {
        logger.info("userInfo:{},typeId:{},operator:{}", userInfo,typeId,operatorId);
        if (userInfo == null) {
            userInfoService.saveUserInfo(new UserInfo(), typeId, operatorId);
        }
    }

    @Override
    public Page<DailyType> queryTypeByPage(PageRequest pageInfo, Long operator) {
        logger.info("req:{}", pageInfo);
        Page<DailyType> pageResp = typeRepository.findByUserId(operator, pageInfo);
        logger.info("result:{}", pageResp);
        return pageResp;
    }

    @Override
    public DailyType findById(Long id) {
        logger.info("id:{}", id);
        return typeRepository.findOne(id);
    }

    @Override
    public void changeType(DailyType type, String name, String desc) {
        logger.info("type:{},name:{},desc:{}", type, name, desc);
        type.setTypeName(name);
        type.setDescript(desc);
        typeRepository.saveAndFlush(type);
    }
}
