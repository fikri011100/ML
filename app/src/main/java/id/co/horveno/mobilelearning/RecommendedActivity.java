package id.co.horveno.mobilelearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

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

public class RecommendedActivity extends AppCompatActivity {
    private RecyclerView recyclerRecommended;
    ArrayList<HashMap<String, String>> list;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    public String URLRec = Helper.BASE_URL+"getkontentnonlimit.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended);
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarRecom);
        toolbar.setTitle("Recommended for you");
        toolbar.setTitleTextColor(R.color.colorPrimaryDark);
        LinearLayoutManager glm = new LinearLayoutManager(this);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerRecommended.setLayoutManager(glm);
        loadData();
    }

    private void loadData() {
        requestQueue = Volley.newRequestQueue(RecommendedActivity.this);

        list = new ArrayList<HashMap<String, String >>();
        stringRequest = new StringRequest(Request.Method.POST, URLRec, new Response.Listener<String>() {
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
                        list.add(map);
                        AdapterRecommended adapter = new AdapterRecommended(RecommendedActivity.this, list);
                        recyclerRecommended.setAdapter(adapter);
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
        recyclerRecommended= (RecyclerView)findViewById(R.id.recycleRecommended);
    }
}
