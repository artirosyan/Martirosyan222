package adportal.storage;

import adportal.adModel.Ad;
import adportal.adModel.Category;
import adportal.adModel.User;

public interface Adstorage {

    void add(Ad ad);

    void pritAllAds();

    void printMyAds(User user);

    void printByCategory(Category category);

    void deleteMyAds(User user);

    void deleteAdByTitle(String title, User crrentUser);


}
