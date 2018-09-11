package idev.com.tesdycodebywildan;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static java.security.AccessController.getContext;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView listArtis;
    private AdapterArtis adapter;
    private Gson gson;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        adapter = new AdapterArtis(this);
        listArtis = findViewById(R.id.recyclerView);
        listArtis.setAdapter(adapter);
        listArtis.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        gson = new Gson();
        showProgressDialog();
        getData();
    }

    private void getData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://dycodeedu-artist.herokuapp.com/actors", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray actors = object.getJSONArray("actors");
                    for (int i = 0; i < actors.length(); i++) {
                        JSONObject artis = actors.getJSONObject(i);
                        ModelArtis modelArtis = gson.fromJson(artis.toString(), ModelArtis.class);
                        adapter.addDataArtis(modelArtis);
                    }
                    hideProgressDialog();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse networkResponse = error.networkResponse;
                String jsonError;
                if (networkResponse != null && networkResponse.data != null) {
                    jsonError = new String(networkResponse.data);
                    Toast.makeText(HomeActivity.this, jsonError, Toast.LENGTH_SHORT).show();
                }
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("Mohon tunggu, sedang mengambil data !");
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
