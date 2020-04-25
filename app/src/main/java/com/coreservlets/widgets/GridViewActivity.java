package com.coreservlets.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class GridViewActivity extends Activity {
    private String MensajeSelected;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        MensajeSelected = getString(R.string.plantilla_mensaje_gridview);

        List<String> AndroidVendors = getAndroidVendors();
        ArrayAdapter<String> AdapterGrid = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, AndroidVendors);

        GridView gridview = (GridView)findViewById(R.id.gridview);
        gridview.setAdapter(AdapterGrid);
        gridview.setOnItemClickListener(new GridViewInfo());

    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }


    private List<String> getAndroidVendors() {
        String[] vendorArray = { "Acer", "Dell", "HTC", "Huawei", "Kyocera", "LG", "Motorola", "Nexus", "Samsung", "Sony Ericsson", "T-Mobile", "Neptune" };
        List<String> vendorList = Arrays.asList(vendorArray);
        Collections.shuffle(vendorList);
        return(vendorList);
    }

    private class GridViewInfo implements OnItemClickListener {


        @Override
        public void onItemClick(AdapterView<?> gridv, View selectedView,
                                int selectedIndex, long id) {
            String selection = gridv.getItemAtPosition(selectedIndex).toString();
            String message =
                    String.format(MensajeSelected, selection);
            showToast(message);
        }
    }
}
