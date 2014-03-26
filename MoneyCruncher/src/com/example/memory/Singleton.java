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
 * @author
 *
 */
public class Singleton {
    /**
     * 
     */
    private static Singleton instance;
    /**
     * 
     */
    private IList theList;

    private User temp;

    /**
     * 
     */
    private Singleton() {
	theList = new UserList();
    }

    /**
     * @return Singleton
     */
    public static synchronized Singleton getInstance() {
	if (instance == null) {
	    instance = new Singleton();
	}
	return instance;
    }

    /**
     * @return IList
     */
    public IList getList() {
	return theList;
    }

    public boolean verifyLogin(String mEmail) {
        for (int i = 0; i < theList.getLength(); i++) {
            if (mEmail.equals(theList.getUser(i).getName())) {
            temp = theList.getUser(i);
            i = theList.getLength();
            } else if (!mEmail.equals(theList.getUser(i).getName())
                && theList.getLength() == 1) {
            return true;
            } else if (i == theList.getLength() - 1) {
            return true;
            }
        }
        return false;
    }

    public boolean verifyPass(String mPassword) {
        if (!mPassword.equals(temp.getPass())) {
            return true;
        }
        return false;
    }

    public boolean verifyRegister(String mEmail) {
        for (int i = 0; i < theList.getLength(); i++) {
            if (theList.getUser(i).getName().equals(mEmail)) {
            return true;
            }
        }
        return false;
    }

    public void register(String user, String pass) {
        theList.add(new User(user, pass));
    }

    public User findUser(String username) {
        for (int n = 0; n < theList.getLength(); n++) {
            if (username.equals(theList.getUser(n).getName())) {
            return theList.getUser(n);
            }
        }
        return null;
    }

    public void createAccount(String user, String fullName, String displayName,
            String balance, String interest) {
        for (int i = 0; i < theList.getLength(); i++) {
            if (theList.getUser(i).getName().equals(user)) {
            theList.getUser(i).addAccount(
                new Tab(fullName, displayName, Double
                    .parseDouble(balance), Double
                    .parseDouble(interest)));
                }
            }
    }

    public boolean checkDisplayName(String name) {
        for(int i = 0; i < temp.getAccList().size(); i++) {
            if (temp.getAccList().get(i).getDisplayName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Tab getAccount(String username, String account) {
        ArrayList<Tab> tempAccList = new ArrayList<Tab>();
        for (int n = 0; n < theList.getLength(); n++) {
            if (theList.getUser(n).getName().equals(username)) {
            tempAccList = theList.getUser(n).getAccList();
            }
        }
        for (int i = 0; i < tempAccList.size(); i++) {
            if (tempAccList.get(i).getDisplayName().equals(account)) {
            return tempAccList.get(i);
            }
        }
        return null;
    }

    public void deposit(String name, int y, int m, int d, String amount,
            Tab account) {
        double money = Double.parseDouble(amount);
        int accountLocation = 0, userLocation = 0;
        ArrayList<Tab> tempAccList = new ArrayList<Tab>();
        for (int n = 0; n < theList.getLength(); n++) {
            if (theList.getUser(n).getName().equals(temp.getName())) {
            tempAccList = theList.getUser(n).getAccList();
            userLocation = n;
            }
        }
        for (int i = 0; i < tempAccList.size(); i++) {
            if (tempAccList.get(i).getDisplayName().equals(account)) {
            accountLocation = i;
            }
        }
        theList.getUser(userLocation).getAccList().get(accountLocation).update(new Deposit(name, y, m, d, money));
    }

    public void withdraw(String name, String category, int y, int m, int d,
            String amount, Tab account) {
        double money = Double.parseDouble(amount);
        int accountLocation = 0, userLocation = 0;
        ArrayList<Tab> tempAccList = new ArrayList<Tab>();
        for (int n = 0; n < theList.getLength(); n++) {
            if (theList.getUser(n).getName().equals(temp.getName())) {
            tempAccList = theList.getUser(n).getAccList();
            userLocation = n;
            }
        }
        for (int i = 0; i < tempAccList.size(); i++) {
            if (tempAccList.get(i).getDisplayName().equals(account)) {
            accountLocation = i;
            }
        }
        theList.getUser(userLocation).getAccList().get(accountLocation).update(new Withdrawal(name, category, y, m, d, money));
    }

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
