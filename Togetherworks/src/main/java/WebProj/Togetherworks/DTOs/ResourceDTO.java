package WebProj.Togetherworks.DTOs;

import WebProj.Togetherworks.enums.Type;
import lombok.Data;

@Data
public class ResourceDTO {
    private Type type;

    private int quantity;

    private String project_name;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
}
