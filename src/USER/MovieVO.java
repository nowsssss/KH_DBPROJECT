package USER;

import java.sql.Date;

public class MovieVO {
    private int movieID; // 아이디
    private String title; // 영화제목
    private Date date; // 개봉일
    private int runtime; // 상영시간
    private String genre; // 장르
    private String director; // 감독
    private String cast; // 출연배우

    public MovieVO(int movieID, String title, Date date, int runtime, String genre, String director, String cast) {
        this.movieID = movieID;
        this.title = title;
        this.date = date;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.cast = cast;

    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }
}
