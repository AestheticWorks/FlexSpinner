package com.laurachelaru.flexspinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.laurachelaru.flexspinnerlibrary.FlexItem;
import com.laurachelaru.flexspinnerlibrary.FlexListener;
import com.laurachelaru.flexspinnerlibrary.FlexSpinnerMultiple;
import com.laurachelaru.flexspinnerlibrary.FlexSpinnerMultipleSearch;
import com.laurachelaru.flexspinnerlibrary.FlexSpinnerSingle;
import com.laurachelaru.flexspinnerlibrary.FlexSpinnerSingleSearch;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FlexSpinnerSingle spinnerSingle;
    private FlexSpinnerSingleSearch spinnerSingleSearch;
    private FlexSpinnerMultiple spinnerMultiple;
    private FlexSpinnerMultipleSearch spinnerMultipleSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerSingle = (FlexSpinnerSingle) findViewById(R.id.single_spinner);
        spinnerSingleSearch = (FlexSpinnerSingleSearch) findViewById(R.id.single_spinner_search);
        spinnerMultiple = (FlexSpinnerMultiple) findViewById(R.id.multiple_spinner);
        spinnerMultipleSearch = (FlexSpinnerMultipleSearch) findViewById(R.id.multiple_spinner_search);
        Button button = (Button) findViewById(R.id.button);

        List<FlexItem> singleSpinnerItemList = new ArrayList<>();
        for (int i = 0; i<30; i++) {
            singleSpinnerItemList.add(new FlexItem("Item " +String.valueOf(i), i, i==3));
        }

        spinnerSingle.setData(singleSpinnerItemList, new FlexListener() {
            @Override
            public void onItemSelected(List<FlexItem> items, int position) {
                Toast.makeText(MainActivity.this, String.valueOf(items.get(position).getIntId()), Toast.LENGTH_SHORT).show();
            }
        });

        List<FlexItem> singleSpinnerSearchItemList = new ArrayList<>();
        for (int i = 0; i<30; i++) {
            singleSpinnerSearchItemList.add(new FlexItem("Item " +String.valueOf(i), "item"+String.valueOf(i), false));
        }

        spinnerSingleSearch.setData(singleSpinnerSearchItemList, new FlexListener() {
            @Override
            public void onItemSelected(List<FlexItem> items, int position) {
                //Toast.makeText(MainActivity.this, items.get(position).getStringId(), Toast.LENGTH_SHORT).show();
            }
        });

        List<FlexItem> multipleSpinnerItemList = new ArrayList<>();
        for (int i = 0; i<30; i++) {
            multipleSpinnerItemList.add(new FlexItem("Item " +String.valueOf(i), i, false));
        }

        spinnerMultiple.setData(multipleSpinnerItemList, new FlexListener() {
            @Override
            public void onItemSelected(List<FlexItem> items, int position) {
                Toast.makeText(MainActivity.this, String.valueOf(items.get(position).getIntId()), Toast.LENGTH_SHORT).show();
            }
        });

        List<FlexItem> multipleSpinnerSearchItemList = new ArrayList<>();
        for (int i = 0; i<30; i++) {
            multipleSpinnerSearchItemList.add(new FlexItem("Item " +String.valueOf(i), "item"+String.valueOf(i), false));
        }

        spinnerMultipleSearch.setData(multipleSpinnerSearchItemList, new FlexListener() {
            @Override
            public void onItemSelected(List<FlexItem> items, int position) {
                Toast.makeText(MainActivity.this, items.get(position).getStringId(), Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                String singleSpinnerItems = "Single spinner: ";
                String singleSpinnerSearchItems = "Single spinner search: ";
                String multipleSpinnerItems = "Multiple spinner: ";
                String multipleSpinnerSearchItems = "Multiple spinner search: ";

                if (spinnerSingle.getSelectedItem() != null) {
                    singleSpinnerItems = singleSpinnerItems + spinnerSingle.getSelectedItem().getText();

                    if (spinnerSingle.getSelectedItem().getStringId() != null) {
                        singleSpinnerItems = singleSpinnerItems + "-> " + spinnerSingle.getSelectedItem().getStringId();
                    } else {
                        singleSpinnerItems = singleSpinnerItems + "-> " + String.valueOf(spinnerSingle.getSelectedItem().getIntId());
                    }
                } else {
                    singleSpinnerItems = singleSpinnerItems + "No item selected";
                }

                if (spinnerSingleSearch.getSelectedItem() != null) {
                    singleSpinnerSearchItems = singleSpinnerSearchItems + spinnerSingleSearch.getSelectedItem().getText();

                    if (spinnerSingleSearch.getSelectedItem().getStringId() != null) {
                        singleSpinnerSearchItems = singleSpinnerSearchItems + "-> " + spinnerSingleSearch.getSelectedItem().getStringId();
                    } else {
                        singleSpinnerSearchItems = singleSpinnerSearchItems + "-> " + String.valueOf(spinnerSingleSearch.getSelectedItem().getIntId());
                    }
                } else {
                    singleSpinnerSearchItems = singleSpinnerSearchItems + "No item selected";
                }

                if (!spinnerMultiple.getSelectedItems().isEmpty()) {
                    for (FlexItem item: spinnerMultiple.getSelectedItems()) {
                        multipleSpinnerItems = multipleSpinnerItems + item.getText();

                        if (item.getStringId() != null) {
                            multipleSpinnerItems = multipleSpinnerItems + "-> " +item.getStringId() + " ";
                        } else {
                            multipleSpinnerItems = multipleSpinnerItems + "-> " + String.valueOf(item.getIntId())+ " ";
                        }
                    }
                } else {
                    multipleSpinnerItems = multipleSpinnerItems + "No items selected";
                }

                if (!spinnerMultipleSearch.getSelectedItems().isEmpty()) {
                    for (FlexItem item: spinnerMultipleSearch.getSelectedItems()) {
                        multipleSpinnerSearchItems = multipleSpinnerSearchItems + item.getText();

                        if (item.getStringId() != null) {
                            multipleSpinnerSearchItems = multipleSpinnerSearchItems + "-> " + item.getStringId() + " ";
                        } else {
                            multipleSpinnerSearchItems = multipleSpinnerSearchItems + "-> " + String.valueOf(item.getIntId())+ " ";
                        }
                    }
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.RoundedAlertDialog);
                builder.setTitle("Selected Items");
                builder.setMessage(singleSpinnerItems + "\n" + singleSpinnerSearchItems + "\n" + multipleSpinnerItems + "\n" + multipleSpinnerSearchItems);

                builder.show();

                break;
            default:
                break;
        }
    }
}
