package com.example.escolarprj;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class RegistroCicloEscolar extends ActionBarActivity {
	EditText editNombreCiclo;
	EditText editInicio;
	EditText editFin;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro_ciclo_escolar);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registro_ciclo_escolar, menu);
		editNombreCiclo = (EditText) findViewById(R.id.editNombreCiclo);
		editInicio = (EditText) findViewById(R.id.editInicioCicloEscolar);
		editFin = (EditText) findViewById(R.id.editFinCicloEscolar);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_registro_ciclo_escolar, container, false);
			return rootView;
		}
	}
	
	
	public void showDatePickerDialogInicio(View v) {
		DatePickerFragment newFragment = new DatePickerFragment();
	    newFragment.setEditText(editInicio);
	    newFragment.show(getSupportFragmentManager(), "datePicker");
	}
	
	public void showDatePickerDialogFin(View v) {
		DatePickerFragment newFragment = new DatePickerFragment();
	    newFragment.setEditText(editFin);
	    newFragment.show(getSupportFragmentManager(), "datePicker");
	}
	
	@SuppressLint({ "NewApi", "ValidFragment" })
    private class DatePickerFragment extends DialogFragment implements
    		DatePickerDialog.OnDateSetListener {
		EditText editTextFecha;
		
		public void setEditText(EditText editText){
			editTextFecha=editText;
		}
		
    	@Override
    	public Dialog onCreateDialog(Bundle savedInstanceState) {
    		// Use the current date as the default date in the picker
    		// Create a new instance of DatePickerDialog and return it
    		
    		String editString = editTextFecha.getText().toString(); 
    		if(editString.equals("")){
    			final Calendar c = Calendar.getInstance();
    			return new DatePickerDialog(getActivity(), this, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
    		}
    		String datosFecha[] = editString.split("/");
    		return new DatePickerDialog(getActivity(), this, Integer.parseInt(datosFecha[2]), Integer.parseInt(datosFecha[1])-1, Integer.parseInt(datosFecha[0]));
    		
    	}

    	public void onDateSet(DatePicker view, int year, int month, int day) {
    		// Do something with the date chosen by the user
    		editTextFecha.setText(formatoMes(day)+"/"+formatoMes(month+1)+"/"+year);
    	}
    	
    	private String formatoMes(int mes){
    		int mesReal=mes;
    		String mesString="";
    		if(mesReal<10){
    			mesString+="0";
    		}
    		mesString+=String.valueOf(mesReal);
    		return mesString;
    	}
    }

}
