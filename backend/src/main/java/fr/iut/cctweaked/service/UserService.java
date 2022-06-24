package fr.iut.cctweaked.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.iut.cctweaked.domain.User;
import fr.iut.cctweaked.dto.UserSitesDTO;
import fr.iut.cctweaked.dto.UsersSuppliersAndStorages;
import fr.iut.cctweaked.repository.SiteRepository;
import fr.iut.cctweaked.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final SiteRepository siteRepository;

    public UserService(UserRepository userRepository, SiteRepository siteRepository) {
        this.userRepository = userRepository;
        this.siteRepository = siteRepository;
    }

    /**
     * Get all users
     * @return List of users
     */
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * Add a user
     * @param user User to add
     * @return Added user
     */
    public User addUser(User user) {
        return userRepository.save(user);
    }


    /**
     * Delete a user
     * @param id User id
     */
    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
     }

    /**
     * Edit a user
     * @param user User to edit
     * @return Edited user
     * @throws NoSuchElementException if user not found
     */
    public User updateUser(User user) throws NoSuchElementException {
        User existingUser = userRepository.findById(user.get_id()).orElseThrow();
        existingUser.setUsername(user.getUsername());
        return userRepository.save(existingUser);
    }

    /**
     * Get a user by id
     * @param id User id
     * @throws NoSuchElementException if user not found
     */
    public User getById(String id) throws NoSuchElementException {
        return userRepository.findById(id).orElseThrow();
    }

    /**
     * Get a user Id and his sites
     * @param id User username Id
     * @throws NoSuchElementException if user not found
     * @return UserSitesDTO
     */
    public List<UsersSuppliersAndStorages> getUsersSitesExpanded(String id) {
        try {
            var usersSuppliersAndStorages = userRepository.findSuppliersAndStorages(id).getMappedResults();
            System.out.println(usersSuppliersAndStorages);
            return null;
//            return usersSuppliersAndStorages;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get a user Id and his sites
     * @param id User username Id
     * @throws NoSuchElementException if user not found
     * @return UserSitesDTO
     */
    public List<UserSitesDTO> getUsersSites(String id) {
        try {
            var usersSites = siteRepository.findUsersSites(id).getMappedResults();
            ObjectMapper objectMapper = new ObjectMapper();

            String carAsString = objectMapper.writeValueAsString(usersSites);

            System.out.println(carAsString);
            return null;
//            return usersSites;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}