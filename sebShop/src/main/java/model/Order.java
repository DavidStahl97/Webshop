package model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

    private String user;
    private double totalprice;
    private String date;
    private List<Article> articles;


    private static final long serialVersionUID = 3373981139157922935L;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }





}
