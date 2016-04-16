package interactivestory.karroltontech.com.interactivestory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import interactivestory.karroltontech.com.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText nameText;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText=(EditText)findViewById(R.id.nameEditText);
        startButton=(Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=nameText.getText().toString();
                startStory(name);

            }
        });


    }
    void startStory(String name)
    {
        Intent intent=new Intent(this,StoryActivity.class);
        intent.putExtra(getString(R.string.name),name);

        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
