package ru.alexdev.taskreminder;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;


public class ReminderEditActivity extends Activity {
	@Override
	protected void onCreate(Bundle saveInstanceState) 
	{
		super.onCreate(saveInstanceState);
		setContentView(R.layout.reminder_edit);
		
		if (getIntent() != null) 
		{
			Bundle extras = getIntent().getExtras();
			int rowId = extras != null ? extras.getInt("RowId") : -1;
			
			//далее используем айди строки
		}
	}
}
