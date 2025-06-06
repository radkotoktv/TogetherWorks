package WebProj.Togetherworks.DTOs;

import WebProj.Togetherworks.enums.Type;
import lombok.Data;

@Data
public class ResourceDTO {
    private Type type;

    private int quantity;

    private String project_name;
}
