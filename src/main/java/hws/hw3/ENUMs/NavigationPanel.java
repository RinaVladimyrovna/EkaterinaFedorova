package hws.hw3.ENUMs;

public enum NavigationPanel {

    NAVIGATION("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    public final String home;
    public final String contact;
    public final String service;
    public final String material;

    NavigationPanel(String home, String contact, String service, String material) {
        this.home = home;
        this.contact = contact;
        this.service = service;
        this.material = material;
    }
}
