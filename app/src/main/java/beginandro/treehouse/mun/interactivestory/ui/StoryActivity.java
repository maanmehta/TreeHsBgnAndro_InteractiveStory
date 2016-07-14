package beginandro.treehouse.mun.interactivestory.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import beginandro.treehouse.mun.interactivestory.R;
import beginandro.treehouse.mun.interactivestory.model.Page;
import beginandro.treehouse.mun.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    private Story mStory = new Story();
    private ImageView mStoryImageView;
    private TextView mStoryTextView;
    private Button mChoiceButton1;
    private Button mChoiceButton2;
    private String mName;
    private Page mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        //get the data from the intent and display it using Toast
        mName = getIntent().getStringExtra(getString(R.string.key_name));
        Toast.makeText(StoryActivity.this, mName, Toast.LENGTH_SHORT).show();

        mStoryImageView = (ImageView)findViewById(R.id.storyImageView);
        mStoryTextView = (TextView)findViewById(R.id.storyTextView);
        mChoiceButton1 = (Button)findViewById(R.id.choiceButton1);
        mChoiceButton2 = (Button)findViewById(R.id.choiceButton2);

        loadPage(0);
    }

    private void loadPage(int pageNumber) {
        mCurrentPage = mStory.getPage(pageNumber);

        String pageText = mCurrentPage.getText();
        pageText = String.format(pageText,mName);

        mStoryImageView.setImageDrawable(getResources().getDrawable(mCurrentPage.getImageId()));
        mStoryTextView.setText(pageText);

        if (mCurrentPage.isFinalPage()) {
            mChoiceButton1.setVisibility(View.INVISIBLE);
            mChoiceButton2.setText("Play Again");

            mChoiceButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else {
            mChoiceButton1.setText(mCurrentPage.getChoice1().getText());
            mChoiceButton2.setText(mCurrentPage.getChoice2().getText());


            //add onClick actions for both buttons
            mChoiceButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(mCurrentPage.getChoice1().getPageId());
                }
            });

            mChoiceButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(mCurrentPage.getChoice2().getPageId());
                }
            });
        }


    }


}
