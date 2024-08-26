package springsocket.k2.DTO;

public class NumberDTO {
    public long Id;
    public String identifier;
    public long value;

    public NumberDTO(long id, String identifier, long value) {
        Id = id;
        this.identifier = identifier;
        this.value = value;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
