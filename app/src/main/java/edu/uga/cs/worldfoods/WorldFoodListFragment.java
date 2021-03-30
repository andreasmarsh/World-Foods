package edu.uga.cs.worldfoods;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;


/**
 * <h1>WorldFoodListFragment</h1>
 * WorldFoodListFragment creates the list fragment and defines its functionality for use with fragment_manager layout.
 *
 * @author Andreas Marsh
 * @version 1.0
 * @since 2021-03-08
 */
public class WorldFoodListFragment extends ListFragment {
    // a TAG string for logcat messages identification
    private static final String TAG = "AndroidVersions";

    // Array of Android versions strings for the list fragment
    private String[] worldFoods = {
            "Latin America",
            "Asia",
            "Europe",
            "Africa",
            "North America"
    };

    // indicate if this is a landscape mode with both fragments present or not
    boolean twoFragmentsActivity = false;

    // list selection index
    int versionIndex = 0;

    /**
     * Creates listFragment and correctly displays fragment based on orientation.
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        Log.d(TAG, "WorldFoodListFragment.onActivityCreated(): savedInstanceState: " + savedInstanceState);

        // create a new ArrayAdapter for the list
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1, worldFoods));

        // set the twoFragmentsActivity variable to true iff we are in 2 fragment (landscape) view
        View detailsFrame = getActivity().findViewById(R.id.worldFoodInfo);
        Log.d(TAG, "WorldFoodListFragment.onActivityCreated(): detailsFrame: " + detailsFrame);

        twoFragmentsActivity = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        // restore the saved list index selection (Android version no), if available
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            versionIndex = savedInstanceState.getInt("worldFoodSelection", 0);
            Log.d(TAG, "WorldFoodListFragment.onActivityCreated(): restored versionIndex: " + versionIndex);
        }

        // set the list mode as single choice and
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setItemChecked(versionIndex, true);

        // if we are in 2 fragment (landscape) orientation, show the Android version information on the right side
        // This class will act as the "driver" here by displaying the details using the other fragment.
        if (twoFragmentsActivity) {

            // display the information about the selected Android version in the fragment on the right (details)
            showWorldFoodInfo(versionIndex);

            // The list in the landscape orientation may be shorter and the selected item
            // which was visible in portrait mode might be invisible (out of view)
            // i.e., "below" the end of the screen in landscape orientation.
            // To make it visible again, call smoothScrollToPosition
            getListView().smoothScrollToPosition(versionIndex);
        }

    }

    /**
     * Creates function to on a click on a list item, show the selected Android version info
     * and store the list view and selection for coming back to the list (using the back button).
     *
     * @param l
     * @param v
     * @param position
     * @param id
     */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // on a click on a list item, show the selected Android version info
        // store the list view and selection for coming back to the list (using the back button)
        //firstVisibleVersionIndex = l.getFirstVisiblePosition();
        //versionIndex = position;
        showWorldFoodInfo(position);
    }

    /**
     * Saves the instance state of what is selected on list.
     *
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save the list index selection
        outState.putInt("worldFoodSelection", versionIndex);
        Log.d(TAG, "WorldFoodListFragment.onSaveInstanceState(): saved versionIndex: " + versionIndex);
    }

    /**
     * Manages how the displaying of infoFragment should be managed based on screen orientation.
     *
     * @param versionIndex
     */
    void showWorldFoodInfo(int versionIndex) {

        this.versionIndex = versionIndex;

        if (twoFragmentsActivity) {  // only in the 2 fragment (landscape) orientation

            getListView().setItemChecked(versionIndex, true);

            // get the placeholder element (FrameLayout) in a 2 fragment (landscape) orientation layout
            WorldFoodInfoFragment details =
                    (WorldFoodInfoFragment) getFragmentManager().findFragmentById(R.id.worldFoodInfo);

            Log.d(TAG, "WorldFoodListFragment.showWorldFoodInfo(): details: " + details);

            if (details == null || details.getShownVersionIndex() != versionIndex) {

                // obtain a new Android info fragment instance
                details = WorldFoodInfoFragment.newInstance( versionIndex);

                // replace the placeholder with the new fragment stance within a transaction
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.worldFoodInfo, details);

                // TRANSIT_FRAGMENT_FADE means that the fragment should fade in or fade out
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

                // commit the transaction, i.e. make the changes
                fragmentTransaction.commit();
            }
        } else {
            // In a 1 fragment orientation (portrait), start a new activity using an Intent, as in the previous demo app
            Intent intent = new Intent();
            intent.setClass(getActivity(), WorldFoodInfoActivity.class);
            intent.putExtra("versionIndex", versionIndex);

            startActivity(intent);
        }
    }
}