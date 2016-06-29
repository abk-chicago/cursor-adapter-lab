package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    TextView mTxtItem;
    TextView mTxtDetail;
    TextView mTxtType;
    TextView mTxtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTxtDetail = (TextView) findViewById(R.id.grocery_detail);
        mTxtItem = (TextView) findViewById(R.id.grocery_item);
        mTxtPrice = (TextView) findViewById(R.id.grocery_price);
        mTxtType = (TextView) findViewById(R.id.grocery_type);

        Intent listIntent = getIntent();
        String name = listIntent.getStringExtra("ITEM_NAME");
        String description = listIntent.getStringExtra("DESCRIPTION");
        String price = listIntent.getStringExtra("PRICE");
        String type = listIntent.getStringExtra("TYPE");

        mTxtType.setText(type);
        mTxtPrice.setText(price);
        mTxtItem.setText(name);
        mTxtDetail.setText(description);
    }
}
