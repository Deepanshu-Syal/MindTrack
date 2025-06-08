package com.deepanshu.MindTrack.Service;

import com.deepanshu.MindTrack.entity.JournalEntry;
import com.deepanshu.MindTrack.entity.User;
import com.deepanshu.MindTrack.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository jERepo;

    @Autowired
    private UserService usrService;

    @Transactional
    public void saveEntry(JournalEntry jEntry, String userName){
        try{
            jEntry.setDate(LocalDateTime.now());
            User usr = usrService.findByUserName(userName);
            JournalEntry savedEntry = jERepo.save(jEntry);
            usr.getJournalEntries().add(savedEntry);
            usrService.saveUser(usr);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occured while saving journal entry", e);
        }

    }
    public void saveEntry(JournalEntry jEntry){
        jEntry.setDate(LocalDateTime.now());
        jERepo.save(jEntry);
    }
    public List<JournalEntry> getAll() {
        return jERepo.findAll();
    }
    public Optional<JournalEntry> FindById(ObjectId id) {
        return jERepo.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName) {
        boolean removed = false;
        try{
            User usr = usrService.findByUserName(userName);
            removed = usr.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if(removed){
                usrService.saveUser(usr);
                jERepo.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occured while deleting journal entry", e);
        }
        return removed;
    }

}
