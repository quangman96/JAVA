package dao;

import model.Login;
import model.User;

import java.util.ArrayList;
import java.util.List;


    public class UserDao {
        private static List<User> users;
        static {
            users = new ArrayList<>();
            User u1 = new User();
            u1.setAge(10);
            u1.setName("John");
            u1.setAccount("1");
            u1.setEmail("john@codegym.vn");
            u1.setPassword("1");
            users.add(u1);

            User u2 = new User();
            u2.setAge(15);
            u2.setName("Bill");
            u2.setAccount("2");
            u2.setEmail("bill@codegym.vn");
            u2.setPassword("2");
            users.add(u2);

            User u3 = new User();
            u3.setAge(16);
            u3.setName("Mike");
            u3.setAccount("3");
            u2.setEmail("mike@codegym.vn");
            u3.setPassword("3");
            users.add(u3);
        }

        public static User checkLogin(Login login){
            for (User u: users) {
                if(u.getAccount().equals(login.getAccount())
                        && u.getPassword().equals(login.getPassword())){
                    return u;
                }
            }
            return null;
        }
}
