package com.gitara.Inventory;

public enum ProjectionType {
     Premiere, OpeningWeek, _3D, _4D, Repetition, Last3Days;

    public ProjectionType getType (int choice) {
        ProjectionType [] types = {Premiere, _3D, _4D, Repetition, OpeningWeek, Last3Days};
        return types[choice-1];
    }

}
