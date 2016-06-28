package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DBAssetHelper;



public class MainActivity extends AppCompatActivity {

    Intent mDetailIntent;
    AdapterView.OnItemClickListener mClickListener;
    ListView mListOfItems;
    Cursor mCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        SQLiteDatabase db;
        db = openOrCreateDatabase("SHOPPING_DB",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null);


        mCursor = db.query("_id",null, null,null,null,null,null,null);
        mListOfItems = (ListView) findViewById(R.id.shopping_list_view);

        CursorAdapter mCursorAdapter = new CursorAdapter(MainActivity.this, mCursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView txt = (TextView) view.findViewById(android.R.id.text1);
                String rowData = cursor.getString(cursor.getColumnIndex("_id"));
                txt.setText(rowData);

            }
        };


        mClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
            }
        };

        mListOfItems.setAdapter(mCursorAdapter);
        mListOfItems.setOnItemClickListener(mClickListener);
    }
}





// shopping list:
//        Bread~Whole Wheat Bread~2.35~Food
//        Milk~1 Gallon Skim Milk~3.50~Dairy
//        Ice Cream~Mint Chocolate Chip~2.20~Dairy
//        Paper Plates~White Paper Plates~7.50~Dishes
//        Chicken Breasts~Boneless Skinless~2.30~Poultry
//        Carrots~Baby Carrots~4.00~Produce
//        Lettuce~Iceberg~3.14~Produce
