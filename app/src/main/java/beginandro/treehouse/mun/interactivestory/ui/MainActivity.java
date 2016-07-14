package beginandro.treehouse.mun.interactivestory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import beginandro.treehouse.mun.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // on button click

                //get text entered in the EditText field
                String inputName = mNameEditText.getText().toString();

                //display it using Toast
                //Toast.makeText(MainActivity.this, inputName, Toast.LENGTH_SHORT).show();

                //call startStory method which starts our story book app and uses intents to move to next page
                //also pass the entered text in Edit field to this method to use in the next page or activity
                startStory(inputName);

            }
        });


    }

    private void startStory(String nameRcvd) {

        //create a new Intent for the next activity
        Intent storyIntent = new Intent(this,StoryActivity.class);

        //store data in the new intent to use later
        storyIntent.putExtra(getString(R.string.key_name),nameRcvd);

        //start the next activity based on passed in intent
        startActivity(storyIntent);


    }
}
