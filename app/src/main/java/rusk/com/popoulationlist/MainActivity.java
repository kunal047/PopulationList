package rusk.com.popoulationlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rusk.com.popoulationlist.model.WorldPopulation;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private WorldPopulationAdapter worldPopulationAdapter;
    private ArrayList<WorldPopulation> worldPopulationList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recylerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

//        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        worldPopulationList = new ArrayList<>();

        ApiService api = RetroClient.getApiService();

        Call<WorldPopulationList> call = api.getMyJSON();

        call.enqueue(new Callback<WorldPopulationList>() {
            @Override
            public void onResponse(Call<WorldPopulationList> call, Response<WorldPopulationList> response) {
                if (response.isSuccessful()) {
                    worldPopulationList = response.body().getWorldPopulation();
                    worldPopulationAdapter = new WorldPopulationAdapter(MainActivity.this, worldPopulationList);
                    recyclerView.setAdapter(worldPopulationAdapter);

                }
            }

            @Override
            public void onFailure(Call<WorldPopulationList> call, Throwable t) {

            }
        });


//        worldPopulationAdapter = new WorldPopulationAdapter()
    }
}
