package pl.javastart.cookbook.entity;

public enum Category {
    PASTA ("Makarony", "cos na szybko", "https://www.kwestiasmaku.com/sites/kwestiasmaku.com/files/makaron_wolowina_fasolka_01_0.jpg"),
    SEEFOOD ("Owoce morza", "bardzo ciekawe smaki", "https://cdn.galleries.smcloud.net/t/galleries/gf-U1Dz-bWxi-pnth_owoce-morza-rodzaje-i-sposoby-przyrzadzania-1920x1080-nocrop.jpg"),
    FASTFOOD ("Fastfood", "bardzo bardzo szybko i niezdrowo", "https://i.iplsc.com/duze-ilosci-soli-moga-prowadzic-do-wielu-groznych-chorob/0001JO9RXNKSCDT1-C122-F4.jpg");

    String categoryName;
    String descriptionn;
    String image;

    Category(String categoryName, String descriptionn, String image) {
        this.categoryName = categoryName;
        this.descriptionn = descriptionn;
        this.image = image;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescriptionn() {
        return descriptionn;
    }

    public void setDescriptionn(String descriptionn) {
        this.descriptionn = descriptionn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
