package com.example.coursjavabdd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class getResultActivity extends ListActivity {
    private NotesDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_result); //Votre layout où est votre ListView
        datasource = new NotesDataSource(this);
        datasource.open();
        List<Notes> values = datasource.getAllNotes();

        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

        for(int compteur=0; compteur<values.size();compteur++){
            HashMap<String,String> temp = new HashMap<String,String>();
            temp.put("prenom",values.get(compteur).getPrenom());
            temp.put("maths", String.valueOf(values.get(compteur).getMaths()));
            temp.put("svt", String.valueOf(values.get(compteur).getSvt()));
            temp.put("histoire", String.valueOf(values.get(compteur).getHistoire()));
            //vos variables

            list.add(temp);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                R.layout.listview_perso, // Nom du fichier de votre ListView personnalisée
                new String[] {"prenom", "maths", "svt", "histoire"}, // à compléter avec vos autres variables
                new int[] {R.id.prenom, R.id.maths, R.id.svt, R.id.histoire}

        );

        setListAdapter(adapter);

    }
}