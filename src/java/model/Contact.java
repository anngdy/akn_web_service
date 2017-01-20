package model;

import java.sql.Date;

public class Contact extends User{
        
    private String message;
    private Date new_date;

    public Contact() {
    }

    public Contact(int id, String name, String cpf, String email) {
        super(id, name, cpf, email);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getNew_date() {
        return new_date;
    }

    public void setNew_date(Date new_date) {
        this.new_date = new_date;
    }
    
}
