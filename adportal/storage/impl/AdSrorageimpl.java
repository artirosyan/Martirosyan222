package adportal.storage.impl;

import adportal.adModel.Ad;
import adportal.adModel.Category;
import adportal.adModel.User;
import adportal.storage.Adstorage;

import java.util.LinkedList;
import java.util.List;

public class AdSrorageimpl implements Adstorage {


    private List<Ad> adList = new LinkedList<>();

    @Override
    public void add(Ad ad) {
        adList.add(ad);
    }

    @Override
    public void pritAllAds() {
        System.out.println(adList);
    }

    @Override
    public void printMyAds(User user) {
        for (Ad ad : adList) {
            if (ad.getUser().equals(user)) {
                System.out.println(ad);
            }
        }
    }

    @Override
    public void printByCategory(Category category) {
        for (Ad ad : adList) {
            if (ad.getCategory() == category) {
                System.out.println(ad);
            }
        }
    }

    @Override
    public void deleteMyAds(User user) {
        for (Ad ad : adList) {
            if (ad.getUser().equals(user)) {
                adList.remove(ad);
            }
        }
    }

    @Override
    public void deleteAdByTitle(String title, User crrentUser) {
        for (Ad ad : adList) {
            if (ad.getTitle().equals(title) && ad.getUser().equals(crrentUser)) {
                adList.remove(ad);
            }
        }
    }
}
