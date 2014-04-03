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
    /**
     *
     */
    private static Singleton instance;
    /**
    *
    */
    private IList theList;
    /**
    *
    */
    private User temp;
    /**
     *
     */
    private static final String FILE_NAME = "/data.bin";
    /**
     *
     */
    private static final String ERROR = "APPLICATION FACADE";
    /**
    * Constructor for Singleton. Creates a UserList.
    */
    private Singleton() {
    	theList = new UserList();
    }

    /**
     * Returns the static instance of Singleton.
     * 
     * @return Singleton The static instance of this class
     */
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
	return instance;
    }

    /**
     * Returns the user list.
     * 
     * @return IList The user list 
     */
    public IList getList() {
    	return theList;
    }

    /**
     * Returns the specified user from the User list.
     * 
     * @param index User number
     * @return User The requested User
     */
    public User retrieveUser(int index) {
        return theList.getUser(index);
    }

    /**
     * Checks if the username isn't already taken in the user list.
     * 
     * @param username Name of the User in question 
     * @return boolean Returns true if username isn't in user list, returns false otherwise
     */
    public boolean verifyLogin(String username) {
        for (int i = 0; i < theList.getLength(); i++) {
            String name = retrieveUser(i).getName();
            if (username.equals(name)) {
                temp = retrieveUser(i);
                break;
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
     * Checks if the password is correct.
     * 
     * @param password The inputted password
     * @return boolean Returns true if password is correct, false otherwise
     */
    public boolean verifyPass(String password) {
        if (!password.equals(temp.getPass())) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the User list contains the given username.
     * 
     * @param username The username in question
     * @return boolean Returns ture if there is a registered user
     *  with the given username, returns false otherwise
     */
    public boolean verifyRegister(String username) {
        for (int i = 0; i < theList.getLength(); i++) {
            String name = retrieveUser(i).getName();
            if (name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a new user to the user list with the given name and password.
     * 
     * @param user The new user's name
     * @param pass The new user's password
     */
    public void register(String user, String pass) {
        theList.add(new User(user, pass));
    }

    /**
     * Returns the User with the given name.
     * 
     * @param username The name of the user in question
     * @return User The user with the given username
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
     * Returns a number in String form to double.
     *
     * @param number The number in String form
     * @return       The number in Double form
     */
    public double stringDouble(String number) {
        return Double.parseDouble(number);
    }

    /**
     * Creates a new account for the given user with the given attributes.
     * 
     * @param user The user whom the account is owned by
     * @param fullName The full name of the account
     * @param displayName The display name of the account
     * @param balance The balance of the account
     * @param interest The monthly interest rate of the account
     */
    public void createAccount(String user, String fullName, String displayName,
            String balance, String interest) {
        for (int i = 0; i < theList.getLength(); i++) {
            String name = retrieveUser(i).getName();
            if (name.equals(user)) {
                theList.getUser(i).addAccount(
                        new Tab(fullName, displayName, stringDouble(balance),
                                stringDouble(interest)));
            }
        }
    }

    /**
     * Returns the account list of the current user.
     * 
     * @return ArrayList<Tab> The account list of the current user
     */
    public ArrayList<Tab> retrieveAccList() {
        if (temp != null) {
            return temp.getAccList();
        }
        return null;
    }

    /**
     * Returns the account at the given index.
     * 
     * @param index The index of the account in question
     * @return Tab The account at the given index
     */
    public Tab retrieveTab(int index) {
        return retrieveAccList().get(index);
    }

    /**
     * Checks if the current use has an account with the given display name.
     * 
     * @param name The display name to check for
     * @return boolean Returns true if the current use does have
     *  an account of the given name, otherwise false
     */
    public boolean checkDisplayName(String name) {
        for (int i = 0; i < retrieveAccList().size(); i++) {
            String displayName = retrieveTab(i).getDisplayName();
            if (displayName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the account with the given display.
     * 
     * @param account The display name of the account in question 
     * @return Tab The account with the given display name
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
     * Returns the index of the current User.
     *
     * @return The index of the current User.
     */
    public int getUserLocation() {
        int userLocation = 0;
        for (int n = 0; n < theList.getLength(); n++) {
            String name = retrieveUser(n).getName();
            if (name.equals(temp.getName())) {
                userLocation = n;
            }
        }
        return userLocation;
    }

    /**
     * Returns the index of the account.
     *
     * @param account account in need of searching.
     * @return        The index of the account.
     */
    public int getAccountLocation(Tab account) {
        int accountLocation = 0;
        for (int i = 0; i < retrieveAccList().size(); i++) {
            String displayName = retrieveTab(i).getDisplayName();
            if (displayName.equals(account)) {
                accountLocation = i;
            }
        }
        return accountLocation;
    }

    /**
     * Updates the given account with a deposit of the given parameters.
     * 
     * @param source The name of the deposit
     * @param y Year of the deposit
     * @param m Month of the deposit
     * @param d Day of the deposit
     * @param value Amount of the deposit
     * @param account The account which is being deposited to 
     */
    public void deposit(String source, int y, int m, int d, String value,
            Tab account) {
        double money = stringDouble(value);
        int accountLocation = getAccountLocation(account);
        int userLocation = getUserLocation();
        theList.getUser(userLocation).getAccList().get(accountLocation).update(new Deposit(source, y, m, d, money));
    }

    /**
     * Updates the given account with a withdrawal of the given parameters.
     * 
     * @param reason The name of the withdrawal
     * @param category The category of the withdrawal
     * @param y The year of the withdrawal
     * @param m The month of the withdrawal
     * @param d The day of the withdrawal
     * @param amount The amount of the withdrawal
     * @param account The account which is being deposited to
     */
    public void withdraw(String reason, String category, int y, int m, int d,
            String amount, Tab account) {
        double money = stringDouble(amount);
        int accountLocation = getAccountLocation(account);
        int userLocation = getUserLocation();
        theList.getUser(userLocation).getAccList().get(accountLocation).update(new Withdrawal(reason, category, y, m, d, money));
    }

    /**
     * Saves the user list as a binary file to storage.
     *
     * @throws IOException The file cannot be saved
     */
    public void saveBinary() throws IOException {
        ObjectOutputStream oos = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory(), FILE_NAME);
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(theList);
            oos.flush();
        } catch (IOException e) {
            Log.e(ERROR, "Binary file input general error");
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }

    /**
     * Loads a binary file of the user list into memory.
     *
     * @throws IOException The file cannot be uploaded.
     */
    public void loadBinary() throws IOException {
        ObjectInputStream oos = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory(), FILE_NAME);
            oos = new ObjectInputStream(new FileInputStream(file));
            theList = (UserList) oos.readObject();
        } catch (StreamCorruptedException e) {
            Log.e(ERROR, "Corrupted binary file");
        } catch (FileNotFoundException e) {
            Log.e(ERROR, "Binary File not found");
        } catch (IOException e) {
            Log.e(ERROR, "General IO Error");
        } catch (ClassNotFoundException e) {
            Log.e(ERROR, "Class not found");
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }
}
