package com.example.coursjavabdd;

public class Notes {
    private long id;
    private String prenom;
    private float maths;
    private float svt;
    private float histoire;

    public float getMaths() {
        return maths;
    }

    public void setMaths(float maths) {
        this.maths = maths;
    }

    public float getSvt() {
        return svt;
    }

    public void setSvt(float svt) {
        this.svt = svt;
    }

    public float getHistoire() {
        return histoire;
    }

    public void setHistoire(float histoire) {
        this.histoire = histoire;
    }
// A compléter avec les autres variables, leurs getters et leurs setters. Pensez que vous pouvez les générer automatiquement

    public void setId(long id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String toString() {
        return prenom;
    }

    public long getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

}