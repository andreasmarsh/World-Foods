package edu.uga.cs.worldfoods;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;


/**
 * <h1>WorldFoodInfoFragment</h1>
 * WorldFoodInfoFragment creates the info fragment and defines its functionality for use with fragment_manager layout.
 *
 * @author Andreas Marsh
 * @version 1.0
 * @since 2021-03-08
 */
public class WorldFoodInfoFragment extends Fragment {

    private static String TAG = "WorldFood InfoFragment";

    private int position;

    /**
     * Required empty public constructor.
     *
     */
    public WorldFoodInfoFragment() {
        // Required empty public constructor
    }

    /**
     * This method is similar to the factory method design pattern
     * to create new instances of this fragment.
     * There is a specific reason for having this method, though.  We want to send some data (VersionIndex, here) into the
     * new fragment.  Android disallows overloaded constructors for fragments, and so we can't create a Fragment with
     * the versionIndex as argument.  But we can use the Bundle and send the data this way.  Also, the setArguments call
     * must happen BEFORE the fragment is attached an activity.
     *
     * @param versionIndex
     * @return
     */
    public static WorldFoodInfoFragment newInstance( int versionIndex ) {

        Log.d( TAG, "WorldFoodInfoFragment.newInstance(): versionIndex: " + versionIndex );

        // this uses the default constructor (not defined in this class, but Java-supplied)
        WorldFoodInfoFragment fragment = new WorldFoodInfoFragment();
        Log.d(TAG, "WorldFoodInfoFragment.newInstance(): fragment: " + fragment);


        // save the selected list versionIndex in the new fragment's Bundle data
        // the AndroidVersionInfoFragment needs to know the version to display
        Bundle args = new Bundle();
        args.putInt( "versionIndex", versionIndex );
        fragment.setArguments( args );

        return fragment;
    }

    /**
     * Defines position variable.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getShownVersionIndex();
        }
    }

    /**
     * The big meat of infoFragment. Uses position of listFragment to correctly display
     * the proper info in infoFragment.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        if (container != null)
            container.removeAllViews();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        // Instantiate all elements of layout fragment_info
        TextView regionTitle = (TextView) view.findViewById(R.id.textView);
        ImageView overviewImage = (ImageView) view.findViewById(R.id.imageView);
        TextView overviewText = (TextView) view.findViewById(R.id.textView2);
        ImageView oneImage = (ImageView) view.findViewById(R.id.imageView2);
        TextView recipeOne = (TextView) view.findViewById(R.id.textView3);
        ImageView twoImage = (ImageView) view.findViewById(R.id.imageView3);
        TextView recipeTwo = (TextView) view.findViewById(R.id.textView4);
        ImageView threeImage = (ImageView) view.findViewById(R.id.imageView4);
        TextView recipeThree = (TextView) view.findViewById(R.id.textView5);

        if (position == 0) {
            regionTitle.setText("Latin America");

            overviewImage.setImageResource( R.drawable.latin_overview);
            // set overview text
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.latin_text);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                overviewText.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                overviewText.setText("Error: can't show info text.");
            }

            oneImage.setImageResource( R.drawable.latin_recipe_one);
            // set recipe text for first recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.latin_recipe_one);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeOne.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeOne.setText("Error: can't show info text.");
            }

            twoImage.setImageResource( R.drawable.latin_recipe_two);
            // set recipe text for second recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.latin_recipe_two);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeTwo.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeTwo.setText("Error: can't show info text.");
            }

            threeImage.setImageResource( R.drawable.latin_recipe_three);
            // set recipe text for third recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.latin_recipe_three);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeThree.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeThree.setText("Error: can't show info text.");
            }
        }

        if (position == 1) {
            regionTitle.setText("Asia");

            overviewImage.setImageResource( R.drawable.asia_overview);
            // set overview text
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.asia_text);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                overviewText.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                overviewText.setText("Error: can't show info text.");
            }

            oneImage.setImageResource( R.drawable.asia_recipe_one);
            // set recipe text for first recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.asia_recipe_one);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeOne.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeOne.setText("Error: can't show info text.");
            }

            twoImage.setImageResource( R.drawable.asia_recipe_two);
            // set recipe text for second recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.asia_recipe_two);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeTwo.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeTwo.setText("Error: can't show info text.");
            }

            threeImage.setImageResource( R.drawable.asia_recipe_three);
            // set recipe text for third recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.asia_recipe_three);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeThree.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeThree.setText("Error: can't show info text.");
            }
        }

        if (position == 2) {
            regionTitle.setText("Europe");

            overviewImage.setImageResource( R.drawable.euro_overview);
            // set overview text
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.euro_text);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                overviewText.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                overviewText.setText("Error: can't show info text.");
            }

            oneImage.setImageResource( R.drawable.euro_recipe_one);
            // set recipe text for first recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.euro_recipe_one);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeOne.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeOne.setText("Error: can't show info text.");
            }

            twoImage.setImageResource( R.drawable.euro_recipe_two);
            // set recipe text for second recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.euro_recipe_two);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeTwo.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeTwo.setText("Error: can't show info text.");
            }

            threeImage.setImageResource( R.drawable.euro_recipe_three);
            // set recipe text for third recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.euro_recipe_three);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeThree.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeThree.setText("Error: can't show info text.");
            }
        }

        if (position == 3) {
            regionTitle.setText("Africa");

            overviewImage.setImageResource( R.drawable.africa_overview);
            // set overview text
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.africa_text);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                overviewText.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                overviewText.setText("Error: can't show info text.");
            }

            oneImage.setImageResource( R.drawable.africa_recipe_one);
            // set recipe text for first recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.africa_recipe_one);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeOne.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeOne.setText("Error: can't show info text.");
            }

            twoImage.setImageResource( R.drawable.africa_recipe_two);
            // set recipe text for second recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.africa_recipe_two);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeTwo.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeTwo.setText("Error: can't show info text.");
            }

            threeImage.setImageResource( R.drawable.africa_recipe_three);
            // set recipe text for third recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.africa_recipe_three);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeThree.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeThree.setText("Error: can't show info text.");
            }
        }

        if (position == 4) {
            regionTitle.setText("North America");

            overviewImage.setImageResource( R.drawable.north_overview);
            // set overview text
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.north_text);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                overviewText.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                overviewText.setText("Error: can't show info text.");
            }

            oneImage.setImageResource( R.drawable.north_recipe_one);
            // set recipe text for first recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.north_recipe_one);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeOne.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeOne.setText("Error: can't show info text.");
            }

            twoImage.setImageResource( R.drawable.north_recipe_two);
            // set recipe text for second recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.north_recipe_two);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeTwo.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeTwo.setText("Error: can't show info text.");
            }

            threeImage.setImageResource( R.drawable.north_recipe_three);
            // set recipe text for third recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.north_recipe_three);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipeThree.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipeThree.setText("Error: can't show info text.");
            }
        }

        return view;
    }

    /**
     * Getter for which region is selected.
     *
     * @return
     */
    public int getShownVersionIndex() {
        return getArguments().getInt("versionIndex", 0 );
    }


}