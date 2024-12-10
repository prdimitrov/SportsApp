package com.example.sportsapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsapp.adapter.CustomAdapter;
import com.example.sportsapp.model.Sport;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //1 - Adapter View
    private RecyclerView recyclerView;
    //2 - Data Source
    private List<Sport> sportList;

    //3 - Adapter
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        sportList = new ArrayList<>();

        Sport sOne = new Sport("Football", R.drawable.football);
        Sport sTwo = new Sport("Basketball", R.drawable.basketball);
        Sport sThree = new Sport("Volleyball", R.drawable.volley);
        Sport sFour = new Sport("Tennis", R.drawable.tennis);
        Sport sFive = new Sport("Ping Pong", R.drawable.ping);

        sportList.add(sOne);
        sportList.add(sTwo);
        sportList.add(sThree);
        sportList.add(sFour);
        sportList.add(sFive);

//        customAdapter = new CustomAdapter(sportList);
        customAdapter = new CustomAdapter(sportList, v -> {
            Sport clickedSport = (Sport) v.getTag(); // Retrieve the sport object from the tag
            Toast.makeText(this, "You selected: " + clickedSport.getSportName(), Toast.LENGTH_SHORT).show();
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}