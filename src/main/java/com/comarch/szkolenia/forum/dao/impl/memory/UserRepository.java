package com.comarch.szkolenia.forum.dao.impl.memory;

import com.comarch.szkolenia.forum.dao.IUserDAO;
import com.comarch.szkolenia.forum.model.User;
import com.comarch.szkolenia.forum.services.IIdSequence;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserDAO {
    private final List<User> users = new ArrayList<>();
    private final IIdSequence idSequence;

    public UserRepository(IIdSequence idSequence) {
        this.idSequence = idSequence;
        this.users.add(new User(1, "admin", "21232f297a57a5a743894a0e4a801fc3",
                "Pan", "Admin", User.Role.ADMIN, false));

        this.users.add(new User(2, "janusz", "1e6f2ac43951a6721d3d26a379cc7f8b",
                "Janusz", "Kowalski", User.Role.USER, false));
    }

    @Override
    public void persist(User user) {
        if(user.getId() == 0) {
            user.setId(this.idSequence.getNextId());
            this.users.add(user);
        } else {
            for(int i=0; i<this.users.size(); i++) {
                if(this.users.get(i).getId() == user.getId()) {
                    this.users.set(i, user);
                    return;
                }
            }
        }
    }

    @Override
    public Optional<User> getById(int id) {
        for (User user : this.users) {
            if(user.getId() == id) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> getByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }
}
