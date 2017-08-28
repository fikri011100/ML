package id.co.horveno.mobilelearning;

import android.app.Dialog;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class LearnActivity extends AppCompatActivity {

    private EditText toobarSearch;

    private TextView recommendedTitle;
    private TextView recentyTitle;

    private TextView ethicalHackingTitle;
    private TextView ethicalHackingDesc;

    private TextView kotlinTitle;
    private TextView kotlinDesc;

    private TextView photoshopTitle;
    private TextView photoshopDesc;

    private TextView unrealTitle;
    private TextView unrealDesc;
    int clickCount = 0;

    private ArrayList<String> mCourses;

    private ImageView clearSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        initView();

        Typeface ptSans = Typeface.createFromAsset(getAssets(), "fonts/pt_sans.ttf");

        toobarSearch.setTypeface(ptSans);
        toobarSearch.setFocusableInTouchMode(false);
        toobarSearch.setFocusable(false);
        toobarSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickCount == 0) {
                    toobarSearch.setFocusableInTouchMode(true);
                    toobarSearch.setFocusable(true);
                    /*loadCourseSearch();*/
                }
                clickCount = 1;
            }
        });

        clearSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toobarSearch.getText().clear();
            }
        });

        recommendedTitle.setTypeface(ptSans);
        recentyTitle.setTypeface(ptSans);
        ethicalHackingTitle.setTypeface(ptSans);
        ethicalHackingDesc.setTypeface(ptSans);
        kotlinTitle.setTypeface(ptSans);
        kotlinDesc.setTypeface(ptSans);
        photoshopTitle.setTypeface(ptSans);
        photoshopDesc.setTypeface(ptSans);
        unrealTitle.setTypeface(ptSans);
        unrealDesc.setTypeface(ptSans);
    }

    private void initView() {
        toobarSearch = (EditText) findViewById(R.id.toolbarSearch);
        clearSearch = (ImageView) findViewById(R.id.clearSearchContent);
        recommendedTitle = (TextView) findViewById(R.id.recommended_title);
        recentyTitle = (TextView) findViewById(R.id.recently_title);
        ethicalHackingTitle = (TextView) findViewById(R.id.ethicalhacking_title);
        ethicalHackingDesc = (TextView) findViewById(R.id.ethicalhacking_desc);
        kotlinTitle = (TextView) findViewById(R.id.kotlin_title);
        kotlinDesc = (TextView) findViewById(R.id.kotlin_desc);
        photoshopTitle = (TextView) findViewById(R.id.photoshop_title);
        photoshopDesc = (TextView) findViewById(R.id.photoshop_desc);
        unrealTitle = (TextView) findViewById(R.id.unreal_title);
        unrealDesc = (TextView) findViewById(R.id.unreal_desc);
    }
}
