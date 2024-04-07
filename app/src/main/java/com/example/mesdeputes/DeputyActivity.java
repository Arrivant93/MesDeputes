package com.example.mesdeputes;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DeputyActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewName, textViewCirco, textViewEmail,textViewSite,textViewMandat_debut,textViewCollaborateurs, textViewGroupe;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deputy);
        textViewName= findViewById(R.id.textViewDeputyName);
        textViewCirco= findViewById(R.id.textViewDeputyCirco);
        textViewGroupe= findViewById(R.id.textViewDeputyGroupe);
        textViewEmail= findViewById(R.id.textViewDeputyEmail);
        textViewSite = findViewById(R.id.textViewItemDeputySite);
        textViewMandat_debut= findViewById(R.id.textViewDeputyMandat_debut);
        textViewCollaborateurs = findViewById(R.id.textViewDeputyCollaborateurs);
        imageView= findViewById(R.id.imageViewDeputy);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Deputy deputy= (Deputy) getIntent().getSerializableExtra("deputy");
        textViewName.setText(deputy.getFirstname()+" "+deputy.getLastname());
        textViewCirco.setText(deputy.getDepartment()+", "+
                deputy.getNameCirco()+ " "+ deputy.getNumCirco()+
                (deputy.getNumCirco()==1? "er": "eme")+" circoncription");
        textViewGroupe.setText(deputy.getGroupe());
        textViewMandat_debut.setText(deputy.getMandat_debut());
        textViewCollaborateurs.setText(deputy.getCollaborateurs());
        textViewEmail.setText(deputy.getEmail());
        textViewSite.setText(deputy.getSite());
        ApiServices.loadDeputyAvatar(this, deputy.getNameForAvatar(), imageView);
    }
}
