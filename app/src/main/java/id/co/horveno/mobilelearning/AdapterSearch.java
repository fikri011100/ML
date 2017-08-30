package id.co.horveno.mobilelearning;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fikriimaduddin on 8/29/17.
 */

public class AdapterSearch extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<mSearch> item;

    public AdapterSearch(Activity activity, List<mSearch> item) {
        this.activity = activity;
        this.item = item;
    }
    @Override
    public int getCount () {
        return item.size();
    }

    @Override
    public Object getItem ( int position){
        return item.get(position);
    }

    @Override
    public long getItemId ( int position){
        return position;
    }

    @Override
    public View getView ( int position, View convertView, ViewGroup parent){

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item_search, null);

        TextView txt_nama = (TextView) convertView.findViewById(R.id.txt_country);

        txt_nama.setText(item.get(position).getJudul_video());

        return convertView;
    }
}


