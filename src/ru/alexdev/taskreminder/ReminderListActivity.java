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
        setContentView(R.layout.reminder_list); // ссылка на файл со ресурсами
        
        // добавляем в список несколько задач
        String[] items = new String[] {"Задача 1", "Задача 2", "Задача 3", "Задача 4"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.reminder_row, R.id.text1, items);
		setListAdapter(adapter); // даем команду забить список задачами
    }
    
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
    	super.onListItemClick(l,  v, position, id);
    	
    	Intent i = new Intent(this, ReminderEditActivity.class);
    	i.putExtra("RowId", id);
    	startActivity(i);
    	
    	/*
    	 * используем намерение для передачи сообщения в сеть через приложения.
    	Intent i = new Intent(Intent.ACTION_SEND);
    	i.setType("text/plain");
    	i.putExtra(Intent.EXTRA_TEXT, "Привет всем!");
    	i.putExtra(Intent.EXTRA_SUBJECT, "Тема сообщения");
    	Intent chooser = Intent.createChooser(i, "Кто сделает?");
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
