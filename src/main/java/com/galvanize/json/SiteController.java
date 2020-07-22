package com.galvanize.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SiteController {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Movie {

        @JsonProperty("Title")
        private String title;

        @JsonProperty("Minutes")
        private int minutes;

        @JsonProperty("Genre")
        private String genre;

        @JsonProperty("Rating")
        private double rating;

        @JsonProperty("Metascore")
        private int score;

        @JsonProperty("Description")
        private String description;

        @JsonProperty("Votes")
        private long votes;

        @JsonProperty("Gross")
        private double gross;

        @JsonProperty("Year")
        private String year;

        @JsonProperty("Credits")
        private List<Person> credits;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public long getVotes() {
            return votes;
        }

        public void setVotes(long votes) {
            this.votes = votes;
        }

        public double getGross() {
            return gross;
        }

        public void setGross(double gross) {
            this.gross = gross;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public List<Person> getCredits() {
            return credits;
        }

        public void setCredits(List<Person> credits) {
            this.credits = credits;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Person {
        @JsonProperty("Role")
        private String role;

        @JsonProperty("FirstName")
        private String firstName;

        @JsonProperty("LastName")
        private String lastName;

        public Person(String role, String first, String last) {
            this.role = role;
            this.firstName = first;
            this.lastName = last;
        }

        public String getRole() {
            return role;
        }

        //@JsonProperty("Role")
        public void setRole(String role) {
            this.role = role;
        }

        public String getFirstName() {
            return firstName;
        }

        //@JsonProperty("FirstName")
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

       // @JsonProperty("LastName")
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    @GetMapping("/movies/movie")
    public Movie getMovie() {
        Movie m1 = new Movie();
        m1.setTitle("The Godfather");
        m1.setMinutes(175);
        m1.setGenre("Crime, Drama");
        m1.setRating(9.2);
        m1.setScore(100);
        m1.setDescription("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
        m1.setVotes(1561591);
        m1.setGross(134.97);
        m1.setYear("1972");
        m1.setCredits(Arrays.asList(new Person("Director", "Francis Ford", "Copolla"),
                new Person("Star", "Marlon", "Brando"), new Person("Star", "Al", "Pacino"),
                new Person("Star", "James", "Caan"), new Person("Star", "Diane", "Keaton")));

        return m1;
    }

    static class Total {

        @JsonProperty("result")
        private int total;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    @PostMapping("/movies/gross/total")
    public Total getMoviesGross(@RequestBody Movie[] movies) {

        int total = 0;
        for (Movie m : movies) {
            total += (int)m.getGross();
        }
        Total retVal = new Total();
        retVal.setTotal(total);
        return retVal;
    }


}
