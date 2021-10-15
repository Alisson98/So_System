package fernandes.alisson.sosystem.domain.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Status {
    OPEN(0, "OPEN"),
    PROGRESS(1, "PROGRESS"),
    CLOSED(2, "CLOSED");

    private Integer code;
    private String  desc;

    public static Status toEnum(Integer code){
        if(code == null)return null ;
        for(Status x : Status.values()){
            if(code.equals(x.getCode())){
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid Status!!" + code);
    }
}
