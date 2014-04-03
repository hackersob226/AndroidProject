package com.example.moneycruncher;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;
/**
 * This class creates a Toast whenever an item is selected from the pull
 * down report menu.
 * 
 * @author Katie, Devon, Brandon, Chase, Trang
 */
public class CustomOnItemSelectedListener implements OnItemSelectedListener {
 
     /**
      * Displays a Toast whenever item is selected.
      *
      * @param parent The parent AdapterView
      * @param view   The present View
      * @param pos    The position in the form of an integer
      * @param id     The id of the item
      */
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(parent.getContext(), 
                "Selected : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }
 
  /**
   * Overridden method.
   *
   * @param arg0 Default AdapterView
   */
    public void onNothingSelected(AdapterView<?> arg0) {
    // TODO Auto-generated method stub
    }
 
}
