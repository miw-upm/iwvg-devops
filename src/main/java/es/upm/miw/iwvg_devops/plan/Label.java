package es.upm.miw.iwvg_devops.plan;

public class Label {

    private String name;

    private String description;

    private String color;

    public Label() {
    }

    public Label(String name, String description, String color) {
        this.name = name;
        this.description = description;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Label{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
