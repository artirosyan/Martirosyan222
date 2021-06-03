package adportal.storage;

import adportal.adModel.User;

public interface UserStorage {

    void add(User user);

    User getByPhone(String phone);


}
