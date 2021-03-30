package edu.uga.cs.worldfoods;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


/**
 * <h1>WorldFoodInfoActivity</h1>
 * WorldFoodInfoActivity correctly manages the info fragment based on orientation.
 *
 * @author Andreas Marsh
 * @version 1.0
 * @since 2021-03-08
 */
public class WorldFoodInfoActivity extends AppCompatActivity {
    // a TAG to identify logcat events
    private static final String TAG = "AndroidVersions";

    /**
     * This method creates the layout that the user sees upon selecting a world region from list.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        Log.d( TAG, "WorldFoodInfoActivity.onCreate()" );

        super.onCreate( savedInstanceState );

        // IMPORTANT:
        // Add the back button in the ActionBar of this activity.  It will appear
        // as a left chevron (arrow tip), the regular back button.
        //
        // We can't use the Parent specification in the AndroidManifest, since
        // it would place the activity on the back stack.  Consequently, when going
        // back to the screen with the list of Android versions (using the "parent-specified"
        // back button, this would cause a recreation of the ListFragment.  The new list
        // would show the initial item (Android version) as selected, not the one we
        // actually selected when transitioning to the Android version details screen.
        //
        // However, there must be a listener added for this back button (look below).
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled( true );

        // If this activity is in foreground in portrait orientation, the MainActivity is also present
        // in on the back stack.  When the user changes the orientation to landscape, Android kills
        // ALL activities in the app and restarts them. All fragments hosted in them are killed, as well.
        // This activity (AndroidVersionInfoActivity) will be restarted, but it will no be needed, as
        // the AndroidVersionsMainActivity's landscape orientation will include all needed data (both
        // fragments).  AndroidVersionsMainActivity will also be restarted and it will build and show
        // both fragments.  AndroidVersionListFragment hosted there will control this work.
        // Consequently, this activity will not be needed after the restart.  So, in landscape orientation
        // we should kill this activity.  It is done using the finish() method.  Note that we immediately
        // return from onCreate(), as well.
        if( getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ) {
            Log.d( TAG, "WorldFoodInfoActivity.onCreate(): in landscape mode; returning" );
            finish();
            return;
        }

        Log.d(TAG, "WorldFoodInfoActivity.onCreate(): in portrait mode; replacing fragments");

        WorldFoodInfoFragment worldFoodInfoFragment = new WorldFoodInfoFragment();
        Log.d(TAG, "WorldFoodInfoActivity.onCreate(): WorldFoodInfoFragment: " + worldFoodInfoFragment);


        // pass on any saved data, i.e., Android version no (list index)
        worldFoodInfoFragment.setArguments( getIntent().getExtras() );

        // add the fragment within a transaction
        // android.R.id.content is used to obtain the view reference without having to have its id
        // it reference the root (ViewGroup) of the entire content area of an Activity
        getSupportFragmentManager().beginTransaction().replace( android.R.id.content, worldFoodInfoFragment ).commit();
    }

    /**
     * This method creates a back button at the top left of info fragment if in portrait mode.
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Implement Back button listener method.
        // This method may be used for other actions from the ActionBar menu, if provided in the layout.
        int id = item.getItemId();

        // android.R.id.home is the built-in designation of the back button widget.
        if( id == android.R.id.home ) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected( item );
    }
}
