package USER;

public class GradeVO {
    private int movieID;
    private int grade;
    private String comment;
    private String nickname;

    public GradeVO(int movieID, int grade, String comment, String nickname) {
        this.movieID = movieID;
        this.grade = grade;
        this.comment = comment;
        this.nickname = nickname;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
