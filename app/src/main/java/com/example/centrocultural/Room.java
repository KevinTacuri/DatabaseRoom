package com.example.centrocultural;

import java.util.List;

public class Room {
    private String name;
    private List<Painting> paintings;
    private boolean isExpanded;

    public Room(String name, List<Painting> paintings) {
        this.name = name;
        this.paintings = paintings;
        this.isExpanded = false;
    }

    public String getName() {
        return name;
    }

    public List<Painting> getPaintings() {
        return paintings;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
