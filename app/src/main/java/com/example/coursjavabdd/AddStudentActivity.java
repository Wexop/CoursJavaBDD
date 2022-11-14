package com.example.coursjavabdd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStudentActivity extends AppCompatActivity {

    private Button valideNote;
    private NotesDataSource notesDataSource;
    private EditText inputPrenom;
    private EditText inputMaths;
    private EditText inputSVT;
    private EditText inputHistoire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        inputPrenom = (EditText) findViewById(R.id.inputName);
        inputMaths = (EditText) findViewById(R.id.inputNote1);
        inputSVT = (EditText) findViewById(R.id.inputNote2);
        inputHistoire = (EditText) findViewById(R.id.inputNote3);

        notesDataSource = new NotesDataSource(this);
        notesDataSource.open();

        valideNote = (Button) findViewById(R.id.button_send_result);

        valideNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String prenom = inputPrenom.getText().toString();
                float maths = Float.valueOf(inputMaths.getText().toString());
                float svt = Float.valueOf(inputSVT.getText().toString());
                float histoire = Float.valueOf(inputHistoire.getText().toString());

                notesDataSource.createNotes(prenom, maths, svt, histoire);

            }
        });


    }
}