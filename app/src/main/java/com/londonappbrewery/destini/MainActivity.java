package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mAnswerButton1;
    Button mAnswerButton2;
    TextView mStoryView;

    int mStoryIndex;

    private int[] storyResourceID = new int[] {
            R.string.T1_Story, R.string.T2_Story, R.string.T3_Story,
            R.string.T4_End, R.string.T5_End, R.string.T6_End
    };

    private int[] ans1ResourceID = new int[] {
            R.string.T1_Ans1, R.string.T2_Ans1, R.string.T3_Ans1
    };

    private int[] ans2ResourceID = new int[] {
            R.string.T1_Ans2, R.string.T2_Ans2, R.string.T3_Ans2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryView = (TextView) findViewById(R.id.storyTextView);
        mAnswerButton1 = (Button) findViewById(R.id.buttonTop);
        mAnswerButton2 = (Button) findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mAnswerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateStory(true);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mAnswerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateStory(false);
            }
        });

    }

    private void UpdateStory(boolean answer){
        if(mStoryIndex == 1){
            if (answer == true) {
                mStoryIndex = 2;
                UpdateButtons(mStoryIndex);
            }else {
                mStoryIndex = 3; //end
                HideButtons();
            }
        } else if(mStoryIndex == 2){
            if (answer == true) {
                mStoryIndex = 5; //end
                HideButtons();
            }else {
                mStoryIndex = 4; //end
                HideButtons();
            }
        } else {                 //we are at start
            if (answer == true) {
                mStoryIndex = 2;
                UpdateButtons(mStoryIndex);
            } else {
                mStoryIndex = 1;
                UpdateButtons(mStoryIndex);
            }
        }
        mStoryView.setText(storyResourceID[mStoryIndex]);
    }

    private void HideButtons(){
        mAnswerButton1.setVisibility(View.GONE);
        mAnswerButton2.setVisibility(View.GONE);
    }

    //Used when not at end to avoid overreaching array
    private void UpdateButtons(int x){
        mAnswerButton1.setText(ans1ResourceID[x]);
        mAnswerButton2.setText(ans2ResourceID[x]);
    }

}
