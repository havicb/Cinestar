package com.gitara.Inventory;

public enum Genre {
    COMEDY, ACTION, HORROR, DRAMA, WAR, BIOGRAPHY, ADVENTURE;

    @Override
    public String toString() {
        switch(this) {
            case COMEDY:
                return "Comedy";
            case ACTION:
                return "Action";
            case HORROR:
                return "Horror";
            case DRAMA:
                return "Drama";
            case WAR:
                return "War";
            case BIOGRAPHY:
                return "Biography";
            case ADVENTURE:
                return "Adventure";
        }
        return "";
    }

    public Genre getGenre (int choice) {
        Genre [] genres = {COMEDY, ACTION, HORROR, DRAMA, WAR, BIOGRAPHY, ADVENTURE};
        return genres[choice-1];
    }

}
