package com.example.presenter;

import com.example.memory.IList;
import com.example.moneycruncher.IDisplayAccountActivity;

/**
 * @author 
 *
 */
public class DisplayAccountPresenter extends Presenter {
    /**
     * 
     */
    private final IDisplayAccountActivity myActivity;
    /**
     * 
     */
    private final IList myList;

    /**
     * @param activity 
     * @param list 
     */
    public DisplayAccountPresenter(IDisplayAccountActivity activity, IList list) {
	myActivity = activity;
	myList = list;
    }
}
