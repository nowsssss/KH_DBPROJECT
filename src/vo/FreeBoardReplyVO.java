package vo;

import java.sql.Date;

public class FreeBoardReplyVO {
    private int writeNum;
    private int replyNum;
    private String nickname;
    private String replyWrite;
    private Date regDate;

    public FreeBoardReplyVO(int writeNum, int replyNum, String nickname, String replyWrite, Date regDate) {
        this.writeNum = writeNum;
        this.replyNum = replyNum;
        this.nickname = nickname;
        this.replyWrite = replyWrite;
        this.regDate = regDate;
    }

    public int getWriteNum() {
        return writeNum;
    }

    public void setWriteNum(int writeNum) {
        this.writeNum = writeNum;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getReplyWrite() {
        return replyWrite;
    }

    public void setReplyWrite(String replyWrite) {
        this.replyWrite = replyWrite;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
