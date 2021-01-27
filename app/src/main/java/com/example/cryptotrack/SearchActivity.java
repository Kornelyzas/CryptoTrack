package com.example.cryptotrack;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {
    public static final String CRYPTO_API = "https://covid19-api.weedmark.systems/api/v1/stats";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        AsyncFetch asyncFetch = new AsyncFetch();
        asyncFetch.execute();
    }

    private class AsyncFetch extends AsyncTask <String, String, JSONObject> {
        ProgressDialog pdLoading = new ProgressDialog(SearchActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdLoading.setMessage(getResources().getString(R.string.search_loading_data));
            pdLoading.setCancelable(false);
            pdLoading.show();
        }

        @Override
        protected JSONObject doInBackground(String... strings) {
            try {
                JSONObject jsonObject = JSON.readJsonFromUrl(CRYPTO_API);
            } catch (IOException e) {
                Toast.makeText(
                        SearchActivity.this,
                        getResources().getString(R.string.search_error_data)+e.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            } catch (JSONException e) {
                Toast.makeText(
                        SearchActivity.this,
                        getResources().getString(R.string.search_error_data)+e.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            pdLoading.dismiss();

            int statusCode = 0;
            try {
                statusCode = (Integer) jsonObject.get("statusCode");
            } catch (JSONException e) {
                Toast.makeText(
                        SearchActivity.this,
                        getResources().getText(R.string.search_error_data)+e.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            }
            if(statusCode == HttpURLConnection.HTTP_OK) {
                System.err.println(jsonObject.toString());
                Toast.makeText(SearchActivity.this, "", Toast.LENGTH_SHORT).show();
            } else {
                String message = null;
                try {
                    message = (String) jsonObject.get("message");
                } catch (JSONException e) {
                    Toast.makeText(
                            SearchActivity.this,
                            getResources().getText(R.string.search_error_data)+e.getMessage(),
                            Toast.LENGTH_LONG
                    ).show();
                }

                Toast.makeText(
                        SearchActivity.this,
                        getResources().getText(R.string.search_error_data) + message,
                        Toast.LENGTH_LONG
                ).show();

            }
        }
    }
}
