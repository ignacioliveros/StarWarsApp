package com.example.ignacio.starwarsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ignacio on 2/13/2018.
 */

public class People implements Parcelable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mass")
        @Expose
        private Integer mass;
        @SerializedName("hair_color")
        @Expose
        private String hairColor;
        @SerializedName("skin_color")
        @Expose
        private String skinColor;
        @SerializedName("eye_color")
        @Expose
        private String eyeColor;
        @SerializedName("birth_year")
        @Expose
        private String birthYear;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("homeworld")
        @Expose
        private String homeworld;
        @SerializedName("films")
        @Expose
        private List<String> films = null;
        @SerializedName("species")
        @Expose
        private List<String> species = null;
        @SerializedName("vehicles")
        @Expose
        private List<String> vehicles = null;
        @SerializedName("starships")
        @Expose
        private List<String> starships = null;
        @SerializedName("created")
        @Expose
        private String created;
        @SerializedName("edited")
        @Expose
        private String edited;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getMass() {
            return mass;
        }

        public void setMass(Integer mass) {
            this.mass = mass;
        }

        public String getHairColor() {
            return hairColor;
        }

        public void setHairColor(String hairColor) {
            this.hairColor = hairColor;
        }

        public String getSkinColor() {
            return skinColor;
        }

        public void setSkinColor(String skinColor) {
            this.skinColor = skinColor;
        }

        public String getEyeColor() {
            return eyeColor;
        }

        public void setEyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
        }

        public String getBirthYear() {
            return birthYear;
        }

        public void setBirthYear(String birthYear) {
            this.birthYear = birthYear;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getHomeworld() {
            return homeworld;
        }

        public void setHomeworld(String homeworld) {
            this.homeworld = homeworld;
        }

        public List<String> getFilms() {
            return films;
        }

        public void setFilms(List<String> films) {
            this.films = films;
        }

        public List<String> getSpecies() {
            return species;
        }

        public void setSpecies(List<String> species) {
            this.species = species;
        }

        public List<String> getVehicles() {
            return vehicles;
        }

        public void setVehicles(List<String> vehicles) {
            this.vehicles = vehicles;
        }

        public List<String> getStarships() {
            return starships;
        }

        public void setStarships(List<String> starships) {
            this.starships = starships;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getEdited() {
            return edited;
        }

        public void setEdited(String edited) {
            this.edited = edited;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeValue(this.height);
        dest.writeValue(this.mass);
        dest.writeString(this.hairColor);
        dest.writeString(this.skinColor);
        dest.writeString(this.eyeColor);
        dest.writeString(this.birthYear);
        dest.writeString(this.gender);
        dest.writeString(this.homeworld);
        dest.writeStringList(this.films);
        dest.writeStringList(this.species);
        dest.writeStringList(this.vehicles);
        dest.writeStringList(this.starships);
        dest.writeString(this.created);
        dest.writeString(this.edited);
        dest.writeString(this.url);
    }

    public People() {
    }

    protected People(Parcel in) {
        this.name = in.readString();
        this.height = (Integer) in.readValue(Integer.class.getClassLoader());
        this.mass = (Integer) in.readValue(Integer.class.getClassLoader());
        this.hairColor = in.readString();
        this.skinColor = in.readString();
        this.eyeColor = in.readString();
        this.birthYear = in.readString();
        this.gender = in.readString();
        this.homeworld = in.readString();
        this.films = in.createStringArrayList();
        this.species = in.createStringArrayList();
        this.vehicles = in.createStringArrayList();
        this.starships = in.createStringArrayList();
        this.created = in.readString();
        this.edited = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<People> CREATOR = new Parcelable.Creator<People>() {
        @Override
        public People createFromParcel(Parcel source) {
            return new People(source);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };
}
