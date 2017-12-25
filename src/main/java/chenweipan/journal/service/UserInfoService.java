package chenweipan.journal.service;

import chenweipan.journal.po.UserInfo;

public interface UserInfoService {
    public void saveUserInfo(UserInfo userInfo, Long typeId, Long userId);

    public UserInfo getUserInfoByUser(Long user);
}
