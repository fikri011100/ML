package id.co.horveno.mobilelearning;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ASUS on 24/08/2017.
 */

public class SearchPreferences {

    private static final int BATAS_CACHE = 3;

    public SearchPreferences() {
        super();
    }

    public static void simpanCachePencarian(Context context, String prefName, String key, List search) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        editor = settings.edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(search);
        editor.putString(key, jsonFavorites);
        editor.apply();
    }

    public static ArrayList<String> loadCache(Context context, String prefName, String key ) {
        SharedPreferences settings;
        List<String> favorites;
        settings = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        if (settings.contains(key)) {
            String jsonFavorites = settings.getString(key, null);
            Gson gson = new Gson();
            String[] favoritesItems = gson.fromJson(jsonFavorites, String[].class);
            favorites = Arrays.asList(favoritesItems);
            favorites = new ArrayList<>(favorites);
        } else {
            return null;
        }
        return (ArrayList<String>) favorites;
    }

    public static void addList(Context context, String pref_name, String key,String country) {
        List<String> favorites = loadCache(context, pref_name, key);
        if (favorites == null)
            favorites = new ArrayList<>();

        if(favorites.size() > BATAS_CACHE) {
            favorites.clear();
            deleteList(context, pref_name);
        }

        if(favorites.contains(country)){

            favorites.remove(country);

        }
        favorites.add(country);

        simpanCachePencarian(context, pref_name, key, favorites);

    }

    public static void deleteList(Context context, String pref_name) {
        SharedPreferences myPrefs = context.getSharedPreferences(pref_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs.edit();
        editor.clear();
        editor.apply();
    }
}
