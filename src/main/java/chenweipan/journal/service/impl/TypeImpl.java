package chenweipan.journal.service.impl;

import chenweipan.journal.po.DailyType;
import chenweipan.journal.repository.DailyTypeRepository;
import chenweipan.journal.service.DailyTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TypeImpl implements DailyTypeService {

    private static final Logger logger = LoggerFactory.getLogger(TypeImpl.class);

    @Autowired
    DailyTypeRepository typeRepository;

    @Override
    public void createType(String typeName, String desc) {
        DailyType type = new DailyType();
        type.setTypeName(typeName);
        type.setDescript(desc);
        typeRepository.saveAndFlush(type);
    }
}
