package interactivestory.karroltontech.com.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import interactivestory.karroltontech.com.interactivestory.R;
import interactivestory.karroltontech.com.interactivestory.model.Page;
import interactivestory.karroltontech.com.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {
    private Story story=new Story();
    private ImageView imageView;
    private TextView textView;
    private Button choice1;
    private Button choice2;
    private String name;
    private Page page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent=getIntent();
        name=intent.getStringExtra(getString(R.string.name));
        imageView=(ImageView)findViewById(R.id.storyImageView);
        textView=(TextView)findViewById(R.id.storyTextView);
        choice1=(Button)findViewById(R.id.choiceButton1);
        choice2=(Button)findViewById(R.id.choiceButton2);
        loadPage(0);

    }

    private void loadPage(int choice)
    {
        page=story.getPage(choice);
        Drawable drawable=getResources().getDrawable(page.getImageId());
        imageView.setImageDrawable(drawable);
        String pageText=page.getText();
        //Add the name if placeholder is included. Will not add if no placeholder.
        pageText=String.format(pageText,name);
        textView.setText(pageText);
        if(page.isFinal())
        {
            choice1.setVisibility(View.INVISIBLE);
            choice2.setText("PLAY AGAIN");
            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        else {
            choice1.setText(page.getChoice1().getText());
            choice2.setText(page.getChoice2().getText());
            choice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = page.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });
            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = page.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });
        }




















    }

}
