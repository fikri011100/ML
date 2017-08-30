package id.co.horveno.mobilelearning;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LearnActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    public String url = Helper.BASE_URL+ "getkontentlimit.php";
    ArrayList<HashMap<String, String>> list_data;

    private RequestQueue req;
    private StringRequest strReq;
    public String urll = Helper.BASE_URL+"getrecent.php";
    ArrayList<HashMap<String, String>> list_recently;

    private EditText toobarSearch;

    private TextView recommendedTitle;
    private TextView recentyTitle;

    private TextView ethicalHackingTitle;
    private TextView ethicalHackingDesc;

    private TextView kotlinTitle;
    private TextView kotlinDesc;

    private RecyclerView recycler;
    private RecyclerView rec;

    private Button MoreRecommended;
    private Button MoreRecently;
    private ImageView imageSearch;

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

        MoreRecommended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LearnActivity.this, RecommendedActivity.class));
            }
        });

        LinearLayoutManager glm = new LinearLayoutManager(this);
        glm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler.setLayoutManager(glm);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rec.setLayoutManager(llm);

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

//        recommendedTitle.setTypeface(ptSans);
//        recentyTitle.setTypeface(ptSans);
//        ethicalHackingTitle.setTypeface(ptSans);
//        ethicalHackingDesc.setTypeface(ptSans);
//        kotlinTitle.setTypeface(ptSans);
//        kotlinDesc.setTypeface(ptSans);
//        photoshopTitle.setTypeface(ptSans);
//        photoshopDesc.setTypeface(ptSans);
//        unrealTitle.setTypeface(ptSans);
//        unrealDesc.setTypeface(ptSans);
        loadData();
        dua();
    }

    private void dua() {
        req = Volley.newRequestQueue(LearnActivity.this);

        list_recently = new ArrayList<HashMap<String, String >>();
        strReq = new StringRequest(Request.Method.POST, urll, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response ", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("id", json.getString("id"));
                        map.put("judul_video", json.getString("judul_video"));
                        map.put("gambar", json.getString("gambar"));
                        map.put("duration", json.getString("duration"));
                        map.put("id_kategori", json.getString("id_kategori"));
                        list_recently.add(map);
                        RecentlyAdapter adapter = new RecentlyAdapter(LearnActivity.this, list_recently);
                        rec.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", "1");

                return params;
            }

        };


        req.add(strReq);
    }

    private void loadData() {
        requestQueue = Volley.newRequestQueue(LearnActivity.this);

        list_data = new ArrayList<HashMap<String, String >>();
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response ", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("id", json.getString("id"));
                        map.put("judul_video", json.getString("judul_video"));
                        map.put("gambar", json.getString("gambar"));
                        map.put("duration", json.getString("duration"));
                        map.put("id_kategori", json.getString("id_kategori"));
                        list_data.add(map);
                        LearnAdapter adapter = new LearnAdapter(LearnActivity.this, list_data);
                        recycler.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", "1");

                return params;
            }

        };


        requestQueue.add(stringRequest);
    }

    private void initView() {
        recycler = (RecyclerView)findViewById(R.id.rv_learn);
        imageSearch = (ImageView)findViewById(R.id.img_tool_back);
        MoreRecently = (Button)findViewById(R.id.moreRecently);
        MoreRecommended = (Button)findViewById(R.id.moreRecommended);
        toobarSearch = (EditText) findViewById(R.id.toolbarSearch);
        clearSearch = (ImageView) findViewById(R.id.clearSearchContent);
        recommendedTitle = (TextView) findViewById(R.id.recommended_title);
        recentyTitle = (TextView) findViewById(R.id.recently_title);
        rec = (RecyclerView)findViewById(R.id.rv_recent);

    }
//    void getRetroArray() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);
//        retrofit.Call<List<Model>> call = service.getModelDetails();
//        call.enqueue(new Callback<List<Model>>() {
//            @Override
//            public void onResponse(retrofit.Response<List<Model>> response, Retrofit retrofit) {
//                try {
//                    List<Model> model = response.body();
//                    for (int i = 0; i < model.size(); i++){
//                        if (i == 0) {
//
//                        }
//                    }
//                }catch (Exception e){
//                    Log.d("onResponse", "There is an Error");
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Log.d("onFailure", t.toString());
//            }
//        });
//
//    }
}
