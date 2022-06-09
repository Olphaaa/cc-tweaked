package fr.iut.cctweaked.user;

import fr.iut.cctweaked.user.model.User;
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

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User updateUser(User user) throws NoSuchElementException {
        User existingUser = userRepository.findById(user.get_id()).orElseThrow();
        return userRepository.save(existingUser.update(user));
//        return userRepository.save(existingUser.update(user));
    }

    public User getById(ObjectId id) throws NoSuchElementException {
        return userRepository.findById(id).orElseThrow();
    }

}