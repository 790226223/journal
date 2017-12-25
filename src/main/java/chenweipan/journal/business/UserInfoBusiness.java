package chenweipan.journal.business;

import chenweipan.journal.po.DailyType;
import chenweipan.journal.po.UserInfo;
import chenweipan.journal.service.DailyTypeService;
import chenweipan.journal.service.UserInfoService;
import chenweipan.journal.web.response.type.TypePageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoBusiness {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoBusiness.class);

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    DailyTypeService dailyTypeService;

    public void setDefaultType(Long typeId, Long operator) {
        logger.info("typeId:{},operator:{}", typeId, operator);
        UserInfo userInfo = userInfoService.getUserInfoByUser(operator);
        if (userInfo == null) {
            userInfo = new UserInfo();
        }
        userInfoService.saveUserInfo(userInfo, typeId, operator);
    }

    public TypePageInfo getDefaultType(Long operator){
        UserInfo userInfo = userInfoService.getUserInfoByUser(operator);
        TypePageInfo info = null;
        if(userInfo!=null){
            info = new TypePageInfo();
            DailyType type = dailyTypeService.findById(userInfo.getDefaultType());
            info.setId(userInfo.getDefaultType());
            info.setTypeName(type.getTypeName());
            info.setDesc(type.getDescript());
        }
        return  info;
    }
}
