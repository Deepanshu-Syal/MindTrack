package com.deepanshu.MindTrack.Service;

import com.deepanshu.MindTrack.entity.User;
import com.deepanshu.MindTrack.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepo;

    private static final PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();

    public void saveNewUser(User usr){
        usr.setPassword(pwdEncoder.encode(usr.getPassword()));
        usr.setRoles(Arrays.asList("USER"));
        userRepo.save(usr);
    }
    public void saveAdmin(User usr){
        usr.setPassword(pwdEncoder.encode(usr.getPassword()));
        usr.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepo.save(usr);
    }
    public void saveUser(User usr) {
        userRepo.save(usr);
    }
    public List<User> getAll() {
        return userRepo.findAll();
    }
    public Optional<User> FindById(ObjectId id) {
        return userRepo.findById(id);
    }
    public void deleteById(ObjectId id) {
        userRepo.deleteById(id);
    }
    public void deleteByUserName(String usrName) {
        userRepo.deleteByUserName(usrName);
    }
    public User findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }
}
