package mobi.ms2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mobi.ms2.enums.Ms;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String id;
    private String body;
    private Ms source;
    private Ms destination;

}
