package com.pokemon.planner.util.jsonparser;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.pokemon.planner.dataobjects.PokemonBase;
import com.pokemon.planner.dataobjects.Stats;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luka on 3/6/14.
 */
public class JsonParser {
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    static Context context = null;

    public void initContext(Context context) {
        JsonParser.context = context;
    }

    private JSONObject getJSONFromUrl(String url) {

        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
            Log.i("JSON string", json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        // return JSON String
        return jObj;
    }

    private JSONObject getJSONFromFile(String fileName) {
        AssetManager am = context.getAssets();

        try {
            InputStream is = am.open(fileName + ".txt");

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            is.close();
            json = sb.toString();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        return jObj;
    }

    public PokemonBase parsePokemonData(String dexNumber) {
        int dexValue = Integer.parseInt(dexNumber);
        if (dexValue <= 151) {
            dexNumber = "1\\" + dexNumber;
        } else {
            return null;
        }

        JSONObject jObj = getJSONFromFile(dexNumber);

        PokemonBase pokemonBase;

        try {
            String name = jObj.getString("Name");

            String[] abilities;
            JSONArray jArray = jObj.getJSONArray("Abilities");
            abilities = new String[jArray.length()];

            for (int i = 0; i < abilities.length; i++) {
                abilities[i] = jArray.getString(i);
            }

            String hiddenAbility = jObj.getString("HiddenAbility");

            Stats stats;

            jArray = jObj.getJSONArray("BaseStats");

            stats = new Stats(
                    Double.parseDouble(jArray.getString(0)),
                    Double.parseDouble(jArray.getString(0)),
                    Double.parseDouble(jArray.getString(0)),
                    Double.parseDouble(jArray.getString(0)),
                    Double.parseDouble(jArray.getString(0)),
                    Double.parseDouble(jArray.getString(0)));

            pokemonBase = new PokemonBase(dexNumber, name, abilities, hiddenAbility, stats);
        } catch (Exception e) {
            return null;
        }

        return pokemonBase;
    }

    public List<String> parseItems() {
        List<String> items = new ArrayList<String>();
        JSONObject jObj = getJSONFromFile("Berries");
        try {
        } catch (Exception e) {
            items = new ArrayList<String>();
        }
        jObj = getJSONFromFile("Items");
        try {
        } catch (Exception e) {
            items = new ArrayList<String>();
        }

        return items;
    }
}
