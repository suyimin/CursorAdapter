package com.example.android.colors.cursoradapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyCursorAdapter extends CursorAdapter {
    private LayoutInflater cursorInflater;

    private TextView continent;
    private TextView region;
    private TextView name;
    private TextView code;
    public MyCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        cursorInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return cursorInflater.inflate(R.layout.country_info, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        continent = (TextView) view.findViewById(R.id.continent);
        region = (TextView) view.findViewById(R.id.region);
        name = (TextView) view.findViewById(R.id.name);
        code = (TextView) view.findViewById(R.id.code);
        String title = cursor.getString( cursor.getColumnIndex( CountriesDbAdapter.KEY_CODE) );
        code.setText(title);
        name.setText(cursor.getString( cursor.getColumnIndex( CountriesDbAdapter.KEY_NAME) ));
        region.setText(cursor.getString( cursor.getColumnIndex( CountriesDbAdapter.KEY_CONTINENT) ));
        continent.setText(cursor.getString( cursor.getColumnIndex( CountriesDbAdapter.KEY_REGION) ));
    }
}