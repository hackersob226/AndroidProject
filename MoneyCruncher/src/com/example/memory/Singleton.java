package com.example.memory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

import android.os.Environment;
import android.util.Log;

/**
 * @author Brandon, Trang, Chase, Katie, Devon
 *  
 */
public class Singleton {
    private static Singleton instance;
    private IList theList;
    private User temp;
    
    private Singleton() {
    	theList = new UserList();
    }

    /**
     * 
     * 
     * @return Singleton
     */
    public static synchronized Singleton getInstance() {
		if (instance == null) {
		    instance = new Singleton();
		}
	return instance;
    }

    /**
     * 
     * 
     * @return IList 
     */
    public IList getList() {
    	return theList;
    }

    /**
     * 
     * 
     * @param index 
     * @return User 
     */
    public User retrieveUser(int index) {
        return theList.getUser(index);
    }

    /**
     * 
     * 
     * @param username 
     * @return boolean 
     */
    public boolean verifyLogin(String username) {
        for (int i = 0; i < theList.getLength(); i++) {
            String name = retrieveUser(i).getName();
            if (username.equals(name)) {
            temp = retrieveUser(i);
            i = theList.getLength();
            } else if (!username.equals(name)
                && theList.getLength() == 1) {
            return true;
            } else if (i == theList.getLength() - 1) {
            return true;
            }
        }
        return false;
    }

    /**
     * 
     * 
     * @param password 
     * @return boolean 
     */
    public boolean verifyPass(String password) {
        if (!password.equals(temp.getPass())) {
            return true;
        }
        return false;
    }

    /**
     * 
     * 
     * @param username
     * @return boolean 
     */
    public boolean verifyRegister(String username) {
        for (int i = 0; i < theList.getLength(); i++) {
            String name = retrieveUser(i).getName();
            if (name.equals(username)){
            return true;
            }
        }
        return false;
    }

    /**
     * 
     * 
     * @param pass 
     */
    public void register(String user, String pass) {
        theList.add(new User(user, pass));
    }

    /**
     * 
     * 
     * @param username 
     * @return User 
     */
    public User findUser(String username) {
    	if (username != null) {
    		for (int n = 0; n < theList.getLength(); n++) {
                String name = retrieveUser(n).getName();
                if (username.equals(name)) {
                return retrieveUser(n);
                }
            }
    	}
        return null;
    }

    /**
     * 
     * 
     * @param user 
     * @param fullName 
     * @param displayName 
     * @param balance 
     * @param intereset 
     */
    public void createAccount(String user, String fullName, String displayName,
            String balance, String interest) {
        for (int i = 0; i < theList.getLength(); i++) {
            String name = retrieveUser(i).getName();
            if (name.equals(user)) {
            theList.getUser(i).addAccount(
                new Tab(fullName, displayName, Double
                    .parseDouble(balance), Double
                    .parseDouble(interest)));
                }
            }
    }

    /**
     * 
     * 
     * @return ArrayList<Tab> 
     */
    public ArrayList<Tab> retrieveAccList() {
        if(temp != null) {
        return temp.getAccList();
        }
        return null;
    }

    /**
     * 
     * 
     * @param index 
     * @return Tab 
     */
    public Tab retrieveTab(int index) {
        return retrieveAccList().get(index);
    }

    /**
     * 
     * 
     * @param name 
     * @return boolean 
     */
    public boolean checkDisplayName(String name) {
        for(int i = 0; i < retrieveAccList().size(); i++) {
            String displayName = retrieveTab(i).getDisplayName();
            if (displayName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * 
     * @param account
     * @return Tab 
     */
    public Tab getAccount(String account) {
        for (int i = 0; i < retrieveAccList().size(); i++) {
            String displayName = retrieveTab(i).getDisplayName();
            if (displayName.equals(account)) {
            return retrieveTab(i);
            }
        }
        return null;
    }

    /**
     * 
     * 
     * @param source 
     * @param y 
     * @param m 
     * @param d 
     * @param amount 
     * @param account 
     */
    public void deposit(String source, int y, int m, int d, String amount,
            Tab account) {
        double money = Double.parseDouble(amount);
        int accountLocation = 0, userLocation = 0;
        for (int n = 0; n < theList.getLength(); n++) {
            String name = retrieveUser(n).getName();
            if (name.equals(temp.getName())) {
            userLocation = n;
            }
        }
        for (int i = 0; i < retrieveAccList().size(); i++) {
            String displayName = retrieveTab(i).getDisplayName();
            if (displayName.equals(account)) {
            accountLocation = i;
            }
        }
        theList.getUser(userLocation).getAccList().get(accountLocation).update(new Deposit(source, y, m, d, money));
    }

    /**
     * 
     * 
     * @param reason 
     * @param category 
     * @param y 
     * @param m 
     * @param d 
     * @param amount 
     * @param account 
     */
    public void withdraw(String reason, String category, int y, int m, int d,
            String amount, Tab account) {
        double money = Double.parseDouble(amount);
        int accountLocation = 0, userLocation = 0;
        for (int n = 0; n < theList.getLength(); n++) {
            String name = retrieveUser(n).getName();
            if (name.equals(temp.getName())) {
            userLocation = n;
            }
        }
        for (int i = 0; i < retrieveAccList().size(); i++) {
            String displayName = retrieveTab(i).getDisplayName();
            if (displayName.equals(account)) {
            accountLocation = i;
            }
        }
        theList.getUser(userLocation).getAccList().get(accountLocation).update(new Withdrawal(reason, category, y, m, d, money));
    }

    /**
     * 
     */
    public void saveBinary() throws IOException {
        ObjectOutputStream oos = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "/data.bin");
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(theList);
            oos.flush();
        } catch (IOException e) {
            Log.e("APPLICATION FACADE", "Binary file input general error");
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }

    /**
     * 
     */
    public void loadBinary() throws IOException {
        ObjectInputStream oos = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "/data.bin");
            oos = new ObjectInputStream(new FileInputStream(file));
            theList = (UserList)oos.readObject();
        } catch (StreamCorruptedException e) {
            Log.e("APPLICATION FACADE", "Corrupted binary file");
        } catch (FileNotFoundException e) {
            Log.e("APPLICATION FACADE", "Binary File not found");
        } catch (IOException e) {
            Log.e("APPLICATION FACADE", "General IO Error");
        } catch (ClassNotFoundException e) {
            Log.e("APPLICATION FACADE", "Class not found");
        } finally {
            if (oos != null)
                oos.close();
        }
    }
}
