package adportal.adModel;

import java.util.Date;
import java.util.Objects;

public class Ad {

    private String title;
    private String text;
    private double price;
    private Date date;
    private Category category;
    private User user;

    public Ad(String title, String text, double price, Date date, Category category, User user) {
        this.title = title;
        this.text = text;
        this.price = price;
        this.date = date;
        this.category = category;
        this.user = user;
    }

    public Ad() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return Double.compare(ad.price, price) == 0 && Objects.equals(title, ad.title) && Objects.equals(text, ad.text) && Objects.equals(date, ad.date) && category == ad.category && Objects.equals(user, ad.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text, price, date, category, user);
    }

    @Override
    public String toString() {
        return "Ad{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", category=" + category +
                ", user=" + user +
                '}';
    }
}
