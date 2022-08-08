package mobi.ms1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mobi.ms1.enums.Ms;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String id;
    private String body;
    private Ms source;
    private Ms destination;

}
