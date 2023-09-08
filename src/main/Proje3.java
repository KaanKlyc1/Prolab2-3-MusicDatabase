package main;

import javax.swing.table.DefaultTableModel;

public class Proje3 {

    static Giriş_seçimi Giriş_seçimi= null;
    static GirişEkranı GirişEkranı = null;
    static GirişEkranı1 GirişEkranı1 = null;
    static KayıtEkranı KayıtEkranı = null;
    static AdminPanel AdminPanel = null;
    static Albümler Albümler = null;
    static Şarkılar Şarkılar = null;
    static Sanatçılar Sanatçılar = null;
    static İlişkiler İlişkiler = null;
    static KullanıcıPanel KullanıcıPanel = null;
    static KullanıcıTop10 KullanıcıTop10 = null;
    static KullanıcıSanatçı KullanıcıSanatçı = null;
    static KullanıcıAlbüm KullanıcıAlbüm = null;
    static KullanıcıŞarkı KullanıcıŞarkı = null;
    static Profil Profil = null;
    static Kullanıcılar Kullanıcılar = null;
    
    static int girilenKullanıcıID;
    static DefaultTableModel seçilentablo= null;
    
    static String girilenKullanıcıAdı = null; 
    static int profilID;
    static int seçilen;
    
    public static void main(String[] args) {
        Veritabanı.bağlantıYap();
        Giriş_seçimi = new Giriş_seçimi();
        Giriş_seçimi.setLocationRelativeTo(null);
        Giriş_seçimi.setVisible(true);
    }
    
}
