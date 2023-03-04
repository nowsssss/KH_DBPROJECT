package vo;

import java.sql.Date;

public class FreeBoardVO {
    private int writeNum;
    private String nickname;
    private String writeTitle;
    private String writeContents;
    private Date regDate;

    public FreeBoardVO() {
    }

    public FreeBoardVO(int writeNum, String nickname, String writeTitle, String writeContents, Date regDate) {
        this.writeNum = writeNum;
        this.nickname = nickname;
        this.writeTitle = writeTitle;
        this.writeContents = writeContents;
        this.regDate = regDate;
    }

    public int getWriteNum() {
        return writeNum;
    }

    public void setWriteNum(int writeNum) {
        this.writeNum = writeNum;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getWriteTitle() {
        return writeTitle;
    }

    public void setWriteTitle(String writeTitle) {
        this.writeTitle = writeTitle;
    }

    public String getWriteContents() {
        return writeContents;
    }

    public void setWriteContents(String writeContents) {
        this.writeContents = writeContents;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
