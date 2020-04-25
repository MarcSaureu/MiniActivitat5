package com.coreservlets.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ListViewActivity  extends Activity implements OnItemClickListener {
    private String MensajeSelected;
    ArrayAdapter<String> AdapterList;
    ListView listview;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.listview);
        listview = findViewById(R.id.listview);
        MensajeSelected = getString(R.string.plantilla_mensaje_listview);

        List<String> AndroidVendors = getAndroidVendors();
        AdapterList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, AndroidVendors);
        listview.setAdapter(AdapterList);
        listview.setOnItemClickListener(this);
        registerForContextMenu(listview);

    }
    private List<String> getAndroidVendors () {
        String[] vendorArray = {"RIM", "Nokia", "Palm"};
        List<String> vendorList = Arrays.asList(vendorArray);
        Collections.shuffle(vendorList);
        return (vendorList);
    }


    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }


    public void onItemClick (AdapterView < ? > listvie, View selectedView, int position, long id){
        String selection = listvie.getItemAtPosition(position).toString();
        String message = String.format(MensajeSelected, selection);
        showToast(message);
    }


    @Override
    public void onCreateContextMenu (ContextMenu contextmenu, View v, ContextMenu.ContextMenuInfo Infomenu) {
        super.onCreateContextMenu(contextmenu, v, Infomenu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx, contextmenu);

    }
}
