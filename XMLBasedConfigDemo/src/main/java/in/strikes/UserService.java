package in.strikes;

import java.util.List;

public class UserService {
//    private List<String> usernames;
//
//    public UserService(List<String> usernames) {
//        this.usernames = usernames;
//    }
//
//    public List<String> getUsernames() {
//        return usernames;
//    }


    public UserService() {
        System.out.println("User service created");
    }

    public void init(){
        System.out.println("Post construct called");
    }

    public void cleanup(){
        System.out.println("Pre destroy called");
    }
}
