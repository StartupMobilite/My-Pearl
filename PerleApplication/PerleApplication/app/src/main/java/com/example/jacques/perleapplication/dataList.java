package com.example.jacques.perleapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toolbar;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class dataList extends ActionBarActivity {

    String myJson;
    Toolbar toolbar;
    private static final String TAG_RESULTS="result";
    private static final String TAG_ID = "id";
    private static final String TAG_User = "username";
    private static final String TAG_Email ="email";
    private static final String TAG_Tel="telephone";
    private static final String TAG_School = "etablissements";
    private static final String TAG_Fonction = "fonction";

    JSONArray etudiants = null;

    ArrayList<HashMap<String, String>> etudiantsList;
    ListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        setTitle("contact");
        list = (ListView) findViewById(R.id.listView);
        etudiantsList = new ArrayList<HashMap<String,String>>();
        getData();

    }

    private void getData() {

        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {
                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                HttpPost httppost = new HttpPost("http://www.maperle.esy.es/connection/getData.php");

                // Depends on your web service
                httppost.setHeader("Content-type", "application/json");

                InputStream inputStream = null;
                String result = null;
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();

                    inputStream = entity.getContent();
                    // json is UTF-8 by default
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (Exception e) {
                    // Oops
                }
                finally {
                    try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                myJson=result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }

    protected void showList(){
        try {
            JSONObject jsonObj = new JSONObject(myJson);
            etudiants = jsonObj.getJSONArray(TAG_RESULTS);

            for(int i=0;i<etudiants.length();i++){
                JSONObject c = etudiants.getJSONObject(i);
                String id = c.getString(TAG_ID);
                String username = c.getString(TAG_User);
                String email = c.getString(TAG_Email);
                String tel = c.getString(TAG_Tel);
                String etablissements = c.getString(TAG_School);
                String Fonction = c.getString(TAG_Fonction);


                HashMap<String,String> persons = new HashMap<String,String>();

                persons.put(TAG_ID,id);
                persons.put(TAG_User,username);
                persons.put(TAG_Email,email);
                persons.put(TAG_Tel,tel);
                persons.put(TAG_School,etablissements);
                persons.put(TAG_Fonction,Fonction);





                etudiantsList.add(persons);
            }

            ListAdapter adapter = new SimpleAdapter(
                    dataList.this, etudiantsList, R.layout.list_item,
                    new String[]{TAG_ID,TAG_User,TAG_Email,TAG_Tel,TAG_School,TAG_Fonction},
                    new int[]{R.id.id, R.id.username, R.id.email,R.id.telephone,R.id.school,R.id.fonction}
            );

            list.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
