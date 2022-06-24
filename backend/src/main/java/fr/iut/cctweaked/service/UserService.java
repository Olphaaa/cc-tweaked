package fr.iut.cctweaked.service;

import fr.iut.cctweaked.domain.User;
import fr.iut.cctweaked.dto.UserSitesExpandedDTO;
import fr.iut.cctweaked.dto.UserSitesDTO;
import fr.iut.cctweaked.repository.SiteRepository;
import fr.iut.cctweaked.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private SiteRepository siteRepository;

    public UserService(UserRepository userRepository, SiteRepository siteRepository) {
        this.userRepository = userRepository;
        this.siteRepository = siteRepository;
    }

    /**
     * Get all users
     *
     * @return List of users
     */
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * Add a user
     *
     * @param user User to add
     * @return Added user
     */
    public User addUser(User user) {
        return userRepository.save(user);
    }


    /**
     * Delete a user
     *
     * @param id User id
     */
    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }

    /**
     * Edit a user
     *
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
     *
     * @param id User id
     * @throws NoSuchElementException if user not found
     */
    public User getById(String id) throws NoSuchElementException {
        return userRepository.findById(id).orElseThrow();
    }

    public List<UserSitesExpandedDTO> getUserSitesExpanded(String id) {
        try {
            List<UserSitesExpandedDTO> userSitesExpandedDTOS = new ArrayList<>();
//            List<UserSitesExpandedDTO> userSitesExpandedDTOS = siteRepository.findSuppliersAndStorages(id).getMappedResults();
            return userSitesExpandedDTOS;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object> getUsersSites(String id) {
        try {
            List<Object> userSitesDTOS = siteRepository.findUsersSites(id).getMappedResults();
            return userSitesDTOS;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}