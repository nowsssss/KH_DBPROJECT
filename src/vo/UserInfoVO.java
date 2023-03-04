package vo;

public class UserInfoVO {
    private String id; // LOGIN_ID
    private String pw; // LOGIN_PW
    private String nick; // NICKNAME
    private String email; // EMAIL
    private String phone; // PHONE

    public UserInfoVO(String id, String pw, String nick, String email, String phone) {
        this.id = id;
        this.pw = pw;
        this.nick = nick;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}