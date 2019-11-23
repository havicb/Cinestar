package com.gitara.Inventory;

public enum Genre {
    Comedy, Action, Horror, Drama, War, Biography, Adventure, Romance;


    public Genre getGenre (int choice) {
        Genre [] genres = {Comedy, Action, Horror, Drama, War, Biography, Adventure, Romance};
        return genres[choice-1];
    }

}
