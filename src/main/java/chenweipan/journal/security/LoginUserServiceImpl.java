package chenweipan.journal.security;


import chenweipan.journal.po.JournalUser;
import chenweipan.journal.repository.JournalUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoginUserServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(LoginUserServiceImpl.class);

    @Autowired
    JournalUserRepository journalUserRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("username is :{}", username);
        JournalUser user = null;
        String status = null;
        try {
            user = journalUserRepository.findByUserName(username);
        } catch (Exception e) {
            logger.error("jdbc error:{}", e);
        }
        logger.info("user found username is :{},status is:{}", user.getUsername(), status);
        return user;
    }

}
