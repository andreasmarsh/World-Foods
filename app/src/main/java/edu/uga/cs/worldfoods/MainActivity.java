package edu.uga.cs.worldfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

/**
 * <h1>WorldFoods</h1>
 * WorldFoods displays a splash screen that the user can navigate from to display a
 * List fragment and pick one of five regions of the world to be presented with
 * three street food recipes from selected region. The app also uses fragements
 * to display information cleverly in landscape mode.
 *
 * @author Andreas Marsh
 * @version 1.0
 * @since 2021-03-08
 */
public class MainActivity extends AppCompatActivity {

    private Button goButton;

    /**
     * This method creates the layout that the user sees upon opening the app.
     *
     * @param savedInstanceState This can be used to pass in a Bundle when the app is Paused.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton = findViewById(R.id.button);

        goButton.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), FragmentManager.class);
            v.getContext().startActivity(intent);
        });
    }
}