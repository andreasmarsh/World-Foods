package edu.uga.cs.worldfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

/**
 * <h1>FragmentManager</h1>
 * FragmentManager loads the fragment_manager layout which manages the list and info fragments
 * to display correctly based on device orrientation.
 *
 * @author Andreas Marsh
 * @version 1.0
 * @since 2021-03-08
 */
public class FragmentManager extends AppCompatActivity {

    private static final String DEBUG_TAG = "WorldFoods";

    /**
     * This method creates the layout that the user sees upon pressing go button.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d( DEBUG_TAG, "FragmentManager.onCreate(): savedInstanceState: " + savedInstanceState );

        // this call will create the UI based on the screen in portrait orientation.
        // /res/layout/activity_android_versions_main.xml will be used;
        // in landscape orientation /res/layout-land/activity_android_versions_main.xml will be used
        setContentView( R.layout.fragment_manager );
    }
}