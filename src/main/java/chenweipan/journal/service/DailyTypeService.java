package chenweipan.journal.service;

import chenweipan.journal.po.DailyType;
import org.springframework.data.domain.*;

public interface DailyTypeService {

    public void createType(String typeName, String desc, Long operator);

    public Page<DailyType> queryTypeByPage(PageRequest pageInfo, Long operator);

    public DailyType findById(Long id);

    public void changeType(DailyType type, String name, String desc);

}
