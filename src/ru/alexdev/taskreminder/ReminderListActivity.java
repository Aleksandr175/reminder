package ru.alexdev.taskreminder;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ReminderListActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder_list); // ������ �� ���� �� ���������
        
        // ��������� � ������ ��������� �����
        String[] items = new String[] {"������ 1", "������ 2", "������ 3", "������ 4"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.reminder_row, R.id.text1, items);
		setListAdapter(adapter); // ���� ������� ������ ������ ��������
    }
    
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
    	super.onListItemClick(l,  v, position, id);
    	
    	Intent i = new Intent(this, ReminderEditActivity.class);
    	i.putExtra("RowId", id);
    	startActivity(i);
    	
    	/*
    	 * ���������� ��������� ��� �������� ��������� � ���� ����� ����������.
    	Intent i = new Intent(Intent.ACTION_SEND);
    	i.setType("text/plain");
    	i.putExtra(Intent.EXTRA_TEXT, "������ ����!");
    	i.putExtra(Intent.EXTRA_SUBJECT, "���� ���������");
    	Intent chooser = Intent.createChooser(i, "��� �������?");
    	startActivity(chooser);*/
    }

    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
    {
    	super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.list_menu, menu);
    	return true;
    }
    
}
