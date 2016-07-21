package gwt.material.errai.table.client.shared;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark Kevin on 7/21/2016.
 */
public class DataHelper {

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        for(int i = 1; i <= 10; i++) {
            users.add(new User("user" + i, "Admin" , "First Name " + i, "Last Name " + i));
        }

        return users;
    }

}
