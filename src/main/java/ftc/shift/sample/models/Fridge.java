package ftc.shift.sample.models;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
public final class Fridge implements Serializable{
    private HashMap<String, Product> products;
}
