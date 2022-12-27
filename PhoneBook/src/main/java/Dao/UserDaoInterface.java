package Dao;

import java.util.ArrayList;

import Model.User;

public interface UserDaoInterface {
	public User loginUser(String userEmail,String password);
	public boolean signUp(User user);
    public boolean deleteUser(int userID);
    public User searchUser(int id);
    public ArrayList<User> listUser();
    public boolean updateUser(User user);
}
