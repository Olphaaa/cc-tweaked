package fr.iut.cctweaked.user;

import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public HttpResponse<List<User>> getAll() {
        return null;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}