package fr.iut.cctweaked.user;

import org.bson.types.ObjectId;

import java.util.List;

public class UserMapper {

    public static User userDTOtoUser(UserDTO userDTO) {
        User user = new User();
        if (userDTO.get_id() != null) {
            user.set_id(new ObjectId(userDTO.get_id()));
        }
        user.setInGameId(userDTO.getInGameId());
        return user;
    }

    public static UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.set_id(user.get_id().toString());
        userDTO.setInGameId(user.getInGameId());
        return userDTO;
    }

    public static List<UserDTO> userListToUserDTOList(List<User> userList) {
        List<UserDTO> userDTOList = new java.util.ArrayList<>();
        for (User user : userList) {
            userDTOList.add(userToUserDTO(user));
        }
        return userDTOList;
    }
}
