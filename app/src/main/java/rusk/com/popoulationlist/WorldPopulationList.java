package rusk.com.popoulationlist;

/**
 * Created by kunal on 17-06-2017.
 */
import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import rusk.com.popoulationlist.model.WorldPopulation;

public class WorldPopulationList {

    @SerializedName("worldpopulation")
    @Expose
    private ArrayList<WorldPopulation> worldPopulation = new ArrayList<>();


    public ArrayList<WorldPopulation> getWorldPopulation() {
        return worldPopulation;
    }

    public void setWorldPopulation(ArrayList<WorldPopulation> worldPopulation) {
        this.worldPopulation = worldPopulation;
    }


}