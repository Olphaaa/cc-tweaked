package fr.iut.cctweaked.user.model;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String _id;
    private String inGameId;

    public UserDTO() {
    }
    

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getInGameId() {
        return inGameId;
    }

    public void setInGameId(String inGameId) {
        this.inGameId = inGameId;
    }
}
