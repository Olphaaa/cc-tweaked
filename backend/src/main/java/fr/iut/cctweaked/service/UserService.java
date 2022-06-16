package fr.iut.cctweaked.service;

import fr.iut.cctweaked.domain.User;
import fr.iut.cctweaked.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
     }

    public User updateUser(User user) throws NoSuchElementException {
        User existingUser = userRepository.findById(user.get_id()).orElseThrow();
        existingUser.setUsername(user.getUsername());
        return userRepository.save(existingUser);
    }

    public User getById(String id) throws NoSuchElementException {
        return userRepository.findById(id).orElseThrow();
    }

}