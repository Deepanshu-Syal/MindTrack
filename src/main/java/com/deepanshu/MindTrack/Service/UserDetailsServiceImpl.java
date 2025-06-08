package com.deepanshu.MindTrack.Service;

import com.deepanshu.MindTrack.entity.User;
import com.deepanshu.MindTrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository usrRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usr = usrRepository.findByUserName(username);
        if( usr != null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(usr.getUserName())
                    .password(usr.getPassword())
                    .roles(usr.getRoles().toArray(new String[0]))
                    .build();
        }
        throw new UsernameNotFoundException("User not found with username:" + username);
    }
}
