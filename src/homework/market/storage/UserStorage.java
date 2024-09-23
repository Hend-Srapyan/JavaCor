package homework.market.storage;

import homework.market.model.user.User;

public class UserStorage {
    private User[] users = new User[10];
    private int size;

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(users[i]);
        }
    }

    public void add(User user){
        if (size == users.length){
            extend();
        }
        users[++size] = user;
    }

    private void extend() {
        User[] tmp = new User[size + 10];
        System.arraycopy(users,0,tmp,0, size);
        users = tmp;
    }

    public User loginUser(String login, String password){
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(login) && users[i].getPassword().equals(password)){
                return users[i];
            }
        }
        return null;
    }

    public boolean getUserByEmail(String email){
        for (int i = 0; i <= size; i++) {
            if (users[i].getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
}
