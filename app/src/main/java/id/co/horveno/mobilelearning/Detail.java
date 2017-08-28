package id.co.horveno.mobilelearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Detail extends AppCompatActivity {

    Toolbar toolbarDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbarDetail = (Toolbar) findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbarDetail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.dummy_kotlintitle));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
